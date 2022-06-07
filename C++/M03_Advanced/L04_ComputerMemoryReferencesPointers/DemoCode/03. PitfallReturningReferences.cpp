#include <iostream>
#include <vector>
#include <cmath>

std::vector<int>& generateRoots(int toNumber) {
	std::vector<int> roots;
	for (int i = 0; i < toNumber; i++) {
		roots.push_back(sqrt(i));
	}
	return roots;
}

int main() {
    // NOTE: it is possible that this code will seem to work as expected,
    // as the program is short and the memory could still remain the same
    // even after being freed. But it is not guaranteed to work, especially
    // in a real, non-debug environment, where the memory freed by the vector
    // is likely to be overwritten at some point by another program, or even
    // the same program
    std::vector<int>& rootsRef = generateRoots(100);
    // NOTE 2: this otherVector is here to simulate a real environment, where
    // additional memory allocations might overwrite the freed memory. Under
    // Windows, in Code::Blocks with MinGW this otherVector seems to overwrite that memory,
    // making the printed value different. But it is not 100% guaranteed, especially
    // if we change the environment or the compiler. This is exactly why the behavior
    // is "undefined" - we cannot be sure what will happen, because the C++ standard
    // does not place a strict requirement on what should happen, hence different
    // compilers can create code that behaves differently in different situations
    std::vector<int> otherVector{ 42, 13, 69 };
	std::cout << rootsRef[4] << std::endl;

	std::cout << &rootsRef;

	return 0;
}
