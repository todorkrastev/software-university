#include "Logger.h"

#include <iostream>

Logger::Logger() {
  constexpr auto fileName = "log.txt";
  _outFile.open(fileName, std::ios::app);
  if (!_outFile) {
    std::cerr << "Error opening file: " << fileName << std::endl;
  }
}

void Logger::print(const std::string &data, LogTarget target) {
  if (LogTarget::STDOUT == target) {
    std::cout << data << std::endl;
    return;
  }

  _outFile << data << std::endl;;
}


