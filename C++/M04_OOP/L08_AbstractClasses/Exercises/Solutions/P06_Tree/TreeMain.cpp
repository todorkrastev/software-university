#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <memory>
#include <map>
#include <algorithm>
#include <cctype>

#include "FileSystemObject.h"
#include "ByteContainer.h"
#include "File.h"
#include "FileSystemObjectsContainer.h"
#include "Directory.h"

#include "TreeView.h"

std::string leftTrim(std::string s) {
	s.erase(s.begin(), std::find_if(s.begin(), s.end(), [](int c) {return !std::isspace(c); }));
	return s;
}

class Shortcuts : public FileSystemObject, public FileSystemObjectsContainer {
	std::vector<std::shared_ptr<FileSystemObject> > items;
public:
	Shortcuts() : FileSystemObject("[shortcuts]") {}

	void add(const std::shared_ptr<FileSystemObject>& obj) override {
		this->items.push_back(obj);
	}

	std::vector<std::shared_ptr<FileSystemObject> >::const_iterator begin() const override {
		return this->items.begin();
	}

	std::vector<std::shared_ptr<FileSystemObject> >::const_iterator end() const override {
		return this->items.end();
	}

	size_t getSize() const override {
		return 0;
	}
};

void moveTo(std::shared_ptr<FileSystemObject> obj, std::shared_ptr<Directory> container) {
	container->add(obj);
	obj->setParent(container);
}

int main() {
	std::map<int, std::shared_ptr<FileSystemObject> > objectsById;
	std::map<int, std::shared_ptr<Directory> > directoriesById;
	std::shared_ptr<Shortcuts> shortcuts;

	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);

		std::string command;
		int id;

		std::shared_ptr<FileSystemObject> newObject = nullptr;
		lineIn >> command;

		if (command == "file") {
			std::string filename;
			lineIn >> id >> filename ;

			std::string contents;
			std::getline(lineIn, contents);
			
			newObject = std::make_shared<File>(filename, contents);
		} else if (command == "directory") {
			std::string directory;
			lineIn >> id >> directory;

			std::shared_ptr<Directory> newDirectory = std::make_shared<Directory>(directory);
			directoriesById[id] = newDirectory;
			newObject = newDirectory;
		} else if (command == "move") {
			int destinationId;
			lineIn >> id >> destinationId;

			moveTo(objectsById[id], directoriesById[destinationId]);
		} else if (command == "shortcut") {
			int targetId;
			lineIn >> targetId;

			if (!shortcuts) {
				shortcuts = std::make_shared<Shortcuts>();
				newObject = shortcuts;
				// save the shortcuts object under a non-conflicting id
				id = -1;
			}

			shortcuts->add(objectsById[targetId]);
		}

		if (newObject) {
			objectsById[id] = newObject;
		}
	}

	std::vector<std::shared_ptr<FileSystemObject> > rootObjects;
	for (auto idAndObject : objectsById) {
		auto parentPtr = idAndObject.second->getParent().lock();
		if (!parentPtr) {
			rootObjects.push_back(idAndObject.second);
		}
	}

	std::sort(rootObjects.begin(), rootObjects.end(), [](const std::shared_ptr<FileSystemObject> a, const std::shared_ptr<FileSystemObject> b) {
		return a->getName() < b->getName();
	});

	std::cout << getTreeView(rootObjects) << std::endl;

	return 0;
}