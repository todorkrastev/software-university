#include <iostream>
#include <vector>
#include <set>
#include <map>

#include "ResourceType.h"
#include "Resource.h"
#include "Lecture.h"

int main() {
	using SoftUni::Resource;
	using SoftUni::Lecture;
	using SoftUni::ResourceType;

	Lecture lecture;
	std::map<ResourceType, int> numberOfResourcesByType;

	int numResources;

	std::cin >> numResources;

	for (int i = 0; i < numResources; i++) {
		Resource r;
		std::cin >> r;

		lecture << r;
	}

	std::cout << "... by id:" << std::endl;

	for (const Resource& r : lecture) {
		std::cout << r << std::endl;
	}

	std::cout << "... by type:" << std::endl;

	std::vector<ResourceType> resourceTypes;
	resourceTypes << lecture;

	for (ResourceType type : resourceTypes) {
		std::cout << type << ": " << lecture[type] << std::endl;
	}

	return 0;
}