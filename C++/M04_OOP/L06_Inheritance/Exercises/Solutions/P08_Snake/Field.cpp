#include "Field.h"

#include <iostream>

Field::Field(const FieldConfig & cfg) : _ROWS(cfg.rowsCount),
                                        _COLS(cfg.colsCount),
                                        _obstacles(cfg.obstacles),
                                        _powerUps(cfg.powerUps),
                                        _fieldNodes(_ROWS),
                                        _snake(cfg.rowsCount,
                                               cfg.colsCount,
                                               cfg.snakeStartPos) {
    updateFieldState();
    printField(true);
}

void Field::generatePowerUp(const Point & pos) {
    _powerUps.emplace_back(pos);
    _fieldNodes[pos.row][pos.col] = POWER_UP_MARKER;
}

void Field::generateObstacle(const Point & pos) {
    _obstacles.emplace_back(pos);
    _fieldNodes[pos.row][pos.col] = OBSTACLE_MARKER;
}

StatusCode Field::moveSnake(const Direction dir) {
    const StatusCode STATUS_CODE = _snake.move(dir, _obstacles, _powerUps);

    if(StatusCode::SNAKE_DEAD != STATUS_CODE) {
        updateFieldState();
    }

    return STATUS_CODE;
}

void Field::printField(const bool isInitialPrint) const {
    std::cout << (isInitialPrint ?
            "Printing initial Field state:\n" : "Printing Field:\n");

    for(const std::string & row : _fieldNodes) {
        std::cout << row << '\n';
    }
    std::cout << '\n';
}

void Field::updateFieldState() {
    //reset field
    for(std::string & row : _fieldNodes) {
        row = std::string(_COLS, EMPTY_FIELD_MARKER);
    }

    //apply obstacles
    for(const Point & obstacle : _obstacles) {
        _fieldNodes[obstacle.row][obstacle.col] = OBSTACLE_MARKER;
    }

    //apply power ups
    for(const Point & powerUp : _powerUps) {
        _fieldNodes[powerUp.row][powerUp.col] = POWER_UP_MARKER;
    }

    //apply snake nodes
    const std::deque<Point> & SNAKE_NODES = _snake.getSnakeNodes();
    const size_t SNAKE_SIZE = SNAKE_NODES.size();
    const Point & SNAKE_HEAD = SNAKE_NODES.front();

    _fieldNodes[SNAKE_HEAD.row][SNAKE_HEAD.col] = SNAKE_HEAD_MARKER;

    for(size_t i = 1; i < SNAKE_SIZE; ++i) {
        _fieldNodes[SNAKE_NODES[i].row][SNAKE_NODES[i].col] = SNAKE_BODY_MARKER;
    }
}


