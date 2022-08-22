#ifndef LECTURE_H
#define LECTURE_H

#include <string>
#include <map>
#include <set>
#include <vector>

#include "ResourceType.h"
#include "Resource.h"

namespace SoftUni {

	class Lecture {
	private:
		std::set<Resource> resources;
		std::map<ResourceType, int> numberOfResourcesByType;
	public:
		Lecture() {}

		std::set<Resource>::iterator begin() const {
			return resources.begin();
		}

		std::set<Resource>::iterator end() const {
			return resources.end();
		}

		void updateResource(Resource r) {
			if (this->resources.find(r) != this->resources.end()) {
				this->resources.erase(r);
				numberOfResourcesByType[r.getType()]--;
			}

			auto iteratorAndSuccess = this->resources.insert(r);
			numberOfResourcesByType[r.getType()]++;
		}

		int operator[](ResourceType t) const {
			return numberOfResourcesByType.at(t);
		}

		friend std::vector<ResourceType>& operator<<(std::vector<ResourceType>& v, const Lecture& lecture);
	};

	Lecture& operator<<(Lecture& lecture, Resource resource) {
		lecture.updateResource(resource);

		return lecture;
	}

	std::vector<ResourceType>& operator<<(std::vector<ResourceType>& v, const Lecture& lecture) {
		for (auto pair : lecture.numberOfResourcesByType) {
			v.push_back(pair.first);
		}

		return v;
	}
}

#endif // !LECTURE_H

