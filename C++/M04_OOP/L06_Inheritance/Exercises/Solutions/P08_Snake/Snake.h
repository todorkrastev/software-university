#ifndef SNAKE_H_
#define SNAKE_H_

#include "Structs.h"
#include "Defines.h"

#include <deque>

class Snake {
    public:
        Snake(const int     fieldRows,
              const int     fieldCols,
              const Point & startPos);

        ~Snake();

        StatusCode move(const Direction            dir,
                        const std::vector<Point> & obstacles,
                        std::vector<Point> &       powerUps);

        std::deque<Point> & getSnakeNodes();

    private:
        const int         _FIELD_ROWS;
        const int         _FIELD_COLS;

        Point             _currPos;

        //std::deque<> has same API as std::vector<>
        //with some additional functionalities
        std::deque<Point> _snakeNodes; //holds snake head + body nodes
};

#endif /* SNAKE_H_ */
