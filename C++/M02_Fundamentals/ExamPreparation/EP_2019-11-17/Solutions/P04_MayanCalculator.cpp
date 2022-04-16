#include <iostream>
#include <string>
#include <vector>

int main() {
    std::vector<std::vector<std::string>> mayanNumbers{ };

    int lines;
    std::cin >> lines;
    for (int n = 0; n < lines; ++n) {
        mayanNumbers.emplace_back();
        std::string line;
        getline(std::cin >> std::ws, line);
        size_t symbolsPerDigit = line.length() / 10;
        for (size_t i = 0; i < 10; ++i) {
            mayanNumbers[n].emplace_back(line.substr(i * symbolsPerDigit, symbolsPerDigit));
        }
    }

    std::string number;
    std::cin >> number;
    for (int line = 0; line < lines; ++line) {
        for (auto const& ch : number) {
            size_t digit = ch - '0';
            std::cout << mayanNumbers[line][digit];
        }
        std::cout << std::endl;
    }

    return 0;
}