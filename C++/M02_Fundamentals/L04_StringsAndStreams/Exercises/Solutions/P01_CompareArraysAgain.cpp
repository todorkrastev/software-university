#include <iostream>
#include <array>
#include <sstream>

using namespace std;

const unsigned maxSize = 200;


bool areEqual(const int array1[], int array1size, const int array2[], int array2size) {

	if (array1size != array2size) {
		return false;
	}

	for (int i = 0; i < array1size; i++) {
		if (array1[i] != array2[i]) {
			return false;
		}
	}

	return true;
}

int parseArray(int array[], istringstream& stream) {

	int currNumber;
	int index = 0;

	while (stream >> currNumber) {
		array[index] = currNumber;
		if (++index >= maxSize) {
			return -1;
		}
	}

	return index;
}

int main() {

	string str1, str2;

	getline(cin, str1);
	getline(cin, str2);

	int arr1[maxSize], arr2[maxSize];
	istringstream stream1(str1);
	istringstream stream2(str2);

	int arr1size = parseArray(arr1, stream1);
	int arr2size = parseArray(arr2, stream2);

	cout << (areEqual(arr1, arr1size, arr2, arr2size) ? "equal" : "not equal") << endl;
	
	return 0;
}

// Second option

/*
#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

bool areEqual(const vector<int>& array1, const vector<int>& array2) {

	if (array1.size() != array2.size()) {
		return false;
	}

	for (int i = 0; i < array1.size(); i++) {
		if (array1[i] != array2[i]) {
			return false;
		}
	}

	return true;
}

void parseArray(vector<int>& array, istringstream& stream) {

	int currNumber;

	while (stream >> currNumber) {
		array.push_back(currNumber);
	}
}

int main() {

	string str1, str2;

	getline(cin, str1);
	getline(cin, str2);

	vector<int> arr1, arr2;
	istringstream stream1(str1);
	istringstream stream2(str2);

	parseArray(arr1, stream1);
	parseArray(arr2, stream2);

	cout << (areEqual(arr1, arr2) ? "equal" : "not equal") << endl;

	return 0;
}
*/