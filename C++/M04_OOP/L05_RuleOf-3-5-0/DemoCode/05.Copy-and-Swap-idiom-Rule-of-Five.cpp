#include <iostream>
#include <algorithm>
#include <cstddef>

template <typename T>
class SmartArray {
public:
  SmartArray(size_t size)
      : _size(size), _data(_size ? new T[_size] { } : nullptr) {
  }

  SmartArray(const SmartArray &other)
      : _size(other._size), _data(_size ? new T[_size] { } : nullptr) {
    std::copy(other._data, other._data + _size, _data);
  }

  //Note that we are copying the object, thus creating a temporary copy
  SmartArray& operator=(SmartArray other) {
    swap(*this, other);
    return *this;
  }

  //initialize using the default constructor first
  SmartArray(SmartArray &&other) : SmartArray(0) {
    swap(*this, other);
  }

  ~SmartArray() {
    if (_data) {
      delete[] _data;
    }
  }

  friend void swap(SmartArray &first, SmartArray &second) {
    // by swapping the members of two objects,
    // the two objects are effectively swapped
    std::swap(first._size, second._size);
    std::swap(first._data, second._data);
  }

  T& operator[](size_t index) {
    return _data[index];
  }

  void print() const {
    for (size_t i = 0; i < _size; ++i) {
      std::cout << _data[i] << ' ';
    }
    std::cout << std::endl;
  }

private:
  size_t _size;
  T *_data;
};

int main() {
  SmartArray<int> arr(5);
  arr[2] = 42;

  SmartArray<int> arr2 = std::move(arr);
  std::cout << arr2[2] << std::endl;

  SmartArray<int> arr3(10);
  arr3[2] = 1337;
  arr3 = std::move(arr2);
  std::cout << arr3[2] << std::endl;

  return 0;
}

