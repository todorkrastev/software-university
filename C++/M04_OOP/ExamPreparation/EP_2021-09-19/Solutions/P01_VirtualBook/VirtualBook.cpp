#include "VirtualBook.h"

void VirtualBook::addPage(VirtualPage page) {
  _pages.push_back(std::move(page));
}

void VirtualBook::printContent() const {
  for (const auto& page: _pages) {
    page.printContent();
  }
}

void VirtualBook::removeLastPage() {
  if (!_pages.empty()) {
    _pages.pop_back();
  }
}

void VirtualBook::removeAllPages() {
  _pages.clear();
}
