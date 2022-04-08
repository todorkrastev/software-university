#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {
    string s = "hello world";
    istringstream stream(s);

    string hello, world;
    stream >> hello >> world;

    cout << hello << endl;
    cout << world << endl;

    string numbersString = "3 -2";
    istringstream numbersStream(numbersString);

    int sum = 0;
    int num1, num2;
    numbersStream >> num1 >> num2;

    ostringstream outputStream;
    outputStream << "The sum is " << num1 + num2 << endl;

    cout << outputStream.str();

    return 0;
}
