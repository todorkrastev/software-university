#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

int main() {
    using namespace std;

    int rows, cols;
    cin >> rows >> cols;
    vector<vector<int> > rectangle(rows, vector<int>(cols));
    for (int row = 0; row < rows; ++row) {
        for (int col = 0; col < cols; ++col) {
            cin >> rectangle[row][col];
        }
    }

    int side, targetSum;
    cin >> side >> targetSum;

    vector<int> averages{ };

    for (int startRow = 0; startRow <= rows - side; ++startRow) {
        for (int startCol = 0; startCol <= cols - side; ++startCol) {
            int sum = 0;
            for (int row = startRow; row < startRow + side; ++row) {
                for (int col = startCol; col < startCol + side; ++col) {
                    sum += rectangle[row][col];
                }
            }
            if (sum >= targetSum) {
                int average = sum / (side * side);
                averages.emplace_back(average);
            }
        }
    }

    sort(averages.begin(), averages.end());

    copy(averages.cbegin(), averages.cend(), std::ostream_iterator<int>(cout, " "));

    return 0;
}