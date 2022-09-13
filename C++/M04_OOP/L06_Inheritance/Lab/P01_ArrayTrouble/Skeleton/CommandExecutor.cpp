#include "CommandExecutor.h"
#include "Defines.h"

#include <sstream>
#include <iostream>


CommandExecutor::CommandExecutor(const int maxCommands)
{
    _activeArrays.reserve(maxCommands);
}

void CommandExecutor::extractCommand(const std::string & commandStr)
{
	std::istringstream istr(commandStr);
	int currCommand = 0;
	istr >> currCommand;

	switch(currCommand)
	{
		case InputCommands::CREATE:
		{
			int nodeSize = 0;
			istr >> nodeSize;

			executeCreateArray(nodeSize);
		}
			break;

		case InputCommands::COPY_CONSTRUCT:
		{
		    int memoryNodeIdx = 0;
	        istr >> memoryNodeIdx;
	        executeCopyConstructArray(memoryNodeIdx);
		}
			break;

		case InputCommands::COPY_ASSIGN:
        {
            int fromIdx = 0;
            int toIdx = 0;
            istr >> fromIdx >> toIdx;
            executeCopyAssignArray(fromIdx, toIdx);
        }
			break;

		case InputCommands::SUM_ARRAY_DATA:
        {
            int memoryNodeIdx = 0;
            istr >> memoryNodeIdx;
            executeSumArrayData(memoryNodeIdx);
        }
			break;

		case InputCommands::INCR_ARRAY_DATA_VALUE:
		{
            int memoryNodeIdx = 0;
		    int incrValue = 0;
            istr >> memoryNodeIdx >> incrValue;

            executeIncrArrayDataValue(incrValue, memoryNodeIdx);
		}
		    break;

		default:
		    std::cerr << "Warning, received unknown InputCommand: "
		              << currCommand << std::endl;
		    break;
	}
}

void CommandExecutor::executeCreateArray(const int arraySize)
{
	_activeArrays.emplace_back(arraySize);

    std::cout << "CREATE for idx: " << _activeArrays.size() - 1 << std::endl;
}

void CommandExecutor::executeCopyConstructArray(const int fromArrayIdx)
{
    _activeArrays.push_back(_activeArrays[fromArrayIdx]);

    std::cout << "COPY_CONSTRUCT from idx: " << fromArrayIdx << std::endl;
}

void CommandExecutor::executeCopyAssignArray(const int fromIdx, const int toIdx)
{
    _activeArrays[toIdx] = _activeArrays[fromIdx];

    std::cout << "COPY_ASSIGN from idx: " << fromIdx
              << ", to idx: " << toIdx << std::endl;
}

void CommandExecutor::executeSumArrayData(const int arrayIdx)
{
	const int SUM = _activeArrays[arrayIdx].getMemorySumValue();

	std::cout << "SUM_ARRAY_DATA for idx: " << arrayIdx
	          << ", sum: " << SUM << std::endl;
}

void CommandExecutor::executeIncrArrayDataValue(const int incrValue,
                                                const int arrayIdx)
{
    _activeArrays[arrayIdx].addValueToMemory(incrValue);

    std::cout << "INCR_ARRAY_DATA_VALUE for idx: " << arrayIdx
              << ", incrValue: " << incrValue << std::endl;
}


