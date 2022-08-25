#ifndef ARTICLE_13_FILTER_H
#define ARTICLE_13_FILTER_H

#include <string>
#include <vector>
#include <set>

class Article13Filter {
private:
	std::set<std::string> copyrighted;
	std::vector<std::string> blocked;
public:
	Article13Filter(std::set<std::string> copyrighted);
	bool blockIfCopyrighted(std::string s);
	bool isCopyrighted(std::string s);

	std::vector<std::string> getBlocked();
};

#endif // !ARTICLE_13_FILTER_H

