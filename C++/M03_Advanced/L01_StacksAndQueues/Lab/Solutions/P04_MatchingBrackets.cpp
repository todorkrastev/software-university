#include <iostream>
#include <string>
#include <queue>

int main() {

	std::string input;
	getline(std::cin, input);

	std::queue<std::string> mathExpr1;
	std::queue<std::string> mathExpr2;

	bool isBracketOpen1 = false;
	bool isBracketOpen2 = false;

	int totalBrackets = 0;

	for (size_t i = 0; i < input.length(); i++) {
		char currSymbol = input[i];

		if (currSymbol == '(' && totalBrackets == 0) {
			isBracketOpen1 = true;
			totalBrackets++;

			mathExpr1.push(std::string(1, currSymbol));
		} else if (isBracketOpen1 == true && totalBrackets == 1 && currSymbol != ')' && currSymbol != '(') {
			mathExpr1.push(std::string(1, currSymbol));
		} else if (currSymbol == '(' && totalBrackets == 1) {
			isBracketOpen2 = true;
			totalBrackets++;

			mathExpr2.push(std::string(1, currSymbol));
		} else if (isBracketOpen2 == true && totalBrackets == 2 && currSymbol != ')' && currSymbol != '(') {
			mathExpr2.push(std::string(1, currSymbol));
		} else if (currSymbol == ')' && totalBrackets == 1) {
			isBracketOpen1 = false;
			totalBrackets--;

			mathExpr1.push(std::string(1, currSymbol));

			while (!mathExpr1.empty()) {
				std::cout << mathExpr1.front();
				mathExpr1.pop();
			}

			std::cout << std::endl;
		} else if (currSymbol == ')' && totalBrackets == 2) {
			isBracketOpen2 = false;
			totalBrackets--;

			mathExpr2.push(std::string(1, currSymbol));

			while (!mathExpr2.empty()) {
				mathExpr1.push(mathExpr2.front());
				std::cout << mathExpr2.front();
				mathExpr2.pop();
			}

			std::cout << std::endl;
		}

	}

	return 0;
}



// Second option



#include <iostream>
#include <stack>
#include <string>
#include <vector>


int closedBrackets;
int subExpressions;
int flag;
int counter;

std::vector<std::string> output;

void getExpressions(std::stack<char> original, std::stack<char> transfer, int& closedBrackets, int& subExpressions, std::string input) {

    int counter = 0;
    int flag = 0;

    int size = input.length();

    for (int i = 0; i <= size; i++) {
        char tmp = original.top();

        if (tmp == '(') {
            closedBrackets++;
            counter++;
        }
        else if (tmp == ')') closedBrackets--;

        if (tmp == '(' && flag == 0)    flag++;
        else if (tmp == '(' && flag > 0)  subExpressions++;

        if (tmp == ')' && flag > 0 && closedBrackets == 0)  flag--;

        original.pop();
    }
}



void getSubs(std::stack<char> original, std::stack<char> transfer, std::string input, int& n) {

    std::string tmpS;

    int counter = 0;
    int flag = 0;

    int size = input.length();
    int record = 0;

    for (int i = 0; i <= size; i++) {

        char tmp = original.top();

        if (tmp == '(') counter++;
        else if (tmp == ')') counter--;


        if (tmp == '(' && counter == n) record++;

        original.pop();

        if (record > 0) tmpS.push_back(tmp);
        if (tmp == ')' && record > 0 && counter != n) {
            output.push_back(tmpS);
            tmpS = "";
            record--;
        }

    }
}


int main() {

    std::string input;
    getline(std::cin, input);

    std::stack<char> transfer;
    std::stack<char> original;

    int size = input.length();

    for (int i = size; i > -1; i--) original.push(input[i]);

    getExpressions(original, transfer, closedBrackets, subExpressions, input);

    int rounds;

    if (subExpressions == 0) rounds = 1;
    else rounds = subExpressions;

    for (int i = rounds; i >= 1; i--) getSubs(original, transfer, input, i);

    for (int i = 0; i < output.size(); i++) std::cout << output[i] << std::endl;

    return 0;
}