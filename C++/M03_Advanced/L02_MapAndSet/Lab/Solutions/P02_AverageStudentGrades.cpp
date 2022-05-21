#include <iostream>
#include <vector>
#include <string>

int main() {

	int numOfStudents;
	std::cin >> numOfStudents;
	std::cin.ignore();

	std::pair<std::string, std::vector<double>> student;
	std::vector<std::pair<std::string, std::vector<double>>> students;

	for (size_t i = 0; i < numOfStudents; i++) {
		std::string name;
		double grade;

		std::cin >> name >> grade;
		std::cin.ignore();

		int index = -1;

		for (size_t i = 0; i < students.size(); i++) {
			if (students[i].first == name) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			std::vector<double> grades;

			grades.push_back(grade);

			student.first = name;
			student.second = grades;
			students.push_back(student);
		} else {
			students[index].second.push_back(grade);
		}
	}

	std::cout.setf(std::ios::fixed);
	std::cout.precision(2);

	for (size_t i = 0; i < students.size(); i++) {
		std::cout << students[i].first << " -> ";

		double totalGrades = 0.0;
		for (size_t k = 0; k < students[i].second.size(); k++) {
			totalGrades += students[i].second[k];

			std::cout << students[i].second[k] << " ";
		}

		std::cout << "(avg: " << totalGrades / students[i].second.size() << ")" << std::endl;
	}

	return 0;
}