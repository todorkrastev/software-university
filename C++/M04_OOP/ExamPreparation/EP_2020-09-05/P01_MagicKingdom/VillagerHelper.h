#ifndef CPP_ADVANCED_VILLAGERHELPER_H
#define CPP_ADVANCED_VILLAGERHELPER_H

#include "Struct.h"
#include <ostream>

bool operator>(const Villager& lhs, const Villager& rhs);

bool operator<(const Villager& lhs, const Villager& rhs);

std::ostream& operator<<(std::ostream& os, const Villager& villager);

#endif //CPP_ADVANCED_VILLAGERHELPER_H
