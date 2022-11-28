#ifndef INPUTPARSER_H_
#define INPUTPARSER_H_

#include <vector>
#include <string>

using PageData = std::vector<std::string>;

struct Input {
  std::vector<PageData> pagesData;
  std::vector<std::string> commands;
};

Input readInput();

#endif /* INPUTPARSER_H_ */
