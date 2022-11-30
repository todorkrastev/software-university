#include "StringWrapper.h"

#include <iostream>
#include <utility>

StringWrapper::StringWrapper(std::string content)
    : content{std::move(content)} { }

StringWrapper::StringWrapper(char const ch, int const repeat)
    : content{std::string(repeat, ch)} { }

std::string StringWrapper::getContent() const {
  return content;
}

StringWrapper& StringWrapper::append(std::string const& text) {
  content += text;
  return *this;
}

void StringWrapper::printContent() const {
  std::cout << content << std::endl;
}
