#include <iostream>
#include <vector>

std::vector<std::vector<int>> createVec2D(int rows, int cols) {
  std::vector<std::vector<int>> vec2D(rows, std::vector<int>(cols));

  return vec2D;
}

void increaseAllElementsByCopy(std::vector<std::vector<int>> vec2D,
                               int incrValue) {
  for (auto& row : vec2D) {
    for (auto& elem : row) {
      elem += incrValue;
    }
  }
}

void increaseAllElementsNoCopy(std::vector<std::vector<int>>& vec2D,
                               int incrValue) {
  for (auto& row : vec2D) {
    for (auto& elem : row) {
      elem += incrValue;
    }
  }
}

//first dimension could be skipped
void print(const std::vector<std::vector<int>>& vec2D) {
  for (auto& row : vec2D) {
    for (auto& elem : row) {
      std::cout << elem << ' ';
    }
    std::cout << std::endl;
  }
  std::cout << std::endl;
}

int main() {
  const int rows = 3;
  const int cols = 5;
  auto vec2D = createVec2D(rows, cols);

  increaseAllElementsByCopy(vec2D, 1);
  print(vec2D);

  increaseAllElementsNoCopy(vec2D, 1);
  print(vec2D);

  return 0;
}

