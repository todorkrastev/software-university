#include <iostream>
#include <string>

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

	// NOTE: this syntax disables copy-constructing and copy-assigning objects of the class
	// - it is intentional, because otherwise this class will have issues with memory when such copies are done
	// - we will discuss why and how to fix this, as well as what the syntax below means in another demo
	IntArray(const IntArray& other) = delete;
	IntArray& operator=(const IntArray& other) = delete;
};

int main() {
	IntArray arr(10);

	for (int i = 0; i < arr.getSize(); i++) {
		arr[i] = i;
		std::cout << arr[i] << std::endl;
	}

	while (true) {
		// NOTE: if there was no destructor, this would cause a memory leak which would quickly eat up all memory, due to the new-allocation of 100 integers in the constructor
		IntArray arr(10);
		std::cout << "not leaking memory thanks to destructor" << std::endl;
	}

	return 0;
}
