#include <iostream>
#include <queue>

int main() {
  std::priority_queue<int> pQueue;
  pQueue.push(13);
  pQueue.push(69);
  pQueue.push(42);

  while (!pQueue.empty()) {
    std::cout << pQueue.top() << std::endl;
    pQueue.pop();
  }

  std::cout << "===================" << std::endl;

  std::priority_queue<int, std::deque<int>, std::greater<int>> reversedQueue;
  reversedQueue.push(13);
  reversedQueue.push(69);
  reversedQueue.push(42);

  while (!reversedQueue.empty()) {
    std::cout << reversedQueue.top() << std::endl;
    reversedQueue.pop();
  }

  return 0;
}
