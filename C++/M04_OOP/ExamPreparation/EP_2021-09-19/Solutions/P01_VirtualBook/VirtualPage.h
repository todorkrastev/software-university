#ifndef VIRTUALPAGE_H_
#define VIRTUALPAGE_H_

#include <vector>
#include <string>

class VirtualPage {
public:
  VirtualPage(size_t pageNumber);
  void addContent(const std::string& content);

  void printContent() const;

private:
  std::vector<std::string> _content;
  size_t _pageNumber { 0 };
};

#endif /* VIRTUALPAGE_H_ */
