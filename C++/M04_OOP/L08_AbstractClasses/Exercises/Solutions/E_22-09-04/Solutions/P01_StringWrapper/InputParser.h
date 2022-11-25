#ifndef INPUTPARSER_H_
#define INPUTPARSER_H_

#include <string>

struct Input {
  std::string line;
  char letter {};
  int repetitions {};
};

Input readInput();

#endif /* INPUTPARSER_H_ */
