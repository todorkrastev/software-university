#include <iostream>
#include <string>

class IntArray {
	int* data;
	int size;
public:
	IntArray(int size) : data(new int[size]{}), size(size) {}

	~IntArray() {
		delete[] this->data;
	}

	IntArray(const IntArray& other) : data(nullptr), size(0) {
		this->resetData(other.data, other.size);
	}

	IntArray& operator=(const IntArray& other) {
		if (this != &other) {
			this->resetData(other.data, other.size);
		}
		return *this;
	}

	int getSize() const {
		return this->size;
	}

	int& operator[](const int index) const {
		return this->data[index];
	}

private:
	void resetData(int* otherData, int otherSize) {
		int* copyData = new int[otherSize];

		for (int i = 0; i < otherSize; i++) {
			copyData[i] = otherData[i];
		}

		if (this->data != nullptr) {
			delete[] this->data;
		}

		this->data = copyData;
		this->size = otherSize;
	}
};

int main() {
	IntArray arr(10);
	IntArray copyArr = arr;

	for (int i = 0; i < arr.getSize(); i++) {
		arr[i] = i;
		std::cout << arr[i] << std::endl;
	}

	copyArr[3] = 42;

	// these will not be the same thanks the the copy assignment operator overload
	for (int i = 0; i < arr.getSize(); i++) {
		std::cout << arr[i] << " vs. " << copyArr[i] << std::endl;
	}

	return 0;
}

