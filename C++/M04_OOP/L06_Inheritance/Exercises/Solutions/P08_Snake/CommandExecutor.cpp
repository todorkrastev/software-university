#include "CommandExecutor.h"
#include "Defines.h"

#include <sstream>
#include <iostream>

static const char * DIR_STRINGS[DIRECTIONS_COUNT] {
    "UP",
    "RIGHT",
    "DOWN",
    "LEFT"
};

CommandExecutor::CommandExecutor(const FieldConfig & cfg) : _field(cfg),
                                                            _isGameActive(true) {

}

void CommandExecutor::extractCommand(const std::string & commandStr) {
	std::istringstream istr(commandStr);
	int currCommand = 0;
	istr >> currCommand;

	switch(currCommand) {
		case InputCommands::MOVE_SNAKE: {
			int moveDirectionId = 0;
			istr >> moveDirectionId;

			executeMoveSnake(moveDirectionId);
		}
			break;

		case InputCommands::GENERATE_OBSTACLE: {
            Point obstaclePos;
            istr >> obstaclePos.row >> obstaclePos.col;

            executeGenerateObstacle(obstaclePos);
        }
			break;

		case InputCommands::GENERATE_POWER_UP: {
            Point powerUpPos;
            istr >> powerUpPos.row >> powerUpPos.col;

            executeGeneratePowerUp(powerUpPos);
        }
			break;

		default:
		    std::cerr << "Warning, received unknown InputCommand: "
		              << currCommand << std::endl;
		    break;
	}
}

bool CommandExecutor::isGameActive() const {
    return _isGameActive;
}

void CommandExecutor::executeMoveSnake(const int moveDirectionId) {
    std::cout << "MOVE_SNAKE in dir: "
              << DIR_STRINGS[moveDirectionId] << ", status: ";

    const StatusCode STATUS_CODE =
                    _field.moveSnake(static_cast<Direction>(moveDirectionId));

    switch(STATUS_CODE) {
        case StatusCode::SNAKE_MOVING:
            std::cout << "SNAKE_MOVING\n";
            break;

        case StatusCode::SNAKE_GROWING:
            std::cout << "SNAKE_GROWING\n";
            break;

        case StatusCode::SNAKE_DEAD:
            std::cout << "SNAKE_DEAD\n";
            _isGameActive = false;
            break;

        default:
            std::cout << "ERROR\n";
            break;
    }

    if(StatusCode::SNAKE_DEAD != STATUS_CODE) {
        _field.printField();
    }
}

void CommandExecutor::executeGenerateObstacle(const Point & pos) {
    std::cout << "GENERATE_OBSTACLE at row: " << pos.row
              << ", col: " << pos.col << '\n';

    _field.generateObstacle(pos);
    _field.printField();
}

void CommandExecutor::executeGeneratePowerUp(const Point & pos) {
    std::cout << "GENERATE_POWER_UP at row: " << pos.row
              << ", col: " << pos.col << '\n';

    _field.generatePowerUp(pos);
    _field.printField();
}



