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
#include "Shortcuts.h"

#include "TreeView.h"

#include "Explorer.h"

std::string leftTrim(std::string s) {
	s.erase(s.begin(), std::find_if(s.begin(), s.end(), [](int c) {return !std::isspace(c); }));
	return s;
}

int main() {
	std::vector<std::shared_ptr<FileSystemObject> > rootObjects;

	Explorer explorer(rootObjects);

	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);

		std::string command;
		lineIn >> command;
		
		if (command == "mf") {
			std::string filename;
			lineIn >> filename;

			std::string contents;
			std::getline(lineIn, contents);

			explorer.createFile(filename, leftTrim(contents));
		} else if (command == "md") {
			std::string directory;
			lineIn >> directory;

			explorer.createDirectory(directory);
		} else if (command == "cut") {
			std::string name;
			lineIn >> name;

			explorer.cut(name);
		} else if (command == "paste") {
			explorer.paste();
		} else if (command == "sc") {
			std::string name;
			lineIn >> name;

			explorer.createShortcut(name);
		} else if (command == "cd") {
			std::string path;
			std::getline(lineIn, path);

			explorer.navigate(leftTrim(path));
		}
	}

	std::sort(rootObjects.begin(), rootObjects.end(), [](const std::shared_ptr<FileSystemObject> a, const std::shared_ptr<FileSystemObject> b) {
		return a->getName() < b->getName();
	});

	std::cout << getTreeView(rootObjects) << std::endl;

	return 0;
}