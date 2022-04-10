#include <sstream>
#include <iostream>
#include <cctype>

using namespace std;


int main() {

	int flag = 1;

	string inp;

	getline(cin, inp);

	ostringstream output;
	int index = 0;

	while (index < inp.length()) {

		char c = inp[index];
		index++;

		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			if (flag) {
				if (c >= 'a' && c <= 'z') {
					c = c - ('a' - 'A');
				}

				flag = 0;
			}
		} else {
			flag = 1;
		}

		output << c;
	}

	cout << output.str() << endl;

	return 0;
}