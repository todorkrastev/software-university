#include <iostream>
#include <string>

class Lecturer {
	double rating;
	std::string name;
public:
	Lecturer() = default;

	Lecturer(std::string name, double rating)
		: name(name), rating(rating) {}

	// NOTE: these two aren't really necessary, as they would be auto-generated anyway
	Lecturer(const Lecturer& other) = default;
	Lecturer& operator=(const Lecturer& other) = default;

	std::string getName() const {
		return this->name;
	}

	double getRating() const {
		return this->rating;
	}
};

class IntArray {
	int* data;
	int size;
public:
	IntArray(int size) : data(new int[size]), size(size) {}

	~IntArray() {
		delete[] this->data;
	}

	int getSize() const {
		return this->size;
	}

	int& operator[](const int index) const {
		return this->data[index];
	}

	// Prevent copies to avoid memory problems
	IntArray(const IntArray& other) = delete;
	IntArray& operator=(const IntArray& other) = delete;
};


// NOTE: replacing the signature with the commented-out signature will cause a compilation error in calls due to IntArray not being copyable
void printArray(const IntArray& arr) {
//void printArray(IntArray arr) {
	for (int i = 0; i < arr.getSize(); i++) {
		std::cout << arr[i] << " ";
	}
	std::cout << std::endl;
}

int main() {
	Lecturer defaultLecturer;
	Lecturer copyInitializedLecturer(defaultLecturer);
	Lecturer copyAssignedLecturer = copyInitializedLecturer;

	std::cout << copyAssignedLecturer.getName() << " " << copyAssignedLecturer.getRating() << std::endl;

	IntArray arr(2);
	arr[0] = 42;
	arr[1] = 13;

	printArray(arr);

	return 0;
}
