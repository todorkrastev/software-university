#include <string>
#include <iostream>

using namespace std;


int main() {

    string str;
    getline(cin, str);

    string find;
    getline(cin, find);

    string replace;
    getline(cin, replace);


    int foundIndex = str.find(find);

    while (foundIndex != string::npos) {

        str.replace(foundIndex, find.length(), replace);

        foundIndex += replace.length();

        foundIndex = str.find(find, foundIndex);

    }

    cout << str << endl;

    return 0;
}