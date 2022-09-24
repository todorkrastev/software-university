#include "Snake.h"

static Point getNextPos(const Point & currPos, const Direction dir) {
    Point nextPos = currPos;
    switch(dir) {
        case Direction::UP:
            --nextPos.row;
            break;

        case Direction::RIGHT:
            ++nextPos.col;
            break;

        case Direction::DOWN:
            ++nextPos.row;
            break;

        case Direction::LEFT:
            --nextPos.col;
            break;
    }

    return nextPos;
}

static bool isValidPos(const Point &              currPos,
                       const std::vector<Point> & obstacles,
                       const std::deque<Point> &  snakeBody,
                       const int                  fieldRows,
                       const int                  fieldCols) {
    if(0 > currPos.row          ||
       0 > currPos.col          ||
       fieldRows <= currPos.row ||
       fieldCols <= currPos.col) {
        return false;
    }

    for(const Point & obstacle : obstacles) {
        if(obstacle == currPos) {
            return false;
        }
    }

    for(const Point & bodyNode : snakeBody) {
        if(bodyNode == currPos) {
            return false;
        }
    }

    return true;
}

static bool shouldPowerUp(const Point &              currPos,
                          const std::vector<Point> & powerUps,
                          int &                      outFoundIdx) {
    const int POWER_UPS_SIZE = static_cast<int>(powerUps.size());

    for(int i = 0; i < POWER_UPS_SIZE; ++i) {
        if(powerUps[i] == currPos) {
            outFoundIdx = i;
            return true;
        }
    }

    return false;
}

Snake::Snake(const int     fieldRows,
             const int     fieldCols,
             const Point & startPos) : _FIELD_ROWS(fieldRows),
                                       _FIELD_COLS(fieldCols),
                                       _currPos(startPos),
                                       _snakeNodes{startPos} {

}

Snake::~Snake() {

}

StatusCode Snake::move(const Direction            dir,
                       const std::vector<Point> & obstacles,
                       std::vector<Point> &       powerUps) {
    StatusCode status = StatusCode::STATUS_UNKNOWN;

    const Point NEXT_HEAD_POS = getNextPos(_currPos, dir);

    if(!isValidPos(NEXT_HEAD_POS,
                   obstacles,
                   _snakeNodes,
                   _FIELD_ROWS,
                   _FIELD_COLS)) {
        //snake is dead, no need to move it
        status = StatusCode::SNAKE_DEAD;
    } else {
        int foundIdx = -1;
        if(shouldPowerUp(NEXT_HEAD_POS, powerUps, foundIdx)) {
            status = StatusCode::SNAKE_GROWING;

            //grow the snake at head
            _snakeNodes.push_front(powerUps[foundIdx]);

            powerUps.erase(powerUps.begin() + foundIdx);
        } else {
            status = StatusCode::SNAKE_MOVING;

            //no need to move inner nodes
            //simply add the new one to the head, and remove the tail
            _snakeNodes.push_front(NEXT_HEAD_POS);
            _snakeNodes.pop_back();
        }

        _currPos = NEXT_HEAD_POS;
    }

    return status;
}

std::deque<Point> & Snake::getSnakeNodes() {
    return _snakeNodes;
}

