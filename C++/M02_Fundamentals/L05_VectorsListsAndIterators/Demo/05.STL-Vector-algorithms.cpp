#include <iostream>
#include <vector>
#include <algorithm>

void print(const std::vector<int> &numbers) {
  for (int number : numbers) {
    std::cout << number << " ";
  }
  std::cout << std::endl << std::endl;
}

void findAndPrintElement(const std::vector<int> &numbers, int element) {
  std::cout << "Element: " << element << ' ';

  std::vector<int>::const_iterator it = std::find(numbers.begin(),
      numbers.end(), element);
  if (it == numbers.end()) {
    std::cout << "not found" << std::endl;
  } else {
    std::cout << "found at index: " << it - numbers.begin() << std::endl;
  }
}

int main() {
  std::vector<int> numbers { 1, -4, 13, 8 };
  findAndPrintElement(numbers, 7);
  findAndPrintElement(numbers, 8);

  std::sort(numbers.begin(), numbers.end());
  findAndPrintElement(numbers, 8);
  print(numbers);

  std::sort(numbers.begin(), numbers.end(), std::less<int>());
  findAndPrintElement(numbers, 8);
  print(numbers);

  std::sort(numbers.begin(), numbers.end(), std::greater<int>());
  findAndPrintElement(numbers, 8);
  print(numbers);

  return 0;
}
