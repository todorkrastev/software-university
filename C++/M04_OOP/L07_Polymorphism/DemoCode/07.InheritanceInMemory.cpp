#include <iostream>

class Organism {
public:
	float weight;
	bool eatsPlants;
	bool eatsAnimals;

	Organism(float weight, bool eatsPlants, bool eatsAnimals)
		: weight(weight), eatsPlants(eatsPlants), eatsAnimals(eatsAnimals) {}
};

class Spider : public Organism {
public:
	int numLegs;
	float weight; // NOTE: hiding weight field from Organism

	Spider(int numLegs, float weight)
		: Organism(weight, false, true)
		, numLegs(numLegs) {}
};

int main() {
	Organism cow(720, true, false);

	Spider s(6, 0.042);
	Organism *oPtr = &s;
	oPtr->weight;
	oPtr->eatsPlants;
	//oPtr->numLegs; //compilation error
	Spider * sPtr = (Spider*)oPtr;
	sPtr->weight;

	// NOTE: cow has an actual size of 6 bytes, but padding/alignment will cause it to grow to next power of 2, which is 8 in this case
	std::cout << sizeof(cow) << std::endl;

	void* cowPtr = &cow;
	float* weight = static_cast<float*>(cowPtr);
	bool* eatsPlants = static_cast<bool*>(cowPtr) + sizeof(float);
	bool* eatsAnimals = eatsPlants + 1;

	std::cout << *weight << " " << *eatsPlants << " " << *eatsAnimals << std::endl;

	Organism* sBasePtr = &s;

	sPtr->weight = 0.042;
	std::cout << sBasePtr->weight << " vs. " << sPtr->weight << std::endl;

	return 0;
}
