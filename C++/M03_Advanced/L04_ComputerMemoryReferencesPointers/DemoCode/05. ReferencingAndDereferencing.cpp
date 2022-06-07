#include<iostream>
#include<string>

int main() {
	using namespace std;

	int a = 42, b = 13;
	int* ptr = &a;
	cout << *ptr << endl;

	ptr = &b;
	*ptr = 7;
	cout << b << endl;

	string s = "world";
	string* sPtr = &s;
	sPtr->insert(0, "hello "); // makes s == "hello world"
	cout << *sPtr << endl;

	return 0;
}
