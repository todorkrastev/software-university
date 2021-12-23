#include <iostream>
#include <string>
using namespace std;

int main() {

	string strCelsius, dayTime;
	getline(cin, strCelsius);
	int celsius = stoi(strCelsius);
	getline(cin, dayTime);

	string outfit, shoes;
	if (dayTime == "Morning") {
		if (10 <= celsius && celsius <= 18) {
			outfit = "Sweatshirt";
			shoes = "Sneakers";
		} else if (18 < celsius && celsius <= 24) {
			outfit = "Shirt";
			shoes = "Moccasins";
		} else if (25 <= celsius) {
			outfit = "T-Shirt";
			shoes = "Sandals";
		}
	} else if (dayTime == "Afternoon") {
		if (10 <= celsius && celsius <= 18) {
			outfit = "Shirt";
			shoes = "Moccasins";
		}
		else if (18 < celsius && celsius <= 24) {
			outfit = "T-Shirt";
			shoes = "Sandals";
		}
		else if (25 <= celsius) {
			outfit = "Swim Suit";
			shoes = "Barefoot";
		}
	} else if (dayTime == "Evening") {
		if (10 <= celsius && celsius <= 18) {
			outfit = "Shirt";
			shoes = "Moccasins";
		}
		else if (18 < celsius && celsius <= 24) {
			outfit = "Shirt";
			shoes = "Moccasins";
		}
		else if (25 <= celsius) {
			outfit = "Shirt";
			shoes = "Moccasins";
		}
	}

	cout << "It's " << celsius << " degrees, get your " << outfit << " and " << shoes << "." << endl;

	return 0;
}
