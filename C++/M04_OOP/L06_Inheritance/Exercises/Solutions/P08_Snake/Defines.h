#ifndef DEFINES_H_
#define DEFINES_H_

enum InputCommands {
    MOVE_SNAKE        = 0,
    GENERATE_OBSTACLE = 1,
    GENERATE_POWER_UP = 2
};

enum FieldMarkerDefines {
    EMPTY_FIELD_MARKER = '.',
    OBSTACLE_MARKER    = 'o',
    POWER_UP_MARKER    = '*',
    SNAKE_HEAD_MARKER  = '@',
    SNAKE_BODY_MARKER  = 'x'
};

enum class Direction {
    UP    = 0,
    RIGHT = 1,
    DOWN  = 2,
    LEFT  = 3
};

enum class StatusCode {
    SNAKE_MOVING   = 0,
    SNAKE_GROWING  = 1,
    SNAKE_DEAD     = 2,

    STATUS_UNKNOWN = 255
};

enum GeneralDefines {
    DIRECTIONS_COUNT = 4
};


#endif /* DEFINES_H_ */
