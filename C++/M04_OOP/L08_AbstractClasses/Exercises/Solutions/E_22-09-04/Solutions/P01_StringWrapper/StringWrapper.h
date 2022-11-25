#ifndef STRINGWRAPPER_H_
#define STRINGWRAPPER_H_

#include <string>

class StringWrapper {
private:
	std::string content{};

public:
	StringWrapper() = default;

	explicit StringWrapper(std::string content);

	StringWrapper(char letter, int repetitions);

	std::string getContent() const;

	void printContent() const;

	StringWrapper& append(std::string const& input);
};
#endif /* STRINGWRAPPER_H_ */
