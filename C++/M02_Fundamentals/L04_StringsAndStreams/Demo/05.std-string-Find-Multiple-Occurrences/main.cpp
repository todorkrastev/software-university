#include <iostream>
#include <string>
using namespace std;
int main() {
    string str = "canary";

    int foundIndex = str.find("a");
    while (foundIndex != string::npos) {
        cout << "a" << " found at " << foundIndex << " in " << str << endl;
        foundIndex = str.find("a", foundIndex + 1);
    }

    //NOTE: why foundIndex + 1?

    return 0;
}
