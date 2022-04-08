#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main () {
    istringstream input("some text here");

    string inputLine;
    getline(input, inputLine);
    cout << inputLine << endl;

    istringstream inputWithDots("some.text.here");

    string inputWithDotsLine;
    getline(inputWithDots, inputWithDotsLine, '.');
    cout << inputWithDotsLine << endl;

    //the fisrt getline has "consumed" part of the stream
    getline(inputWithDots, inputWithDotsLine, '.');
    cout << inputWithDotsLine << endl;

    return 0;
}
