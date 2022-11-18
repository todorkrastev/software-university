#ifndef EXPLORER_H
#define EXPLORER_H

#include <vector>
#include <memory>
#include <algorithm>
#include <sstream>

#include "FileSystemObject.h"
#include "FileSystemObjectsContainer.h"
#include "Shortcuts.h"
#include "Directory.h"
#include "File.h"

class Root : public FileSystemObject, public FileSystemObjectsContainer {
	std::vector<std::shared_ptr<FileSystemObject> >& rootObjects;
public:
	Root(std::vector<std::shared_ptr<FileSystemObject> >& rootObjects) : FileSystemObject(""), rootObjects(rootObjects) {}

	void add(const std::shared_ptr<FileSystemObject>& obj) override {
		this->rootObjects.push_back(obj);
	}

	std::vector<std::shared_ptr<FileSystemObject> >::const_iterator begin() const override {
		return this->rootObjects.begin();
	}

	std::vector<std::shared_ptr<FileSystemObject> >::const_iterator end() const override {
		return this->rootObjects.end();
	}

	void setParent(const std::weak_ptr<FileSystemObject>& parent) override {
		// do nothing - the Root does not have a parent
	}

	std::weak_ptr<FileSystemObject> getParent() const override {
		// no parent
		return std::weak_ptr<FileSystemObject>();
	}

	size_t getSize() const override {
		return 0;
	}

	void remove(std::shared_ptr<FileSystemObject> obj) override {
		auto i = std::find(this->rootObjects.begin(), this->rootObjects.end(), obj);
		this->rootObjects.erase(i);
	}
};

class Explorer {
	std::vector<std::shared_ptr<FileSystemObject> > clipboard;
	std::shared_ptr<FileSystemObjectsContainer> currentDirectory;

	std::shared_ptr<Root> root;
	std::shared_ptr<Shortcuts> shortcuts;
public:
	Explorer(std::vector<std::shared_ptr<FileSystemObject> >& rootObjects) : root(std::make_shared<Root>(rootObjects)) {
		this->currentDirectory = root;
	}

	bool navigate(std::string path) {
		std::vector<std::string> parts = getPathParts(path);
		return this->navigate(parts, parts.end());
	}

	void cut(std::string name) {
		auto fso = this->find(name);
		this->clipboard.push_back(fso);
	}

	void paste() {
		for (auto fso : this->clipboard) {
			moveTo(fso, this->currentDirectory);
		}

		this->clipboard.clear();
	}

	void createDirectory(std::string name) {
		auto directory = std::make_shared<Directory>(name);
		this->currentDirectory->add(directory);
		directory->setParent(std::dynamic_pointer_cast<FileSystemObject>(this->currentDirectory));
	}

	void createFile(std::string name, std::string contents) {
		auto file = std::make_shared<File>(name, contents);
		this->currentDirectory->add(file);
		file->setParent(std::dynamic_pointer_cast<FileSystemObject>(this->currentDirectory));
	}

	void createShortcut(std::string name) {
		if (!this->shortcuts) {
			this->shortcuts = std::make_shared<Shortcuts>();
			this->root->add(this->shortcuts);
		}

		this->shortcuts->add(this->find(name));
	}
private:
	static std::vector<std::string> getPathParts(std::string path) {
		std::vector<std::string> parts;

		std::istringstream pathIn(path);
		std::string part;
		while (std::getline(pathIn, part, '/')) {
			parts.push_back(part);
		}

		return parts;
	}

	bool navigateSingleStep(std::string path) {
		if (path == "..") {
			auto currentAsFso = std::dynamic_pointer_cast<FileSystemObject>(this->currentDirectory);

			std::shared_ptr<FileSystemObject> parentPtr = (currentAsFso ? currentAsFso->getParent().lock() : std::shared_ptr<FileSystemObject>());

			if (parentPtr) {
				this->currentDirectory = std::dynamic_pointer_cast<FileSystemObjectsContainer>(parentPtr);
				return true;
			} else {
				auto asRoot = std::dynamic_pointer_cast<Root>(this->currentDirectory);
				if (asRoot) {
					return false;
				} else {
					this->currentDirectory = this->root;
					return true;
				}
			}

			return false;
		}

		auto fso = this->findIn(this->currentDirectory, path);

		auto nestedDir = std::dynamic_pointer_cast<FileSystemObjectsContainer>(fso);
		if (nestedDir) {
			this->currentDirectory = nestedDir;
			return true;
		}

		return false;
	}

	bool navigate(const std::vector<std::string>& path, std::vector<std::string>::iterator end) {
		for (auto i = path.begin(); i != end; i++) {
			bool navigated = this->navigateSingleStep(*i);
			if (!navigated) {
				return false;
			}
		}

		return true;
	}

	std::shared_ptr<FileSystemObject> find(std::string name) {
		return this->findIn(this->currentDirectory, name);
	}

	std::shared_ptr<FileSystemObject> findIn(std::shared_ptr<FileSystemObjectsContainer> dir, std::string name) {
		for (auto fso : *dir) {
			if (fso->getName() == name) {
				return fso;
			}
		}

		return nullptr;
	}

	void moveTo(std::shared_ptr<FileSystemObject> obj, std::shared_ptr<FileSystemObjectsContainer> container) {
		auto previousContainer = std::dynamic_pointer_cast<FileSystemObjectsContainer>(obj->getParent().lock());
		if (previousContainer) {
			previousContainer->remove(obj);
		} else {
			root->remove(obj);
		}

		container->add(obj);

		if (container != this->root) {
			obj->setParent(std::dynamic_pointer_cast<FileSystemObject>(container));
		}
	}
};

#endif // !EXPLORER_H

