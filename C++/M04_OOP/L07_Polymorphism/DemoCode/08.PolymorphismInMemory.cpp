#include <iostream>
#include<string>
#include<sstream>

namespace Organisms {

	using std::string;
	using std::ostringstream;

	class Organism {
	protected:
		bool eatsPlants;
		bool eatsAnimals;
		double weight;
	public:

		Organism(double weight, bool eatsPlants, bool eatsAnimals) :
			eatsPlants(eatsPlants),
			eatsAnimals(eatsAnimals),
			weight(weight) {
		}

		virtual string getInfo() const {
			ostringstream stream;
			stream << "weight: " << this->weight << " ";
			if (this->eatsAnimals && this->eatsPlants) {
				stream << "(omnivore)";
			}
			else if (this->eatsAnimals) {
				stream << "(carnivore)";
			}
			else if (this->eatsPlants) {
				stream << "(herbivore)";
			}
			else {
				stream << "(plant)";
			}

			return stream.str();
		}

		virtual ~Organism() {}
	};

	class Sheep : public Organism {
	public:
		bool isBlack;
		Sheep(bool isBlack, double weight) :
			Organism(weight, true, false),
			isBlack(isBlack) {
		}

		string getInfo() const {
			ostringstream stream;
			stream << (this->isBlack ? "Black " : "White ") << " Sheep, " << Organism::getInfo();
			return stream.str();
		}
	};

	class Spider : public Organism {
		int numLegs;
	public:
		Spider(int numLegs, double weight) :
			Organism(weight, false, true),
			numLegs(numLegs) {
		}

		string getInfo() const {
			ostringstream stream;
			stream << this->numLegs << "-legged" << " Spider, " << Organism::getInfo();
			return stream.str();
		}
	};
}

int main() {
	using std::cout;
	using std::endl;
	using namespace Organisms;

	typedef Organism * OrganismPtr;

	// create a normal array of pointers to Organism objects (Oranism*) and fill it with objects of derived classes
	OrganismPtr organismsArr[3]{
		new Sheep(false, 80.0),
		new Spider(6, 80.0),
		new Sheep(true, 90.0)
	};

	for (int i = 0; i < 3; i++) {
		cout << organismsArr[i]->getInfo() << endl;
	}

	for (int i = 0; i < 3; i++) {
		delete organismsArr[i];
	}

	return 0;
}
