#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;


	int counterUnder200 = 0;
	int counterFrom200To399 = 0;
	int counterFrom400To599 = 0;
	int counterFrom600To799 = 0;
	int counterFrom800 = 0;
	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;

		if (input < 200) {
			counterUnder200++;
		} else if (200 <= input && input <= 399) {
			counterFrom200To399++;
		} else if (400 <= input && input <= 599) {
			counterFrom400To599++;
		} else if (600 <= input && input <= 799) {
			counterFrom600To799++;
		} else if (800 <= input) {
			counterFrom800++;
		}
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << static_cast<double>(counterUnder200) / n * 100 << "%" << endl;
	cout << static_cast<double>(counterFrom200To399) / n * 100 << "%" << endl;
	cout << static_cast<double>(counterFrom400To599) / n * 100 << "%" << endl;
	cout << static_cast<double>(counterFrom600To799) / n * 100 << "%" << endl;
	cout << static_cast<double>(counterFrom800) / n * 100 << "%" << endl;

	return 0;
}
