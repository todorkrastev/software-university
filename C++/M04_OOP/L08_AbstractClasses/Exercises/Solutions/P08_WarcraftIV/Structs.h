#ifndef STRUCTS_H_
#define STRUCTS_H_

#include <string>

struct Spell {
	Spell(const std::string& inputName,
		const int inputManaCost) {
		name = inputName;
		manaCost = inputManaCost;
	}

	std::string name;
	int	manaCost;
};



#endif /* STRUCTS_H_ */
