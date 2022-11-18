#ifndef FILE_SYSTEM_OBJECT_H
#define FILE_SYSTEM_OBJECT_H

#include <memory>
#include <string>

class FileSystemObject {
	std::weak_ptr<FileSystemObject> parent;
	std::string name;
public:
	FileSystemObject(std::string name) : name(name) {}

	std::string getPath() const {
		auto parentPtr = parent.lock();
		if (parent.lock()) {
			return parentPtr->getPath() + "/" + this->name;
		} else {
			return this->name;
		}
	}

	std::string getName() const {
		return this->name;
	}

	virtual void setParent(const std::weak_ptr<FileSystemObject>& parent) {
		this->parent = parent;
	}

	virtual std::weak_ptr<FileSystemObject> getParent() const {
		return this->parent;
	}

	virtual size_t getSize() const = 0;

	virtual ~FileSystemObject() {}
};

#endif // !FILE_SYSTEM_OBJECT_H

