#include <iostream>
#include <string>
#include <vector>
#include <memory>

class IntArray {
	std::shared_ptr<int> data;
	int size;
public:
	IntArray(int size) : data(new int[size], [](int* p) { delete[] p; }), size(size) {}

	int getSize() const {
		return this->size;
	}

	int& operator[](const int index) const {
		return this->data.get()[index];
	}
};

int main() {
	while (true) {
		// no memory leak
		IntArray arr(10);
		arr[0] = 42;
		arr = arr;
		std::cout << arr[0] << std::endl;
	}

	return 0;
}