#include <iostream>
#include <vector>
#include <algorithm>
#include <chrono>
#include <limits>
#include <random>

std::vector<std::vector<int>> getRandomVec2D(const int size) {
  std::cout << "Generating random 2D vector of square size: " << size
            << std::endl;

  std::vector<std::vector<int>> vec = std::vector<std::vector<int>>(size,
      std::vector<int>(size));

  std::random_device rd;
  std::mt19937 generator(rd());
  std::uniform_int_distribution<int> range(0, 100);

  for (auto &row : vec) {
    for (auto &elem : row) {
      elem = range(generator);
    }
  }

  std::cout << "Done" << std::endl;

  return vec;
}

int findLargestColumnSum(const std::vector<std::vector<int>>& vec) {
  std::cout << "Start the clock now" << std::endl;
  const auto start = std::chrono::high_resolution_clock::now();

  int globalSum = std::numeric_limits<int>::min();
  const size_t size = vec.size();

  for (size_t i = 0; i < size; ++i) {
    int localSum = 0;
    for (size_t j = 0; j < size; ++j) {
      localSum += vec[j][i];
    }

    if (localSum > globalSum) {
      globalSum = localSum;
    }
  }
  std::cout << "The operation took ";

  const auto end = std::chrono::high_resolution_clock::now();
  const auto elapsed = std::chrono::duration_cast<std::chrono::milliseconds>(
      end - start);
  std::cout << elapsed.count() << " ms" << std::endl;

  return globalSum;
}

int main() {
  //Warning - this example takes 6GB of RAM on a 64bit platform!
  const auto size = 20000;
  const auto vec = getRandomVec2D(size);
  const auto largestSum = findLargestColumnSum(vec);

  std::cout << "Largest sum is: " << largestSum << std::endl;

  return 0;
}

