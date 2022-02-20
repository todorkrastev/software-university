#include <iostream>
using namespace std;

int main() {
	int startNumber;
	cin >> startNumber;

	int startUnits = startNumber % 10;
	int startTens = startNumber / 10 % 10;
	int startHundreds = startNumber / 100 % 10;
	int startThousands = startNumber / 1000; 

	int endNumber;
	cin >> endNumber;

	int endUnits = endNumber % 10;
	int endTens = endNumber / 10 % 10;
	int endHundreds = endNumber / 100 % 10;
	int endThousands = endNumber / 1000;


	for (int thousands = startThousands; thousands <= endThousands; thousands++) {
		for (int hundreds = startHundreds; hundreds <= endHundreds; hundreds++) {
			for (int tens = startTens; tens <= endTens; tens++) {
				for (int units = startUnits; units <= endUnits; units++) {
					if (units % 2 != 0 && tens % 2 != 0 && hundreds % 2 != 0 && thousands % 2 != 0) {
						cout << thousands << hundreds << tens << units << " ";
					}
				}
			}
		}
	}


	return 0;
}