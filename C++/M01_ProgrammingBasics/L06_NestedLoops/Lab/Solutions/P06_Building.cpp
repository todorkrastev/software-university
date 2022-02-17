#include <iostream>
#include <string>
#include <math.h>

using namespace std;

int main() {
    int floors, apartments;
    cin >> floors >> apartments;

    for (int floor = floors; floor > 0; floor--) {
        for (int apartment = 0; apartment < apartments; apartment++) {
            if (floor == floors) {
                cout << "L" << floor << apartment << " ";
            }
            else if (floor % 2 == 0) {
                cout << "O" << floor << apartment << " ";
            }
            else {
                cout << "A" << floor << apartment << " ";
            }

        }
        cout << endl;
    }
}