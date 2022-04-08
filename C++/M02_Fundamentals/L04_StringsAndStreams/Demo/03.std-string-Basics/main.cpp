#include <iostream>
#include <string>
using namespace std;

int main() {
    string theFoxPart = "the quick brown fox";
    string theActionPart("jumps over");
    char dogPartCString[] = "the lazy dog";
    string sentence = theFoxPart + string("---") +
    							theActionPart + string(3, '-') + dogPartCString;
    string sameSentance = "the quick brown fox---jumps over---the lazy dog";
    cout << sentence << " (length: " << sentence.size() << ")" << endl;

    string hello = "hello";
    for (int i = 0; i < hello.size(); i++) {
        cout << hello[i] << endl;
    }

    hello[1] = 'a';
    cout << hello << endl; /// Prints hallo

    string helloWorld = hello + string(" ") + string("world");
    cout << helloWorld << endl << std::endl;

    string name;
    std::cout << "Enter your name: ";
    cin >> name;
    string helloName = hello + string(" ") + name;
    cout << helloName << endl;

    return 0;
}
