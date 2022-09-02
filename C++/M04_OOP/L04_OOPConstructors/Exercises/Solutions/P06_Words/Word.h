#ifndef WORD_H
#define WORD_H

#include <cstdlib>
#include <string>
#include <map>
#include <set>

class Word {
	std::string str;

	static std::map<std::string, int> WordObjectsCounts;
	static std::map<std::string, int> WordCounts;
public:
	Word(std::string str);
	Word(const Word& other);

	std::string getWord() const;
	size_t getCount() const;

	bool operator<(const Word& other) const;
	Word& operator=(const Word& other);

	~Word();
};

#endif // !WORD_H

