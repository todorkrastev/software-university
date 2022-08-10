#include <vector>
#include <utility>
#include <iostream>

class VectorWrapper {
public:
  VectorWrapper(const std::vector<int>& data) : _data(data) {}

  VectorWrapper(VectorWrapper&& other) : _data(std::move(other._data)) {
    std::cout << "Invoking Move Ctor" << std::endl;
  }

  VectorWrapper& operator=(VectorWrapper&& other) {
    std::cout << "Invoking Move Assignment operator" << std::endl;
    if (this != &other) {
      _data = std::move(other._data);
    }
    return *this;
  }

  void print() const {
    if (_data.empty()) {
      std::cout << "Data is empty" << std::endl;
      return;
    }

    for (const auto elem : _data) {
      std::cout << elem << ' ';
    }
    std::cout << std::endl;
  }

  void clearData() {
    _data.clear();
  }

private:
  std::vector<int> _data;
};

int main() {
  const std::vector<int> data = { 1, 2, 3 };
  VectorWrapper first(data);
  first.print();

  //compilation error - copy ctor invoked
  //VectorWrapper second(first);

  VectorWrapper second(std::move(first));
  second.print();

  first.clearData();
  first.print();
  first = std::move(second);
  first.print();

	return 0;
}
