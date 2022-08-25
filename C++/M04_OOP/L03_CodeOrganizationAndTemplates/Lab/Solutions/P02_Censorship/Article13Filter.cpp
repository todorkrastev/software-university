#include "Article13Filter.h"

Article13Filter::Article13Filter(std::set<std::string> copyrighted) : copyrighted(copyrighted) {}

bool Article13Filter::blockIfCopyrighted(std::string s) {
	if (this->copyrighted.find(s) != this->copyrighted.end()) {
		this->blocked.push_back(s);
		return true;
	}

	return false;
}

bool Article13Filter::isCopyrighted(std::string s) {
	return this->copyrighted.find(s) != this->copyrighted.end();
}

std::vector<std::string> Article13Filter::getBlocked() {
	return std::vector<std::string>(this->blocked.begin(), this->blocked.end());
}