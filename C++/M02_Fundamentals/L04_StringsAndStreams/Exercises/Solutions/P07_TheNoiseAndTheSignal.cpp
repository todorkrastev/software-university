#include <iostream>
#include <sstream>
#include <string>

using namespace std;


int main(void) {

	string line;
	getline(cin, line);

	istringstream input(line);
	string current;

	string minNoise = "";

	while (input >> current) {

		string curNoise;

		for (int index = 0; index < current.length(); index++) {

			char c = current[index];

			if (!(c >= '0' && c <= '9')) {
				curNoise += c;
			}
		}

		if (curNoise.length() > minNoise.length()) {
			minNoise = curNoise;
		}
		else if (curNoise.length() == minNoise.length() && curNoise < minNoise) {
			minNoise = curNoise;
		}
	}


	cout << (minNoise.length() == 0 ? "no noise" : minNoise) << endl;

	return 0;
}