#include "VirtualPage.h"

#include <iostream>

VirtualPage::VirtualPage(size_t pageNumber) : _pageNumber(pageNumber) {

}

void VirtualPage::addContent(const std::string& content) {
  _content.push_back(content);
}

void VirtualPage::printContent() const {
  std::cout << "Page: " << _pageNumber << '\n';
  for (const auto& row : _content) {
    std::cout << row << '\n';
  }
  std::cout << std::endl;
}
