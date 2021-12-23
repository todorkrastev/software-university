#include <iostream>
#include <string>
using namespace std;

int main() {

	string str;
	getline(cin, str);

	int sum = 0;
	for (int i = 0; i < str.length(); i++) {
		switch (str[i]) {
		case 'a':
			sum += 1;
			break;
		case 'e':
			sum += 2;
			break;
		case 'i':
			sum += 3;
			break;
		case 'o':
			sum += 4;
			break;
		case 'u':
			sum += 5;
			break;
		default:
			break;
		}
	}

	cout << sum << endl;

	return 0;
}
