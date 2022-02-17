#include <iostream>
using namespace std;

int main() {
    int startNumber, endNumber, magicNumber;
    cin >> startNumber;
    cin >> endNumber;
    cin >> magicNumber;

    int count = 0;
    bool isFound = false;

    for (int x1 = startNumber; x1 <= endNumber; x1++) {
        for (int x2 = startNumber; x2 <= endNumber; x2++) {
            count++;
            int sum = x1 + x2;
            if (sum == magicNumber) {
                isFound = true;
                cout << "Combination N:" << count << " (" << x1 << " + " << x2 << " = " << magicNumber << ")";
                break;
            }
        }
        if (isFound) {
            break;
        }
    }
    if (!isFound) {
        cout << count << " combinations - neither equals " << magicNumber;
    }
    return 0;
}


// Second option

/*
#include <iostream>
using namespace std;

int main()
{
    int startNumber, endNumber, magicNumber;
    cin >> startNumber;
    cin >> endNumber;
    cin >> magicNumber;

    int count = 0;
    for (int x1 = startNumber; x1 <= endNumber; x1++) {
        for (int x2 = startNumber; x2 <= endNumber; x2++) {
            count++;
            int sum = x1 + x2;
            if (sum == magicNumber) {
                cout << "Combination N:" << count << " (" << x1 << " + " << x2 << " = " << magicNumber << ")";
                return 0;
            }
        }
    }
    cout << count << " combinations - neither equals " << magicNumber;

    return 0;
}
*/