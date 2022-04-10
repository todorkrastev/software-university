#include <iostream>
#include <sstream>
#include <string>

using namespace std;


int main() {

    string line;
    getline(cin, line);

    istringstream input(line);
    string current;

    unsigned max = 0;

    while (input >> current) {

        unsigned num = 0;

        for (int index = 0; index < current.length(); index++) {

            char c = current[index];

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
        }

        if (num > max) {
            max = num;
        }
    }

    cout << max << endl;

    return 0;
}