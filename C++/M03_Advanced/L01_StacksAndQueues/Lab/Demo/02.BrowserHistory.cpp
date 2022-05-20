#include <iostream>
#include <stack>
#include <string>

std::string readInput() {
  std::string input;
  getline(std::cin, input);
  return input;
}

void executeAddUrl(const std::string &newUrl,
                   std::stack<std::string> &urlHistory) {
  urlHistory.push(newUrl);
  std::cout << "Last URL: " << newUrl << std::endl;
}

void executeBackUrl(std::stack<std::string> &urlHistory) {
  if (urlHistory.empty()) {
    std::cout << "no previous URL" << std::endl;
    return;
  }

  urlHistory.pop();
  if (urlHistory.empty()) {
    std::cout << "Empty browser" << std::endl;
  } else {
    std::cout << urlHistory.top() << std::endl;
  }
}

int main() {
  std::stack<std::string> urlHistory;
  std::string currUrl;
  const std::string delimiter = "end";
  const std::string backInstruction = "/back";
  while (true) {
    currUrl = readInput();
    if (currUrl == delimiter) {
      break;
    }

    if (currUrl == backInstruction) {
      executeBackUrl(urlHistory);
    } else {
      executeAddUrl(currUrl, urlHistory);
    }
  }

  return 0;
}
