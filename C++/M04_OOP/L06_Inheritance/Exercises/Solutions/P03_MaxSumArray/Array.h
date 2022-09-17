#ifndef ARRAY_H
#define ARRAY_H

#include <cstdlib>

template<typename T>
class Array {
	T* data;
	size_t size;
public:
	Array(size_t size) : data(new T[size]{}), size(size) {}

	Array(std::initializer_list<T> initList) : data(new T[initList.size()]), size(initList.size()) {
		int index = 0;
		for (auto item : initList) {
			this->data[index] = item;
			index++;
		}
	}

	T* begin() const {
		return this->data;
	}

	T* end() const {
		return this->data + this->size;
	}

	Array(const Array& other) : data(new T[other.size]{}), size(other.size) {
		for (size_t i = 0; i < other.size; i++) {
			this->data[i] = other[i];
		}
	}

	size_t getSize() const {
		return this->size;
	}

	T& operator[](size_t index) const {
		return this->data[index];
	}

	Array& operator=(Array other) {
		if (this != &other) {
			swap(*this, other);
		}

		return *this;
	}

	friend void swap(Array& a, Array& b) {
		using std::swap;

		swap(a.data, b.data);
		swap(a.size, b.size);
	}

	~Array() {
		delete[] this->data;
		this->data = nullptr;
	}
};

#endif // !ARRAY_H

