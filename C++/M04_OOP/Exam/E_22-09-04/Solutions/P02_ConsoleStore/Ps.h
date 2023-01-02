#ifndef PS_H_
#define PS_H_

#include "Console.h"
#include "Defines.h"
#include "BaseConsole.h"

class Ps : public BaseConsole {
public:
	Ps() = delete;

	Ps(int generation, int price, int quality);

	ConsoleType getType() const override;

	std::string getDetailsPrefix() const override;

private:
	const int _generation;
};

#endif /* PS_H_ */