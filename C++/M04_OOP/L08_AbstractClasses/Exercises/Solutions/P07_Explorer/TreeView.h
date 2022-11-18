#ifndef TREE_VIEW_H
#define TREE_VIEW_H

#include <memory>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>

#include "FileSystemObject.h"
#include "FileSystemObjectsContainer.h"

void renderTreeView(const std::shared_ptr<FileSystemObject>& root, int levelsIn, std::ostringstream& output) {
	for (int i = 0; i < levelsIn; i++) {
		output << "--->";
	}
	output << root->getName() << std::endl;

	auto asContainer = std::dynamic_pointer_cast<FileSystemObjectsContainer>(root);
	if (asContainer) {
		std::vector<std::shared_ptr<FileSystemObject> > nameSorted(asContainer->begin(), asContainer->end());
		std::sort(nameSorted.begin(), nameSorted.end(), [](const std::shared_ptr<FileSystemObject> a, const std::shared_ptr<FileSystemObject> b) {
			return a->getName() < b->getName();
		});

		for (auto fso : nameSorted) {
			renderTreeView(fso, levelsIn + 1, output);
		}
	}
}

std::string getTreeView(const std::vector<std::shared_ptr<FileSystemObject> >& rootObjects) {
	std::ostringstream treeView;

	for (auto root : rootObjects) {
		renderTreeView(root, 0, treeView);
	}

	return treeView.str();
}

#endif // !TREE_VIEW_H

