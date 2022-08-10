#include <vector>
#include <utility>
#include <iostream>
#include <memory>

int main() {
  std::unique_ptr<int> first(new int(42));
  std::unique_ptr<int> second(new int(64));

  //compilation error
//  first = second;

  first = std::move(second);
  std::cout << *first << std::endl;

  std::vector<std::unique_ptr<int>> pointers;

  //compilation error
//  pointers.push_back(first);

  pointers.push_back(std::move(first));

  std::cout << *pointers.back();

  return 0;
}
