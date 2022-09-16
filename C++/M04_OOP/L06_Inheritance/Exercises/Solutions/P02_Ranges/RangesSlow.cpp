#include <iostream>
#include <map>
#include <vector>
#include <sstream>


class Range {
    int index;
    int from;
    int to;
public:
    Range() {
    }

    Range(int index, int from, int to)
    : index(index)
    , from(from)
    , to(to) {
    }

    int getIndex() {
        return this->index;
    }

    int getFrom() {
        return this->from;
    }

    int getTo() {
        return this->to;
    }

    bool contains(int value) {
        return this->from <= value && value <= this->to;
    }
};

bool inARange(int value, std::vector<Range>& ranges) {
    for (Range range : ranges) {
        if (range.getFrom() <= value && value <= range.getTo()) {
            return true;
        }
    }

    return false;
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    std::vector<Range> ranges;
    std::string line;
    int index = 0;
    while(std::getline(std::cin, line) && line != ".") {
        std::istringstream lineIn(line);

        int from, to;
        lineIn >> from >> to;

        ranges.push_back({index++, from, to});
    }

    std::ostringstream output;

    while(std::getline(std::cin, line) && line != ".") {
        std::istringstream lineIn(line);
        int value;
        lineIn >> value;

        if (inARange(value, ranges)) {
            output << "in";
        } else {
            output << "out";
        }

        output << std::endl;
    }

    std::cout << output.str() << std::endl;

    return 0;
}
