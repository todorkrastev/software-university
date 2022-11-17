#ifndef FILE_H
#define FILE_H

#include <cstdlib>
#include <string>

#include "FileSystemObject.h"
#include "ByteContainer.h"

class File : public FileSystemObject, public ByteContainer {
	std::string bytes;
public:
	File(std::string name, std::string bytes) : FileSystemObject(name), bytes(bytes) {}

	std::string getBytes() const override {
		return this->bytes;
	}

	size_t getSize() const override {
		return this->getBytes().size();
	}
};

#endif // !FILE_H

