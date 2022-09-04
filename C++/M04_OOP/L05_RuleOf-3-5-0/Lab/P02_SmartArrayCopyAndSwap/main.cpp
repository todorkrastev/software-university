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

  SmartArray(SmartArray &&other) = delete;
  SmartArray& operator=(SmartArray &&other) = delete;

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
  arr.print();

  SmartArray<int> arrCopy(10);
  arrCopy[1] = 1337;
  arrCopy.print();

  arrCopy = arr;
  arrCopy[0] = 7;
  arrCopy.print();

  return 0;
}
