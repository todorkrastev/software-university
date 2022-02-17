#include <iostream>
#include <string>
using namespace std;

int main() {
    string movie;
    getline(cin >> ws, movie);

    int allSoldCnt = 0;

    cout.setf(ios::fixed);
    cout.precision(2);

    int student = 0, standard = 0, kid = 0;

    while (movie != "Finish") {
        int allPerMovie;
        cin >> allPerMovie;

        int currAllSold = 0;
        int allAvailable = allPerMovie;

        string ticketType;

        while (allAvailable != 0) {
            cin >> ticketType;
            if (ticketType == "End") {
                break;
            }
            allAvailable--;
            allSoldCnt++;
            currAllSold++;

            if (ticketType == "student") {
                student++;
            } else if (ticketType == "standard") {
                standard++;
            } else if (ticketType == "kid") {
                kid++;
            }
        }

        cout << movie << " - " << currAllSold * 100.0 / allPerMovie << "% full." << endl;
        getline(cin >> ws, movie);
    }

    cout << "Total tickets: " << allSoldCnt << endl;
    cout << student * 100.0 / allSoldCnt << "% student tickets." << endl;
    cout << standard * 100.0 / allSoldCnt << "% standard tickets." << endl;
    cout << kid * 100.0 / allSoldCnt << "% kids tickets." << endl;

    return 0;
}
