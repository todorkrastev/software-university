#include <iostream>
#include <string>
#include <vector>

class Lecturer {
	double rating;
	std::string name;
public:
	Lecturer() {
		std::cout << "Lecturer default ctor BODY" << std::endl;
	}
};

class Lesson {
	Lecturer lecturer;
	std::string subject;
	int numStudents;
public:
	Lesson() {
		std::cout << "Lesson default ctor BODY" << std::endl;
	}
};

int main() {
	Lesson lesson;

	return 0;
}