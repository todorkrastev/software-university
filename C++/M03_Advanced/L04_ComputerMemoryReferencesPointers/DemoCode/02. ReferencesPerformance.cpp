#include <iostream>
#include <vector>

void printZeroIndices(const std::vector<int>& numbers) {
    for (int i = 0; i < numbers.size(); i++) {
        if (numbers[i] == 0) {
            std::cout << i << " ";
        }
    }
}

int main() {
    using namespace std;

    vector<int> numbers{ 1, 0, -2, 7, 0, 10, -100, 42 };
    // NOTE: most compilers would optimize this call by inlining the function,
    // so even if we don't use a reference, the code will execute with similar
    // speed. However, in more complex situations, the compiler won't be able to
    // always inline, so using references to avoid object copies is good practice
    printZeroIndices(numbers);

    return 0;
}
