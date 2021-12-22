#include <iostream>

using namespace std;

int main() {

	int len, width, height;
	double percantage;

	cin >> len >> width >> height >> percantage;


	double volume = len * width * height;
	double capacity = volume * 0.001;
	double litres = capacity * (1 - percantage * 0.01);

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << litres << endl;

	return 0;
}
