#include <iostream>
using namespace std;

int main() {
    string destination;
    cin >> destination;

    while (destination != "End") {
        double needBudget;
        cin >> needBudget;

        double savedMoney = 0;
        while (savedMoney < needBudget) {
            double sum;
            cin >> sum;
            savedMoney += sum;
        }
        cout << "Going to " << destination << "!" << endl;

        cin >> destination;
    }
    
    return 0;
}
