#include <cmath>
#include <iomanip>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>

class Student {
private:
	std::string name;
	std::string surname;
	double totalAverage = 0;

public:
	void read(std::istream& istr);

	void print(std::ostream& ostr) const;

	double getTotalAverage(void) const { return totalAverage; }
};

void Student::read(std::istream& istr) {
	istr >> name >> surname >> totalAverage;
}

void Student::print(std::ostream& ostr) const {
	ostr << name << " " << surname << " " << totalAverage << std::endl;
}

int main() {

	int studentsNum;
	std::cin >> studentsNum;

	if (studentsNum <= 0) {
		std::cout << "Invalid input" << std::endl;
		return 0;
	}

	std::vector<Student> students;
	students.resize(studentsNum);

	for (size_t curr = 0; curr < studentsNum; curr++) {
		students[curr].read(std::cin);
	}

	double grandTotalAverage = 0;

	for (size_t curr = 0; curr < studentsNum; curr++) {
		students[curr].print(std::cout);
		grandTotalAverage += students[curr].getTotalAverage();
	}

	std::cout << grandTotalAverage / studentsNum << std::endl;

	return 0;
}