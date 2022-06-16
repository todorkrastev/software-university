#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

std::vector<std::string> clearGlitches(const std::vector<std::string>& matrix) {
    std::string glitches{ "!?@#$%^&*()_+-=[]{}|:" };

    std::vector<std::string> clearedMatrix(matrix.size(), std::string(matrix.size(), '.'));

    for (size_t row = 0; row < matrix.size(); ++row) {
        size_t pos = 0;
        while ((pos = matrix[row].find_first_of(glitches, pos)) != std::string::npos) {
            const char glitch = matrix[row][pos];

            glitches.replace(glitches.find_first_of(glitch), 1, "");

            size_t endRow = row;
            while (endRow < matrix.size() && matrix[endRow][pos] == glitch) {
                ++endRow;
            }

            const size_t radius = (endRow - row) / 2;

            clearedMatrix[row + radius][pos] = glitch;
        }
    }

    return clearedMatrix;
}

int main() {

    size_t matrixSize;
    std::cin >> matrixSize;

    std::vector<std::string> matrix;
    std::copy_n(std::istream_iterator<std::string>(std::cin),
        matrixSize,
        std::back_inserter(matrix));

    std::vector<std::string> result = clearGlitches(matrix);

    std::copy(result.cbegin(), result.cend(), std::ostream_iterator<std::string>(std::cout, "\n"));

    return 0;
}


// -----------------------------------------------------------------------------

// Second Option

// -----------------------------------------------------------------------------


#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

std::vector<std::string> clearGlitches(const std::vector<std::string>& matrix) {
    std::string glitches{ "!?@#$%^&*()_+-=[]{}|:" };

    std::vector<std::string> clearedMatrix(matrix.size(), std::string(matrix.size(), '.'));

    for (size_t row = 0; row < matrix.size(); ++row) {
        size_t pos = 0;
        while ((pos = matrix[row].find_first_of(glitches, pos)) != std::string::npos) {
            const char glitch = matrix[row][pos];

            glitches.replace(glitches.find_first_of(glitch), 1, "");

            size_t endRow = row;
            while (endRow < matrix.size() && matrix[endRow][pos] == glitch) {
                ++endRow;
            }

            const size_t radius = (endRow - row) / 2;

            clearedMatrix[row + radius][pos] = glitch;
        }
    }

    return clearedMatrix;
}

int main() {
    std::istream& in = std::cin;
    std::ostream& out = std::cout;

    size_t matrixSize;
    in >> matrixSize;

    std::vector<std::string> matrix{ };
    std::copy_n(std::istream_iterator<std::string>(in),
        matrixSize,
        std::back_inserter(matrix));

    std::vector<std::string> result = clearGlitches(matrix);

    std::copy(result.cbegin(), result.cend(), std::ostream_iterator<std::string>(out, "\n"));

    return 0;
}