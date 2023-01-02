#ifndef CPP_ADVANCED_MAGICKINGDOM_H
#define CPP_ADVANCED_MAGICKINGDOM_H

#include <vector>
#include "Struct.h"

class MagicKingdom {
  std::vector<Villager> antiMages{ };
  std::vector<Villager> commoners{ };
  std::vector<Villager> mages{ };
public:
  void printAll();

  friend MagicKingdom& operator<<(MagicKingdom& magicKingdom, const Villager& villager);

};

#endif //CPP_ADVANCED_MAGICKINGDOM_H
