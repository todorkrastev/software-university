#include <iostream>
#include <vector>
#include <algorithm>
#include "Matrix.h"

#define MATRICES_COUNT 5

bool matrixSizeComparator(const std::pair<int, int> & left,
                          const std::pair<int, int> & right) {
    return left.first > right.first;
}

int main() {
    std::vector<std::vector<int>> inputData;
    std::vector<Matrix> matrices(MATRICES_COUNT);
    std::vector<std::pair<int, int>> sortedIndexesBySize(MATRICES_COUNT);

    for(int i = 0; i < MATRICES_COUNT; ++i) {
        int matrixSize = 0;
        std::cin >> matrixSize;
        sortedIndexesBySize[i].first = matrixSize;
        sortedIndexesBySize[i].second = i;

        inputData.resize(matrixSize);
        for(int row = 0; row < matrixSize; ++row) {
            inputData[row].resize(matrixSize);
            for(int col = 0; col < matrixSize; ++col) {
                std::cin >> inputData[row][col];
            }
        }

        matrices[i] = inputData;
    }

    std::sort(sortedIndexesBySize.begin(),
              sortedIndexesBySize.end(),
              matrixSizeComparator);

    //add
    matrices[sortedIndexesBySize[0].second] +=
                                        matrices[sortedIndexesBySize[1].second];

    //subtract
    matrices[sortedIndexesBySize[0].second] -=
                                        matrices[sortedIndexesBySize[2].second];

    //multiply
    matrices[sortedIndexesBySize[0].second] *=
                                        matrices[sortedIndexesBySize[3].second];

    //divide
    matrices[sortedIndexesBySize[0].second] /=
                                        matrices[sortedIndexesBySize[4].second];

    std::cout << matrices[sortedIndexesBySize[0].second];

    return 0;
}