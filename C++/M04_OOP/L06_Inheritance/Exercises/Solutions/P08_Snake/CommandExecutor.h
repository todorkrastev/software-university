#ifndef COMMANDEXECUTOR_H_
#define COMMANDEXECUTOR_H_

#include <string>

#include "Field.h"

class CommandExecutor {
	public:
		CommandExecutor(const FieldConfig & cfg);
		~CommandExecutor() = default;

		void extractCommand(const std::string & commandStr);

		bool isGameActive() const;

	private:
        void executeMoveSnake(const int moveDirectionId);

		void executeGenerateObstacle(const Point & pos);

        void executeGeneratePowerUp(const Point & pos);

		Field _field;

		bool  _isGameActive;
};

#endif /* COMMANDEXECUTOR_H_ */
