#ifndef CPP_ADVANCED_BOMBERMAN_H
#define CPP_ADVANCED_BOMBERMAN_H

#include "Defines.h"

class BomberMan {

public:
  void bombPowerUp();

  int getBombPower() const;

  void bombPowerDown();

  int placeBomb(FieldData const& fieldData, int bombRow, int bombCol);

private:
  int _bombPower{0};
  std::vector<std::vector<bool>> _damagedFields{ };
};


#endif //CPP_ADVANCED_BOMBERMAN_H
