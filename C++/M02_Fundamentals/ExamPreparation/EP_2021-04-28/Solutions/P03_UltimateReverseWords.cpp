#include <iostream>
#include <unordered_map>
#include <vector>
#include <queue>
#include <unordered_set>

static const int SEPARATOR = -1;

bool isSeparator(char ch);

void parseInput(std::unordered_map<int, std::deque<std::string>>& words, std::vector<int>& codes);

void reverseWords(std::unordered_map<int, std::deque<std::string>>& wordsMap);

int main() {
    std::unordered_map<int, std::deque<std::string>> words{ };
    std::vector<int> codes{ };

    parseInput(words, codes);

    reverseWords(words);

    for (const int code : codes) {
        std::cout << words[code].front();
        words[code].pop_front();
    }

    return 0;
}

void reverseWords(std::unordered_map<int, std::deque<std::string>>& wordsMap) {
    for (auto& kvp : wordsMap) {
        if (kvp.first == SEPARATOR) {
            continue;
        }

        auto& words = kvp.second;
        for (size_t i = 0, i2 = words.size() - 1; i < i2; ++i, --i2) {
            bool isFirstUpper = isupper(words[i][0]);
            bool isSecondUpper = isupper(words[i2][0]);

            std::string temp = words[i];
            words[i] = words[i2];
            words[i2] = temp;

            if (isFirstUpper) {
                words[i][0] = (char)toupper(words[i][0]);
            } else {
                words[i][0] = (char)tolower(words[i][0]);
            }

            if (isSecondUpper) {
                words[i2][0] = (char)toupper(words[i2][0]);
            } else {
                words[i2][0] = (char)tolower(words[i2][0]);
            }
        }
    }
}

void parseInput(std::unordered_map<int, std::deque<std::string>>& words, std::vector<int>& codes) {
    std::string line;
    while (std::getline(std::cin >> std::ws, line) && line != "end") {
        std::string word{ };
        for (char ch : line) {
            if (isSeparator(ch)) {
                if (!word.empty()) {
                    const int length = (int)word.size();
                    codes.emplace_back(length);
                    words[length].emplace_back(word);
                    word.clear();
                }
                codes.emplace_back(SEPARATOR);
                std::string s;
                s = ch;
                words[SEPARATOR].emplace_back(s);
            } else {
                word.append(1, ch);
            }
        }

        if (!word.empty()) {
            const int length = (int)word.size();
            codes.emplace_back(length);
            words[length].emplace_back(word);
            word.clear();
        }

        codes.emplace_back(SEPARATOR);
        words[SEPARATOR].emplace_back("\n");
    }
}

bool isSeparator(const char ch) {
    static const std::unordered_set<char> separators{
        '.', ',', '!', '?', '-', ':', '\n', '\t', ' '
    };

    return separators.find(ch) != separators.end();
}