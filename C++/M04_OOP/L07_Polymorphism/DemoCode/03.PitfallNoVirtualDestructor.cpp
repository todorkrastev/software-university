class IndexedContainer {
public:
	virtual int& operator[](int index) {
		int undefined;
		return undefined;
	};

	// To fix this, uncomment this default virtual destructor and uncomment the override in IntArray
	//virtual ~IndexedContainer() {}
};

class IntArray : public IndexedContainer {
	int size;
	int* data;

public:
	IntArray(int size) : size(size), data(new int[size]) {}

	// Replace witht the commented code after uncommenting the base class virtual destructor
	//virtual ~IntArray() override {
	~IntArray() {
		delete[] this->data;
	}

	virtual int& operator[](int index) override {
		return data[index];
	}
};

int main() {
	for (;;) {
		IndexedContainer* c = new IntArray(10);
		delete c;
	}

	return 0;
}
