#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include "Defines.h"

enum CommandAction {
    ALLOCATE_SINGLE = 0,
    ALLOCATE_MULTIPLE,
    DEALLOCATE_SINGLE,
    DEALLOCATE_MULTIPLE
};

CommandAction getCommand(const std::string & command,
                         size_t & 		     outIndex) {
    CommandAction commandAction;
    std::istringstream sstr(command);
    std::string action;
    std::string type;

    sstr >> action >> type >> outIndex;

    if("Allocate" == action) {
        if("Single" == type) {
            commandAction = CommandAction::ALLOCATE_SINGLE;
        } else { //"Multiple" == type 
            commandAction = CommandAction::ALLOCATE_MULTIPLE;
        }
    } else { //"Deallocate == action"
        if("Single" == type) {
            commandAction = CommandAction::DEALLOCATE_SINGLE;
        } else { //"Multiple" == type
            commandAction = CommandAction::DEALLOCATE_MULTIPLE;
        }
    }

    return commandAction;
}

ErrorCode executeCommand(const std::string &       command,
                         std::vector<MemoryNode> & memory) {
    ErrorCode errorCode;

    size_t index = 0;
    const CommandAction commandAction = getCommand(command,
                                                   index);

    switch(commandAction) {
        case CommandAction::ALLOCATE_SINGLE:
            if(nullptr == memory[index].rawMemory) {
                memory[index].rawMemory = new int;
                memory[index].memoryType = MemoryType::SINGLE;
                errorCode = ErrorCode::EXECUTE_SUCCESS;
            }
            else {
                errorCode = ErrorCode::MEMORY_LEAK;
            }
            break;

        case CommandAction::ALLOCATE_MULTIPLE:
            if(nullptr == memory[index].rawMemory) {
                memory[index].rawMemory = new int[ALLOCATION_MULTIPLE_SIZE];
                memory[index].memoryType = MemoryType::MULTIPLE;
                errorCode = ErrorCode::EXECUTE_SUCCESS;
            } else {
                errorCode = ErrorCode::MEMORY_LEAK;
            }
            break;

        case CommandAction::DEALLOCATE_SINGLE:
            if(nullptr != memory[index].rawMemory) {
                if(MemoryType::SINGLE == memory[index].memoryType) {
                    delete memory[index].rawMemory;
                    memory[index].rawMemory = nullptr;
                    memory[index].memoryType = MemoryType::UNKNOWN;

                    errorCode = ErrorCode::EXECUTE_SUCCESS;
                } else { //MemoryType::MULTIPLE == memory[index].memoryType
                    errorCode = ErrorCode::ALLOCATE_DEALLOCATE_MISMATCH;
                }
            } else {
                errorCode = ErrorCode::DOUBLE_FREE;
            }
            break;

        case CommandAction::DEALLOCATE_MULTIPLE:
            if(nullptr != memory[index].rawMemory) {
                if(MemoryType::MULTIPLE == memory[index].memoryType) {
                    delete[] memory[index].rawMemory;
                    memory[index].rawMemory = nullptr;
                    memory[index].memoryType = MemoryType::UNKNOWN;

                    errorCode = ErrorCode::EXECUTE_SUCCESS;
                } else { //MemoryType::SINGLE == memory[index].memoryType
                    errorCode = ErrorCode::ALLOCATE_DEALLOCATE_MISMATCH;
                }
            } else {
                errorCode = ErrorCode::DOUBLE_FREE;
            }
            break;

        default:
            break;
    }

    return errorCode;
}

void printResult(const ErrorCode     errorCode,
                 const std::string & command) {
    std::cout << command << " - ";

    switch(errorCode) {
        case ErrorCode::EXECUTE_SUCCESS:
            std::cout << "success";
            break;

        case ErrorCode::MEMORY_LEAK:
            std::cout << "memory leak prevented, will not make allocation";
            break;

        case ErrorCode::DOUBLE_FREE:
            std::cout << "system crash prevented, will skip this deallocation";
            break;

        case ErrorCode::ALLOCATE_DEALLOCATE_MISMATCH:
            std::cout << "Warning allocate/deallocate mismatch, "
                                                 "will skip this deallocation";
            break;

        default:
            std::cerr << "Warning, received unknown ErrorCode: "
                      << errorCode << std::endl;
            break;
    }

    std::cout << std::endl;
}


