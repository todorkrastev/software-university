#include <iostream>
#include <map>


int main() {
	using namespace std;

	map<int, string> numberNames{ {2, "two"} };

	for (unsigned long i = 0; i < numberNames.size(); i++) {
		cout << numberNames[i] << ",";
	}

	return 0;
}