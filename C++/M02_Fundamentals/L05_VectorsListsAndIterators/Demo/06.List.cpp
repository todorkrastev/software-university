#include <iostream>
#include <list>

int main() {
    std::list<int> numbers {1, 3, 5};

    // points to AFTER 5
    std::list<int>::iterator lastItemIter = numbers.end();
    lastItemIter--; // points to 5 now
    numbers.insert(lastItemIter, 4);

    // adds to the end - same as numbers.insert(numbers.end(), 6);
    numbers.push_back(6);

    std::list<int>::iterator secondItemIter = numbers.begin(); // points to 1
    secondItemIter++; // points to 3 now
    numbers.insert(secondItemIter, 2);

    // inserts at start - same as numbers.insert(numbers.begin(), 0);
    numbers.insert(numbers.begin(), 0);

    // prints 0 1 2 3 4 5 6
    for (int number : numbers) {
        std::cout << number << " ";
    }

    // By the way, if you replace std::list with std::vector at the start,
    // the printed result will be EXACTLY the same,
    // except that you need to use insert instead of push_front
    // (but operations will be slower, because vector insert is O(N), not O(1)).
    // That's the point of iterators and data structures -
    // they abstract-away the implementation details

    return 0;
}
