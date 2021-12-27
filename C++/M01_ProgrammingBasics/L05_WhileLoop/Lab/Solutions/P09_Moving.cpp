#include <iostream>
#include <string>
using namespace std;

int main() {

	int width, len, height;
	string command;
	cin >> width >> len >> height >> command;

	int capacity = width * len * height;
	int boxes = 0;
	while (command != "Done") {
		int currBox = stoi(command);
		boxes += currBox;

		if (capacity < boxes) {
			cout << "No more free space! You need " << boxes - capacity << " Cubic meters more." << endl;

			return 0;
		}
		cin >> command;
	}

	cout << capacity - boxes << " Cubic meters left." << endl;

	return 0;
}
