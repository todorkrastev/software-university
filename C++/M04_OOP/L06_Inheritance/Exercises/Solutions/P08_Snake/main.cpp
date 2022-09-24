#include <iostream>
#include <string>

#include "CommandExecutor.h"

//Enable RVO (Return value optimization)
static FieldConfig parseFieldConfig() {
    int fieldRows      = 0;
    int fieldCols      = 0;
    int obstaclesCount = 0;
    int powerUpsCount  = 0;

    int currRow = 0;
    int currCol = 0;

    std::vector<Point> obstacles;
    std::vector<Point> powerUps;
    Point              snakeStartPos;

    std::cin >> fieldRows >> fieldCols
             >> snakeStartPos.row >> snakeStartPos.col;

    std::cin >> obstaclesCount;
    obstacles.reserve(obstaclesCount);

    for(int i = 0; i < obstaclesCount; ++i) {
        std::cin >> currRow >> currCol;
        obstacles.emplace_back(currRow, currCol);
    }

    std::cin >> powerUpsCount;
    powerUps.reserve(powerUpsCount);

    for(int i = 0; i < powerUpsCount; ++i) {
        std::cin >> currRow >> currCol;
        powerUps.emplace_back(currRow, currCol);
    }

    return FieldConfig(fieldRows,
                       fieldCols,
                       snakeStartPos,
                       obstacles,
                       powerUps);
}

int main() {
    CommandExecutor commandExecutor(parseFieldConfig());

    int commands = 0;
    std::string input;

    std::cin >> commands;
    std::cin.ignore();

    for(int i = 0; i < commands; ++i) {
        getline(std::cin, input);

        if(commandExecutor.isGameActive()) {
            commandExecutor.extractCommand(input);
        }
    }

    return 0;
}





























