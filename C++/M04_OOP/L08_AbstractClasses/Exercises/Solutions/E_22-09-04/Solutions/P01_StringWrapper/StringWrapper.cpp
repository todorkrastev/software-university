#include "StringWrapper.h"

#include <iostream>

StringWrapper::StringWrapper(std::string content) 
	: content { std::move(content) } { }

StringWrapper::StringWrapper(char const letter, int const repetetions)
: content { std::string(repetetions, letter)} { }

std::string StringWrapper::getContent() const {
	return content;
}

StringWrapper& StringWrapper::append(std::string const& input) {
	content += input;

	return *this;
}

void StringWrapper::printContent() const {
	std::cout << content << std::endl;
}
