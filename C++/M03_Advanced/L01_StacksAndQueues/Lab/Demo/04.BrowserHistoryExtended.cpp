#include <iostream>
#include <stack>
#include <string>

std::string readInput() {
  std::string input;
  getline(std::cin, input);
  return input;
}

void executeAddUrl(const std::string &newUrl,
                   std::stack<std::string> &urlBackHistory,
                   std::stack<std::string> &urlForwardHistory) {
  urlBackHistory.push(newUrl);
  urlForwardHistory = std::stack<std::string>();
  std::cout << "Last URL: " << newUrl << std::endl;
}

void executeBackUrl(std::stack<std::string> &urlBackHistory,
                    std::stack<std::string> &urlForwardHistory) {
  if (urlBackHistory.empty()) {
    std::cout << "no previous URL" << std::endl;
    return;
  }

  urlForwardHistory.push(urlBackHistory.top());
  urlBackHistory.pop();
  if (urlBackHistory.empty()) {
    std::cout << "Empty browser" << std::endl;
  } else {
    std::cout << urlBackHistory.top() << std::endl;
  }
}

void executeForwardUrl(std::stack<std::string> &urlBackHistory,
                       std::stack<std::string> &urlForwardHistory) {
  if (urlForwardHistory.empty()) {
    std::cout << "no next URL" << std::endl;
    return;
  }

  const std::string currUrl = urlForwardHistory.top();
  urlBackHistory.push(currUrl);
  urlForwardHistory.pop();
  std::cout << "Last URL: " << currUrl << std::endl;
}

int main() {
  std::stack<std::string> urlBackHistory;
  std::stack<std::string> urlForwardHistory;
  std::string currUrl;
  const std::string delimiter = "end";
  const std::string backInstruction = "/back";
  const std::string forwardInstruction = "/forward";
  while (true) {
    currUrl = readInput();
    if (currUrl == delimiter) {
      break;
    }

    if (currUrl == backInstruction) {
      executeBackUrl(urlBackHistory, urlForwardHistory);
    } else if (currUrl == forwardInstruction) {
      executeForwardUrl(urlBackHistory, urlForwardHistory);
    } else {
      executeAddUrl(currUrl, urlBackHistory, urlForwardHistory);
    }
  }

  return 0;
}
