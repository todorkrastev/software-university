#ifndef XBOX_H_
#define XBOX_H_

#include "Defines.h"
#include "BaseConsole.h"

class Xbox : public BaseConsole {
public:
	Xbox() = delete;

	Xbox(int price, int quality);

	ConsoleType getType() const override;

	std::string getDetailsPrefix() const override;
};

#endif /* XBOX_H_ */