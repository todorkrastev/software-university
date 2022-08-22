#ifndef DEFINES_H_
#define DEFINES_H_

enum ErrorCode {
    EXECUTE_SUCCESS    = 0,
    EXECUTE_IDLE       = 1,
    MEMORY_LEAK        = 2,
    DOUBLE_FREE        = 3,
    INDEX_OUT_OF_BOUND = 4
};



#endif /* DEFINES_H_ */