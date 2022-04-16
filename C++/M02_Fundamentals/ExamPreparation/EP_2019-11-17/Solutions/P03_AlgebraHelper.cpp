#include <iostream>
#include <vector>
#include <sstream>
#include <iterator>
#include <algorithm>

class Equation {
    std::string equation{ };
    long result;

    long evaluate() {
        int a, b;
        char operand;
        std::istringstream oss{ equation };
        oss >> a >> operand >> b;
        switch (operand) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            return a / b;
        case '%':
            return a % b;
        default:
            throw std::runtime_error("Unknown operand: " + equation);
        }
    }

public:
    explicit Equation(std::string equation) :
        equation(std::move(equation)),
        result(evaluate()) { }

    bool operator<(const Equation& rhs) const {
        return result < rhs.result;
    }

    friend std::ostream& operator<<(std::ostream& os, const Equation& eq) {
        return os << eq.equation;
    }

    bool operator>(const Equation& rhs) const {
        return rhs < *this;
    }
};

int main() {
    int lines;
    std::cin >> lines;

    std::vector<Equation> equations{ };
    for (int i = 0; i < lines; ++i) {
        std::string equation;
        std::getline(std::cin >> std::ws, equation);
        equations.emplace_back(equation);
    }

    std::sort(equations.begin(), equations.end(), std::greater<Equation>());

    std::copy(equations.cbegin(), equations.cend(), std::ostream_iterator<Equation>(std::cout, "\n"));

    return 0;
}