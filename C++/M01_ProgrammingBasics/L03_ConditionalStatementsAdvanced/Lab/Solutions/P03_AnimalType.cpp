#include <iostream>
#include <string>
using namespace std;

int main() {
	
	string animal;
	cin >> animal;

	string output;
	if (animal == "dog") {
		output = "mammal";
	} else if (animal == "crocodile" || animal == "tortoise" || animal == "snake") {
		output = "reptile";
	} else {
		output = "unknown";
	}

	cout << output << endl;

	return 0;
}
