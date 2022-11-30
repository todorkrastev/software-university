#ifndef CPP_ADVANCED_XBOX_H
#define CPP_ADVANCED_XBOX_H


#include "Defines.h"
#include "BaseConsole.h"

class Xbox : public BaseConsole {

public:
  Xbox() = delete;

  Xbox(int price, int quality);

  ConsoleType getConsoleType() const override;

  std::string getDetailsPrefix() const override;
};


#endif //CPP_ADVANCED_XBOX_H
