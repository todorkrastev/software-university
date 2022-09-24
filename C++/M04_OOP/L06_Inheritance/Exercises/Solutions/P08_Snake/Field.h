#ifndef FIELD_H_
#define FIELD_H_

#include <string>

#include "Structs.h"
#include "Snake.h"

class Field {
    public:
        Field(const FieldConfig & cfg);

        ~Field() = default;

        void generatePowerUp(const Point & pos);

        void generateObstacle(const Point & pos);

        StatusCode moveSnake(const Direction dir);

        void printField(const bool isInitialPrint = false) const;

    private:
        void updateFieldState();

        const int                _ROWS;
        const int                _COLS;

        std::vector<Point>       _obstacles;
        std::vector<Point>       _powerUps;

        std::vector<std::string> _fieldNodes;

        Snake                    _snake;
};

#endif /* FIELD_H_ */
