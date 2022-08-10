#include <string>
#include <iostream>
#include <vector>
#include <list>

template<typename T>
void print(T container) {
	typename T::iterator i;
	for (i = container.begin(); i != container.end(); i++) {
		std::cout << *i << " ";
	}
	std::cout << std::endl;
}

template<>
void print<std::string>(std::string container) {
	std::cout << container << std::endl;
}

int main() {
	std::list<std::string> words{ "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" };
	std::vector<int> numbers{ 1, 2, 3 };
	std::string s = "hello specialization";

	print(words);
	print(numbers);
	print(s);

	return 0;
}