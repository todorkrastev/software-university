#ifndef STRUCTS_H_
#define STRUCTS_H_

#include <vector>

struct Point {
    Point(const int inputRow,
          const int inputCol) : row(inputRow),
                                col(inputCol) {

    }

    Point() : row(0), col(0) {

    }

    bool operator==(const Point & other) const {
        return (row == other.row) && (col == other.col);
    }

    bool operator!=(const Point & other) const {
        return !operator==(other);
    }

    int row;
    int col;
};

struct FieldConfig {
    FieldConfig(const int                  inputRowsCount,
                const int                  inputColsCount,
                const Point &              inputSnakeStartPos,
                const std::vector<Point> & inputObstacles,
                const std::vector<Point> & inputPowerUps) :
                                              rowsCount(inputRowsCount),
                                              colsCount(inputColsCount),
                                              snakeStartPos(inputSnakeStartPos),
                                              obstacles(inputObstacles),
                                              powerUps(inputPowerUps) {

    }

    const int                rowsCount;
    const int                colsCount;
    const Point              snakeStartPos;
    const std::vector<Point> obstacles;
    const std::vector<Point> powerUps;
};

#endif /* STRUCTS_H_ */
