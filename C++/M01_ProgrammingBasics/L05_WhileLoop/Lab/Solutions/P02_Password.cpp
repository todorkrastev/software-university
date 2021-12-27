#include <iostream>
#include <string>
using namespace std;

int main() {

	string username, password, repeatPass;
	cin >> username >> password >> repeatPass;

	while (repeatPass != password) {
		cin >> repeatPass;
	}

	cout << "Welcome " << username << "!" << endl;

	return 0;
}
