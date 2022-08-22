#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include "Defines.h"

enum CommandAction {
	ALLOCATE = 0,
	DEALLOCATE,
	IDLE,
	OUT_OF_BOUND
};

CommandAction getCommand(const std::string& command,
	const size_t memorySize,
	size_t& outIndex) {
	if ("Idle" == command) {
		return CommandAction::IDLE;
	}

	std::istringstream sstr(command);
	std::string action;

	sstr >> action >> outIndex;

	if (outIndex >= memorySize) {
		return CommandAction::OUT_OF_BOUND;
	}

	if ("Allocate" == action) {
		return CommandAction::ALLOCATE;
	}

	return CommandAction::DEALLOCATE;
}

ErrorCode executeCommand(const std::string& command,
	std::vector<int*>& memory) {
	ErrorCode errorCode;

	size_t index = 0;
	const CommandAction commandAction = getCommand(command,
		memory.size(),
		index);

	switch (commandAction) {
	case CommandAction::ALLOCATE:
		if (nullptr == memory[index]) {
			memory[index] = new int;
			errorCode = ErrorCode::EXECUTE_SUCCESS;
		} else {
			errorCode = ErrorCode::MEMORY_LEAK;
		}
		break;

	case CommandAction::DEALLOCATE:
		if (nullptr != memory[index]) {
			delete memory[index];
			memory[index] = nullptr;

			errorCode = ErrorCode::EXECUTE_SUCCESS;
		} else {
			errorCode = ErrorCode::DOUBLE_FREE;
		}
		break;

	case CommandAction::IDLE:
		errorCode = ErrorCode::EXECUTE_IDLE;
		break;

	case CommandAction::OUT_OF_BOUND:
		errorCode = ErrorCode::INDEX_OUT_OF_BOUND;
		break;

	default:
		break;
	}

	return errorCode;
}

void printResult(const ErrorCode errorCode,
	const std::string& command)
{
	std::cout << command << " - ";

	switch (errorCode) {
	case ErrorCode::EXECUTE_SUCCESS:
		std::cout << "success";
		break;

	case ErrorCode::EXECUTE_IDLE:
		std::cout << "this exam is a piece of cake! Where is the OOP already?!?";
		break;

	case ErrorCode::MEMORY_LEAK:
		std::cout << "memory leak prevented, will not make allocation";
		break;

	case ErrorCode::DOUBLE_FREE:
		std::cout << "system crash prevented, will skip this deallocation";
		break;

	case ErrorCode::INDEX_OUT_OF_BOUND:
		std::cout << "out of bound";
		break;

	default:
		std::cerr << "Warning, received unknown ErrorCode: "
			<< errorCode << std::endl;
		break;
	}

	std::cout << std::endl;
}