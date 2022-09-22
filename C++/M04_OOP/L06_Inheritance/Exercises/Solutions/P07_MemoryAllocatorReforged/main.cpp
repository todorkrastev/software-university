#include <iostream>
#include <vector>
#include <string>
#include "Defines.h"

ErrorCode executeCommand(const std::string &       command,
                         std::vector<MemoryNode> & memory);

void printResult(const ErrorCode     errorCode,
                 const std::string & command);

int main() {
    std::string             command;
    int 			        inputSize = 0;
    std::vector<MemoryNode> memory(BUFFER_SIZE);

    std::cin >> inputSize;
    std::cin.ignore();

    for(int i = 0; i < inputSize; ++i) {
        getline(std::cin, command);

        const ErrorCode errorCode = executeCommand(command, memory);

        printResult(errorCode, command);
    }

    return 0;
}


