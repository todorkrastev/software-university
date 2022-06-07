#include<iostream>

int main() {
	using namespace std;

	int number = 42;

	int * intPtr = &number;
	char * charPtr = (char*)&number;

	cout << intPtr << " " << (int*)charPtr << endl;
	intPtr++; charPtr++;
	cout << intPtr << " " << (int*)charPtr << endl;

	return 0;
}
