#include <iostream>
#include <array>
const int rows = 3;
const int cols = 5;

void increaseAllElementsByCopy(std::array<std::array<int, cols>, rows> arr,
                               int incrValue) {
  for (int i = 0; i < rows; ++i) {
    for (int j = 0; j < cols; ++j) {
      arr[i][j] += incrValue;
    }
  }
}

void increaseAllElementsNoCopy(std::array<std::array<int, cols>, rows>& arr,
                               int incrValue) {
  for (int i = 0; i < rows; ++i) {
    for (int j = 0; j < cols; ++j) {
      arr[i][j] += incrValue;
    }
  }
}

//first dimension could be skipped
void printArray(const std::array<std::array<int, cols>, rows>& arr) {
  for (int i = 0; i < rows; ++i) {
    for (int j = 0; j < cols; ++j) {
      std::cout << arr[i][j] << ' ';
    }
    std::cout << std::endl;
  }
  std::cout << std::endl;
}

int main() {
  std::array<std::array<int, cols>, rows> arr { }; //zero initializer

  increaseAllElementsByCopy(arr, 1);
  printArray(arr);

  increaseAllElementsNoCopy(arr, 1);
  printArray(arr);

  return 0;
}

