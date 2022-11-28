#include "CommandExecutor.h"

#include <sstream>
#include <iostream>

void CommandExecutor::extractCommand(const std::string &commandStr) {
  std::istringstream istr(commandStr);
  int currCommandInt = 0;
  istr >> currCommandInt;
  const CommandType command = static_cast<CommandType>(currCommandInt);

  switch (command) {
  case CommandType::CREATE_CAR: {
    int carTypeInt = 0;
    int maxSpeed = 0;
    int startFuel = 0;
    istr >> carTypeInt >> maxSpeed >> startFuel;
    const CarType carType = static_cast<CarType>(carTypeInt);

    if (CarType::AUTOMATIC == carType) {
      createAutomaticCar(maxSpeed, startFuel);
    } else {
      std::vector<int> shifts;
      int shiftSpeed = 0;
      while (istr >> shiftSpeed) {
        shifts.push_back(shiftSpeed);
      }
      createManualCar(shifts, maxSpeed, startFuel);
    }
  }
    break;

  case CommandType::INCREASE_SPEED: {
    int speedIncrease = 0;
    int fuelConsumtion = 0;
    istr >> speedIncrease >> fuelConsumtion;
    increaseSpeed(speedIncrease, fuelConsumtion);
  }
    break;

  case CommandType::DECREASE_SPEED: {
    int speedDecrease = 0;
    istr >> speedDecrease;
    decreaseSpeed(speedDecrease);
  }
  break;

  case CommandType::ADVANCE:
    advance();
    break;

  default:
    std::cerr << "Warning, received unknown CommandType: " << currCommandInt
              << std::endl;
    break;
  }
}

bool CommandExecutor::isRaceRunning() const {
  return _raceTrack.isRaceRunning();
}

void CommandExecutor::printWinner() {
  _raceTrack.printWinner();
}

void CommandExecutor::createManualCar(const std::vector<int> &shifts,
                                      int maxSpeed, int startFuel) {
  _raceTrack.createManualCar(shifts, maxSpeed, startFuel);
}

void CommandExecutor::createAutomaticCar(int maxSpeed, int startFuel) {
  _raceTrack.createAutomaticCar(maxSpeed, startFuel);
}

void CommandExecutor::increaseSpeed(int speedIncrease,
                                           int fuelConsumtion) {
  _raceTrack.increaseSpeed(speedIncrease, fuelConsumtion);
  std::cout << "Starting turn: " << _turnCounter++ << std::endl;
  _raceTrack.printInfo();
  std::cout << std::endl;
}

void CommandExecutor::decreaseSpeed(int speedDecrease) {
  _raceTrack.decreaseSpeed(speedDecrease);
  std::cout << "Starting turn: " << _turnCounter++ << std::endl;
  _raceTrack.printInfo();
  std::cout << std::endl;
}

void CommandExecutor::advance() {
  _raceTrack.advance();
  std::cout << "Starting turn: " << _turnCounter++ << std::endl;
  _raceTrack.printInfo();
  std::cout << std::endl;
}

