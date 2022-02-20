#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int days;
    cin >> days;

    double totalFood;
    cin >> totalFood;

    double totalBiscuits = 0; 
    double totalEatenFoodForAllDays = 0;
    double totalEatenDog = 0;
    double totalEatenCat = 0; 

    for (int day = 1; day <= days; day++) {
        int eatenDog, eatenCat;
        cin >> eatenDog; 
        totalEatenDog += eatenDog;
        cin >> eatenCat; 
        totalEatenCat += eatenCat;

        int totalEatenForDay = eatenDog + eatenCat; 
        totalEatenFoodForAllDays += totalEatenForDay;

        if (day % 3 == 0) {
            double biscuits = 0.10 * totalEatenForDay;
            totalBiscuits += biscuits;
        }
    }

    cout << "Total eaten biscuits: " << round(totalBiscuits) << "gr." << endl;

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << totalEatenFoodForAllDays / totalFood * 100 << "% of the food has been eaten." << endl;
    cout << totalEatenDog / totalEatenFoodForAllDays * 100 << "% eaten from the dog." << endl;
    cout << totalEatenCat / totalEatenFoodForAllDays * 100 << "% eaten from the cat." << endl;
    return 0;
}