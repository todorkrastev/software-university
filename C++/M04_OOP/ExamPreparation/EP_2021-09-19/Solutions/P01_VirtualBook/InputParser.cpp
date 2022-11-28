#include "InputParser.h"
#include <iostream>

static std::vector<PageData> readPagesData() {
  size_t pagesNumber = 0;
  std::cin >> pagesNumber;
  std::cin.ignore();

  std::vector<PageData> pagesData(pagesNumber);

  const std::string delimiter = "end";
  std::string line;
  for (auto& pageData : pagesData) {
    getline(std::cin, line);
    while (line != delimiter) {
      pageData.push_back(line);
      getline(std::cin, line);
    }
  }

  return pagesData;
}

static std::vector<std::string> readCommands() {
  size_t commandsNumber = 0;
  std::cin >> commandsNumber;
  std::cin.ignore();

  std::vector<std::string> commands(commandsNumber);
  for (auto& command : commands) {
    getline(std::cin, command);
  }

  return commands;
}

Input readInput() {
  Input input;
  input.pagesData = readPagesData();
  input.commands = readCommands();

  return input;
}
