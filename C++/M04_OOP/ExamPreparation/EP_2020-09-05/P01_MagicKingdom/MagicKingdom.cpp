#include "MagicKingdom.h"
#include "VillagerHelper.h"
#include <iostream>
#include <algorithm>
#include <iterator>

void MagicKingdom::printAll() {
  std::cout << "Anti-Mages:" << std::endl;
  std::sort(this->antiMages.begin(), this->antiMages.end(), std::less<Villager>());
  std::copy(this->antiMages.cbegin(), this->antiMages.cend(), std::ostream_iterator<Villager>(std::cout, "\n"));

  std::cout << "Commoners:" << std::endl;
  std::sort(this->commoners.begin(), this->commoners.end(), std::greater<Villager>());
  std::copy(this->commoners.cbegin(), this->commoners.cend(), std::ostream_iterator<Villager>(std::cout, "\n"));

  std::cout << "Mages:" << std::endl;
  std::sort(this->mages.begin(), this->mages.end(), std::greater<Villager>());
  std::copy(this->mages.cbegin(), this->mages.cend(), std::ostream_iterator<Villager>(std::cout, "\n"));
}

MagicKingdom& operator<<(MagicKingdom& magicKingdom, const Villager& villager) {
  std::vector<Villager>* villagerGroup = &magicKingdom.commoners;

  if (villager.power < 0) {
    villagerGroup = &magicKingdom.antiMages;
  } else if (villager.power >= 100) {
    villagerGroup = &magicKingdom.mages;
  }

  villagerGroup->emplace_back(villager);

  return magicKingdom;
}
