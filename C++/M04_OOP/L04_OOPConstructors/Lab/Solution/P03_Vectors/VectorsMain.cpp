#include <iostream>
#include <set>

#include "Vector.h"
#include "VectorComparisons.h"

int main() {
	int numVectors;
	std::cin >> numVectors;

	std::multiset<Vector, ReverseComparer<Vector, VectorLengthComparer> > vectors;
	for (int i = 0; i < numVectors; i++) {
		Vector v;
		std::cin >> v;
		vectors.insert(v);
	}

	for (auto v : vectors) {
		std::cout << v << std::endl;
	}

	return 0;
}