#ifndef RACETRACK_H_
#define RACETRACK_H_

#include <memory>
#include <vector>

#include "Car.h"

class RaceTrack {
public:
  bool isRaceRunning() const;

  void printWinner();

  void createManualCar(const std::vector<int> &shifts, int maxSpeed,
                       int startFuel);

  void createAutomaticCar(int maxSpeed, int startFuel);

  void increaseSpeed(int speedIncrease, int fuelConsumtion);

  void decreaseSpeed(int speedDecrease);

  void advance();

  void printInfo() const;

private:
  std::vector<std::unique_ptr<Car>> _cars;
};

#endif /* RACETRACK_H_ */
