#include <iostream>
#include <string>
using namespace std;

int main() {

	string n1, n2;
	getline(cin, n1);
	int firstNum = stoi(n1);
	getline(cin, n2);
	int secondNum = stoi(n2);

	char op;
	cin >> op;

	if (firstNum == 0 || secondNum == 0) {
		cout << "Cannot divide " << firstNum << " by zero" << endl;
		return 0;
	}

	string evenOrOdd;
	int result;
	switch (op) {
	case '+':
		result = firstNum + secondNum;
		evenOrOdd = result % 2 == 0 ? "even" : "odd";
		cout << firstNum << " " << op << " " << secondNum << " = " << result << " - " << evenOrOdd << endl;
		break;
	case '-':
		result = firstNum - secondNum;
		evenOrOdd = result % 2 == 0 ? "even" : "odd";
		cout << firstNum << " " << op << " " << secondNum << " = " << result << " - " << evenOrOdd << endl;
		break;
	case '*':
		result = firstNum * secondNum;
		evenOrOdd = result % 2 == 0 ? "even" : "odd";
		cout << firstNum << " " << op << " " << secondNum << " = " << result << " - " << evenOrOdd << endl;
		break;
	case '%':
		result = firstNum % secondNum;
		cout << firstNum << " " << op << " " << secondNum << " = " << result << endl;
		break;
	case '/':
		double d = static_cast<double>(firstNum) / secondNum;
		cout.setf(ios::fixed);
		cout.precision(2);
		cout << firstNum << " " << op << " " << secondNum << " = " << d << endl;
		break;
	}

	return 0;
}
