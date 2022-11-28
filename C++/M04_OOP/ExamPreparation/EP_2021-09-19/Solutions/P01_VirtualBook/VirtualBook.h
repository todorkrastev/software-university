#ifndef CPP_ADVANCED_VIRTUALBOOK_H
#define CPP_ADVANCED_VIRTUALBOOK_H


#include "VirtualPage.h"

class VirtualBook {

public:
  void addPage(VirtualPage page);

  void printContent() const;

  void removeLastPage();

  void removeAllPages();

private:
  std::vector<VirtualPage> _pages{ };
};


#endif //CPP_ADVANCED_VIRTUALBOOK_H
