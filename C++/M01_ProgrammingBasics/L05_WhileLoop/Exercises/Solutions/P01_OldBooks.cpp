#include <iostream>
#include <string>
using namespace std;

int main() {

	string book;
	getline(cin, book);
	int capacity;
	cin >> capacity;

	string searcher;
	getline(cin, searcher);
	int counter = 0;
	while (searcher != book) {

		if (counter == capacity) {
			cout << "The book you search is not here!" << endl;
			cout << "You checked " << capacity << " books." << endl;

			return 0;
		}
		getline(cin, searcher);
		counter++;
	}

	if (searcher == book && counter != 0) {
		cout << "You checked " << counter - 1 << " books and found it." << endl;
	} else {
		cout << "You checked " << capacity << " books and found it." << endl;
	}

	return 0;
}
