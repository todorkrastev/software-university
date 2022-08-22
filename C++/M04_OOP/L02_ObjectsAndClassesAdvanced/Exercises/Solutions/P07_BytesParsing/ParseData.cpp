#include <iostream>
#include <string>
#include <vector>
#include "Defines.h"

enum CommandType : unsigned char
{
    SHORT     = 0,
    INTEGER   = 1,
    LONG_LONG = 2,

    UNKNOWN   = 255
};

CommandType getCommandType(const char commandChar)
{
    CommandType commandType = CommandType::UNKNOWN;

    switch(commandChar)
    {
        case 's':
            commandType = CommandType::SHORT;
            break;

        case 'i':
            commandType = CommandType::INTEGER;
            break;

        case 'l':
            commandType = CommandType::LONG_LONG;
            break;

        default:
            std::cerr << "Warning, unknown commandChar received: "
                      << commandChar << std::endl;
            break;
    }

    return commandType;
}

size_t getSingleCommandSize(const CommandType commandType)
{
    size_t size = 0;

    switch(commandType)
    {
        case CommandType::SHORT:
            size = sizeof(short);
            break;

        case CommandType::INTEGER:
            size = sizeof(int);
            break;

        case CommandType::LONG_LONG:
            size = sizeof(long long);
            break;

        default:
            std::cerr << "Warning, received CommandType::UNKNOWN. Returning 0."
                      << std::endl;
            break;
    }

    return size;
}

long long parseSingleNumber(CommandType commandType,
                            char *      buffer)
{
    long long parsedNumber = 0;

    switch(commandType)
    {
        case CommandType::SHORT:
            parsedNumber = *(reinterpret_cast<short *>(buffer));
            break;

        case CommandType::INTEGER:
            parsedNumber = *(reinterpret_cast<int *>(buffer));
            break;

        case CommandType::LONG_LONG:
            parsedNumber = *(reinterpret_cast<long long *>(buffer));
            break;

        default:
            std::cerr << "Warning, received CommandType::UNKNOWN. Returning 0."
                      << std::endl;
            break;
    }

    return parsedNumber;
}

ErrorCode parseData(const std::string &      commands,
                    const char *             rawDataBytes,
                    const size_t	         rawDataBytesCount,
                    std::vector<long long> & outParsedNumbers)
{
    size_t parsedSize = 0;
    char * rawDataPtr = const_cast<char *>(rawDataBytes);

    if((commands.empty())       ||
       (rawDataBytesCount == 0) ||
       (rawDataBytes == nullptr))
    {
        return ErrorCode::PARSE_EMPTY;
    }

    for(size_t i = 0; i < commands.size(); ++i)
    {
        const CommandType commandType = getCommandType(commands[i]);
        const size_t currCommandSize = getSingleCommandSize(commandType);

        if(parsedSize + currCommandSize > rawDataBytesCount)
        {
            return ErrorCode::PARSE_FAILURE;
        }

        //parse the data
        outParsedNumbers.push_back(parseSingleNumber(commandType,
                                                     rawDataPtr));

        //and increase the parsed bytes counter
        parsedSize += currCommandSize;

        //move the pointer forward
        rawDataPtr += currCommandSize;
    }

    return ErrorCode::PARSE_SUCCESS;
}

void printResult(const ErrorCode                errorCode,
                 const std::vector<long long> & parsedNumbers)
{
    for(size_t i = 0; i < parsedNumbers.size(); ++i)
    {
        std::cout << parsedNumbers[i] << ' ';
    }

    switch(errorCode)
    {
        case ErrorCode::PARSE_EMPTY:
            std::cout << "No input provided";
            break;

        case ErrorCode::PARSE_FAILURE:
            std::cout << "Warning, buffer underflow detected";
            break;

        case ErrorCode::PARSE_SUCCESS:
            //do nothing
            break;

        default:
            std::cerr << "Warning, received unknown ErrorCode: "
                      << errorCode << std::endl;
            break;
    }

    std::cout << std::endl;
}



