#include <iostream>
#include <vector>
#include <string>
#include <list>

template<typename Container>
void print(Container container) {
	typename Container::iterator i;
	for (i = container.begin(); i != container.end(); i++) {
		std::cout << *i << " ";
	}
	std::cout << std::endl;
}

int main() {
	std::list<std::string> words{ "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" };
	std::vector<int> numbers{ 1, 2, 3 };

	print(words);
	print(numbers);

	return 0;
}