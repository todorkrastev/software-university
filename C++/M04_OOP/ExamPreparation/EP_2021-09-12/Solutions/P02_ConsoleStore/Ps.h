#ifndef CPP_ADVANCED_PS_H
#define CPP_ADVANCED_PS_H


#include "Console.h"
#include "Defines.h"
#include "BaseConsole.h"

class Ps : public BaseConsole {
public:
  Ps() = delete;

  Ps(int generation, int price, int quality);

  ConsoleType getConsoleType() const override;

  std::string getDetailsPrefix() const override;

private:
  const int _generation;
};


#endif //CPP_ADVANCED_PS_H
