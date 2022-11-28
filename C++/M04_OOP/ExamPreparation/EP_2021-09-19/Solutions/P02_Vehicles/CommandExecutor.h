#ifndef COMMANDEXECUTOR_H_
#define COMMANDEXECUTOR_H_

#include <string>
#include <vector>

#include "Defines.h"

#include "RaceTrack.h"

class CommandExecutor {
public:
  void extractCommand(const std::string &commandStr);

  bool isRaceRunning() const;

  void printWinner();

private:
  void createManualCar(const std::vector<int> &shifts, int maxSpeed,
                       int startFuel);

  void createAutomaticCar(int maxSpeed, int startFuel);

  void increaseSpeed(int speedIncrease, int fuelConsumtion);

  void decreaseSpeed(int speedDecrease);

  void advance();

  RaceTrack _raceTrack;
  int _turnCounter { 1 };
};

#endif /* COMMANDEXECUTOR_H_ */
