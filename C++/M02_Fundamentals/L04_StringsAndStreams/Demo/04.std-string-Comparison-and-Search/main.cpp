#include <iostream>
#include <string>
using namespace std;
int main() {

    string s1 = "cat",
        s2 = "canary";

    if (s1 < s2) {
        cout << s1 << " is before " << s2 << endl;
    } else {
        cout << s1 << " is after " << s2 << endl;
    }

    cout << "nar" << " is at index " << s2.find("nar") << " in " << s2 << endl;

    return 0;
}
