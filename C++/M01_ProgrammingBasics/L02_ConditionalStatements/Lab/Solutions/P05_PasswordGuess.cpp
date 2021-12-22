#include <iostream>
using namespace std;

int main() {

	string password = "s3cr3t!P@ssw0rd";
	string input;
	cin >> input;

	string output = password == input ? "Welcome" : "Wrong password!";

	cout << output << endl;

	return 0;
}
