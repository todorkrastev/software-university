#include <iostream>
#include <string>
#include <vector>

int main() {

  std::vector<int> numbers { 42, 13, 69 };
  // Example: Change each element in the vector by dividing it by 2
  for (std::vector<int>::iterator i = numbers.begin(); i != numbers.end();
      i++) {
    *i /= 2;
  }

  for (int number : numbers) {
    std::cout << number << " ";
  }
  std::cout << std::endl << std::endl;

  std::vector<std::string> words { "the", "quick", "purple", "fox" };
  // Example: print each string element and its length
  for (std::vector<std::string>::iterator i = words.begin(); i != words.end();
      i++) {
    std::cout << *i << ": " << i->size() << std::endl;
    // NOTE: the same can be done with this code:
    //cout << *i << ": " << (*i).size() << endl;
  }

  return 0;
}
