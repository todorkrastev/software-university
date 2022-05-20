#include <iostream>
#include <queue>
#include <string>

std::string readInput() {
  std::string input;
  getline(std::cin, input);
  return input;
}

std::queue<std::string> readEvents() {
  std::queue<std::string> events;
  std::string input;
  const std::string delimiter = "end";
  while (true) {
    input = readInput();
    if (input == delimiter) {
      break;
    }

    events.push(input);
  }

  return events;
}

void printContent(std::queue<std::string>& events) {
  while (!events.empty()) {
    std::cout << events.front() << ' ';
    events.pop();
  }
  std::cout << std::endl;
}

int main() {
  std::queue<std::string> events = readEvents();
  printContent(events);

  return 0;
}
