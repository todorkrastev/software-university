#ifndef SHORTCUTS_H
#define SHORTCUTS_H

#include <vector>
#include <algorithm>
#include <memory>

#include "FileSystemObject.h"
#include "FileSystemObjectsContainer.h"

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

	void remove(std::shared_ptr<FileSystemObject> obj) override {
		this->items.erase(std::find(this->items.begin(), this->items.end(), obj));
	}

	size_t getSize() const override {
		return 0;
	}
};

#endif // !SHORTCUTS_H

