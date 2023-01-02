#include "VillagerHelper.h"

bool operator>(const Villager& lhs, const Villager& rhs) {
  return lhs.power > rhs.power;
}

bool operator<(const Villager& lhs, const Villager& rhs) {
  return lhs.power < rhs.power;
}

std::ostream& operator<<(std::ostream& os, const Villager& villager) {
  return os << villager.name << " - " << villager.magicItem;
}
