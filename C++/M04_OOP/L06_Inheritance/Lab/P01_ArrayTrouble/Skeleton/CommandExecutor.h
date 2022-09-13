#ifndef COMMANDEXECUTOR_H_
#define COMMANDEXECUTOR_H_

#include <string>
#include <vector>

#include "FixedArray.h"

class CommandExecutor
{
	public:
		CommandExecutor(const int maxCommands);
		virtual ~CommandExecutor() = default;

		void extractCommand(const std::string & commandStr);

	private:
		void executeCreateArray(const int arraySize);

		void executeCopyConstructArray(const int fromArrayIdx);

		void executeCopyAssignArray(const int fromIdx, const int toIdx);

		void executeSumArrayData(const int arrayIdx);

        void executeIncrArrayDataValue(const int incrValue,
                                       const int arrayIdx);

		std::vector<FixedArray> _activeArrays;
};

#endif /* COMMANDEXECUTOR_H_ */
