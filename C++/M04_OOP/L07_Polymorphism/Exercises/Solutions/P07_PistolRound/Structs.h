#ifndef STRUCTS_H_
#define STRUCTS_H_

struct PlayerVitalData {
	PlayerVitalData(const int inputHealth,
			        const int inputArmor) : health(inputHealth),
			        						armor(inputArmor) {

	}

	int health;
	int armor;
};

#endif /* STRUCTS_H_ */
