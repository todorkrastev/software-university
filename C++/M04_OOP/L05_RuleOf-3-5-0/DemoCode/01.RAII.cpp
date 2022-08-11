#include <iostream>
#include <vector>
#include <numeric>
#include <fstream>

std::vector<int> generateIncreasingSequence(int startNumber, int size) {
  std::vector<int> sequence(size);
  std::iota(sequence.begin(), sequence.end(), startNumber);
  return sequence;
}

//NOTE: the copy is intentional
int accumulate(const std::vector<int> vec) {
  //the vec here is acquiring and releasing resource using the RAII approach
  int result = 0;
  for (const auto elem : vec) {
    result += elem;
  }
  return result;
}

template <typename T>
void writeResultToFile(const std::string& filePath, const T& result) {
  //the file stream is another example of RAII
  std::ofstream fileStream(filePath.c_str(), std::ios::app);
  if (!fileStream.good()) {
    std::cerr << "Error opening file: " << filePath << std::endl;
    return;
  }

  fileStream << result << std::endl;
}

//the implementation of the DynamicArray is yet another example of RAII
class DynamicArray {
public:
  DynamicArray(const std::vector<int>& data) {
    _size = data.size();
    _data = new int[_size];
    for (size_t i = 0; i < _size; ++i) {
      _data[i] = data[i];
    }
  }

  ~DynamicArray() {
    delete _data;
    _data = nullptr;
  }

  friend std::ostream& operator<<(std::ostream& out, const DynamicArray& array);

private:
  int* _data;
  size_t _size;
};

std::ostream& operator<<(std::ostream& out, const DynamicArray& array) {
  for (size_t i = 0; i < array._size; ++i) {
    out << array._data[i] << ' ';
  }
  out << std::endl;
  return out;
}

int main() {
  constexpr auto fileName = "bazinga.txt";
  const std::vector<int> numbers = generateIncreasingSequence(1, 10);
  const int sum = accumulate(numbers);
  writeResultToFile(fileName, sum);

  const DynamicArray array(numbers);
  writeResultToFile(fileName, array);

  return 0;
}

