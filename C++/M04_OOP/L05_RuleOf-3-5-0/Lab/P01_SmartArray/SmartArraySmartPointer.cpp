#include <iostream>
#include <memory>
#include <utility>

template <typename T>
class SmartArray {
public:
  class Iterator {
  public:
    Iterator(T *data, size_t size, size_t idx)
        : _data(data), _size(size), _idx(idx) {
    }

    Iterator& operator++() {
      ++_idx;
      return *this;
    }

    bool operator!=(const Iterator& other) {
      return _idx != other._idx;
    }

    T& operator*() {
      return _data[_idx];
    }

  private:
    T *_data;
    const size_t _size;
    size_t _idx;
  };

  SmartArray(size_t size)
      : _data(new T[size] { }), _size(size) {
  }

  SmartArray(const SmartArray &other) = delete;
  SmartArray& operator=(const SmartArray &other) = delete;

  SmartArray(SmartArray &&other) = delete;
  SmartArray& operator=(SmartArray &&other) = delete;

  ~SmartArray() = default;

  T& operator[](size_t index) {
    return _data[index];
  }

  void print() const {
    for (size_t i = 0; i < _size; ++i) {
      std::cout << _data[i] << ' ';
    }
    std::cout << std::endl;
  }

  void resize(size_t newSize) {
    std::unique_ptr<T[]> newData(new T[newSize]{});
    for (size_t i = 0; i < _size && i < newSize; ++i) {
      newData[i] = _data[i];
    }

    _data = std::move(newData);
    _size = newSize;
  }

  Iterator begin() {
    return Iterator(_data.get(), _size, 0);
  }

  Iterator end() {
    return Iterator(_data.get(), _size, _size);
  }

private:
  std::unique_ptr<T[]> _data;
  size_t _size;
};

int main() {
  SmartArray<int> arr(5);
  arr[2] = 42;
  arr.print();

  arr.resize(10);
  arr.print();

  arr.resize(2);
  arr.print();

  std::cout << "custom range based for loop:" << std::endl;
  for (const auto elem : arr) {
    std::cout << elem << ' ';
  }
  std::cout << std::endl;

  return 0;
}
