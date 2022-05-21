#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>


int main() {

    std::string input;
    std::getline(std::cin, input);
    std::istringstream strStream(input);

    std::string currNum;
    std::vector<int> numbers;

    while (strStream >> currNum) {

        for (int i = 1; i * i <= std::stoi(currNum); i++) {

            if ((std::stoi(currNum) % i == 0) && (std::stoi(currNum) / i == i)) {
                numbers.push_back(stoi(currNum));
                break;
            }
        }
    }

    std::sort(numbers.begin(), numbers.end(), std::greater<int>());
    
    std::vector<int>::iterator itr;

    for (itr = numbers.begin(); itr != numbers.end(); itr++) {
        if (itr != numbers.begin()) {
            std::cout << " ";
        }

        std::cout << *itr;
    }

	return 0;
}