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

std::string leftTrim(std::string s) {
	s.erase(s.begin(), std::find_if(s.begin(), s.end(), [](int c) {return !std::isspace(c); }));
	return s;
}

int main() {
	std::map<int, std::shared_ptr<FileSystemObject> > objectsById;
	std::map<int, std::shared_ptr<ByteContainer> > filesById;
	std::map<int, std::shared_ptr<FileSystemObjectsContainer> > containersById;

	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);

		std::string command;
		int id;

		std::shared_ptr<FileSystemObject> newObject = nullptr;
		lineIn >> command >> id;
		if (command == "file") {
			std::string filename, bytes;
			lineIn >> filename;
			std::getline(lineIn, bytes);

			std::shared_ptr<File> newFile(new File(filename, leftTrim(bytes)));
			filesById[id] = newFile;
			newObject = newFile;
		} else if (command == "directory") {
			std::string directory;
			lineIn >> directory;

			std::shared_ptr<Directory> newDirectory(new Directory(directory));
			containersById[id] = newDirectory;
			newObject = newDirectory;
		} else if (command == "copy") {
			int destinationId;
			lineIn >> destinationId;

			auto objPtr = objectsById[id];
			objPtr->setParent(objectsById[destinationId]);

			auto containerPtr = containersById[destinationId];
			containerPtr->add(objPtr);
		} else if (command == "size") {
			std::cout << objectsById[id]->getSize() << std::endl;
		} else if (command == "path") {
			std::cout << objectsById[id]->getPath() << std::endl;
		} else if (command == "print") {
			std::cout << filesById[id]->getBytes() << std::endl;
		} else {
			std::cout << "[unknown command]" << std::endl;
		}

		if (newObject) {
			objectsById[id] = newObject;
		}
	}

	return 0;
}