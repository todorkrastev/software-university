#include <iostream>
#include <string>
using namespace std;

int main() {

	string str;
	getline(cin, str);

	for (int i = 0; i < str.length(); i++) {
		cout << str[i] << endl;
	}

	return 0;
}
