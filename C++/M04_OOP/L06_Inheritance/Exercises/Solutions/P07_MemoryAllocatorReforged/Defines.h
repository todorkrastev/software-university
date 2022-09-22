#ifndef DEFINES_H_
#define DEFINES_H_

#define BUFFER_SIZE 10

#define ALLOCATION_MULTIPLE_SIZE 500

enum ErrorCode {
    EXECUTE_SUCCESS    			 = 0,
    MEMORY_LEAK        			 = 1,
    DOUBLE_FREE        			 = 2,
    ALLOCATE_DEALLOCATE_MISMATCH = 3
};

enum MemoryType : unsigned char {
    SINGLE   = 0,
    MULTIPLE = 1,

    UNKNOWN  = 255
};

struct MemoryNode {
    MemoryNode() : rawMemory(nullptr), memoryType(MemoryType::UNKNOWN) {

    }

    int * rawMemory;
    int   memoryType;
};

#endif /* DEFINES_H_ */
