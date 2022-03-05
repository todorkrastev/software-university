#include <iostream>
#include  <cmath>

int main() {
	float a = 0.0f;
	float b = 0.0f;
	float c = 0.0f;
	std::cin >> a >> b >> c;

	const float discriminant = b * b - (4 * a * c);
	const float sqRoot = std::sqrt(discriminant);

	if (discriminant > 0) {
		float x1 = (-b + sqRoot) / (2 * a);
		float x2 = (-b - sqRoot) / (2 * a);
		std::cout << x1 << ' ' << x2 << std::endl;
	} else if (std::sqrt(discriminant) == 0) {
		float x1 = -b / (2 * a);
		std::cout << x1 << std::endl;
	} else {
		std::cout << "no roots" << std::endl;
	}

	return 0;
}