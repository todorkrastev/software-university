#ifndef BASECONSOLE_H_
#define BASECONSOLE_H_

#include "Console.h"
#include "Defines.h"

class BaseConsole : public Console {
public:
	BaseConsole() = delete;

	BaseConsole(int price, int quality);

	virtual ~BaseConsole() = default;

	void printToConsole() const;

	virtual ConsoleType getType() const = 0;

	virtual std::string getDetailsPrefix() const = 0;
};

#endif /* BASECONSOLE_H_ */