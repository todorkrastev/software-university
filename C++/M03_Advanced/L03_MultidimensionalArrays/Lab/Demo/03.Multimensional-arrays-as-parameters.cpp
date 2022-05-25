#include <iostream>
const int rows = 3;
const int cols = 5;

void increaseAllElements(int arr[rows][cols], int incrValue) {
  for (int i = 0; i < rows; ++i) {
    for (int j = 0; j < cols; ++j) {
      arr[i][j] += incrValue;
    }
  }
}

//first dimension could be skipped
void printArray(int arr[][cols]) {
  for (int i = 0; i < rows; ++i) {
    for (int j = 0; j < cols; ++j) {
       std::cout << arr[i][j] << ' ';
    }
    std::cout << std::endl;
  }
}

int main() {
  int arr[rows][cols] {}; //zero initializer
  increaseAllElements(arr, 1);
  printArray(arr);

  return 0;
}

