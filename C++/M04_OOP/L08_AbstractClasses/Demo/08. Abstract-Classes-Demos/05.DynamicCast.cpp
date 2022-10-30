#include <string>
#include <sstream>
#include <vector>
#include <utility>
#include <iostream>

class Describable {
public:
	virtual std::string getDescription() const = 0;

	virtual ~Describable() {}
};

class Company : public Describable {
private:
	int id;
	std::string name;
	std::vector<std::pair<char, char> > employees;

public:
	Company(int id, std::string name, std::vector<std::pair<char, char> > employees)
		: id(id)
		, name(name)
		, employees(employees) {}

	std::string getDescription() const override {
		std::ostringstream stream;
		stream << id << " " << name << " ";

		for (int i = 0; i < employees.size(); i++) {
			auto initials = employees[i];
			stream << initials.first << initials.second;
			if (i < employees.size() - 1) {
				stream << " ";
			}
		}

		return stream.str();
	}
};

class Organism {
public:
	float weight;
	bool eatsPlants;
	bool eatsAnimals;

	Organism(float weight, bool eatsPlants, bool eatsAnimals)
		: weight(weight), eatsPlants(eatsPlants), eatsAnimals(eatsAnimals) {}

	virtual void mutate() = 0;

	virtual ~Organism() {}
};

class Spider : public Organism, public Describable {
	int numLegs;
public:
	Spider(int numLegs, float weight)
		: Organism(weight, false, true)
		, numLegs(numLegs) {}

	void mutate() override {
		this->numLegs++;
	}

	std::string getDescription() const override {
		std::ostringstream description;

		description << numLegs << "-legged spider, weight: " << this->weight;

		return description.str();
	}
};

void printDescription(const Describable& d) {
	std::cout << d.getDescription() << std::endl;
}

int main() {
	Spider spider(6, 0.042);
	Company company(42, "TheAnswer Ltd.", std::vector<std::pair<char, char> > { { 'G', 'G' }, { 'B', 'D' } });

	Organism* spiderUpcastToOrganism = dynamic_cast<Organism*>(&spider);
	Company* spiderCastToCompany = dynamic_cast<Company*>(&spider);
	Organism* spiderUpcastToDescribable = dynamic_cast<Organism*>(&spider);
	Describable* companyUpcastToDescribable = dynamic_cast<Describable*>(&company);
	Spider* companyUpcastToDescribableDowncastToSpider = dynamic_cast<Spider*>(companyUpcastToDescribable);

	// print addresses, note that the failed casts will be null
	std::cout << spiderUpcastToOrganism << std::endl;
	std::cout << spiderCastToCompany << std::endl;
	std::cout << spiderUpcastToDescribable << std::endl;
	std::cout << companyUpcastToDescribable << std::endl;
	std::cout << companyUpcastToDescribableDowncastToSpider << std::endl;

	return 0;
}
