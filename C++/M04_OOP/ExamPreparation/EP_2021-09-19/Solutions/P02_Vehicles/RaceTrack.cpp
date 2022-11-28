#include "RaceTrack.h"
#include "ManualCar.h"
#include "AutomaticCar.h"

#include <algorithm>
#include <iostream>
#include <memory>

bool RaceTrack::isRaceRunning() const {
  size_t carsOutOfFuel = 0;
  std::for_each(_cars.cbegin(), _cars.cend(),
                [&carsOutOfFuel](const std::unique_ptr<Car>& car) { if (!car->hasFuel()) { ++carsOutOfFuel; }});
  return carsOutOfFuel == 0 || _cars.size() - carsOutOfFuel >= 2;
}

void RaceTrack::printInfo() const {
  for (size_t i = 0; i < _cars.size(); ++i) {
    const auto& car = _cars.at(i);
    std::cout << "Car with index: " << i << " has totalDistance: " << car->getTotalDistance()
              << ", is running with " << car->getSpeed() << " speed, has "
              << car->getFuel() << " fuel left" << std::endl;
  }
}

void RaceTrack::printWinner() {
  const bool bothCarsFinished = _cars[0]->hasFuel() && _cars[1]->hasFuel();
  const bool sameDistance = _cars[0]->getTotalDistance() == _cars[1]->getTotalDistance();

  if (bothCarsFinished && sameDistance) {
    std::cout << "No winner" << std::endl;
    return;
  }

  size_t winnerIndex = 0;
  if (bothCarsFinished && (_cars[1]->getTotalDistance() > _cars[0]->getTotalDistance())) {
    winnerIndex = 1;
  }

  if (!bothCarsFinished && _cars[1]->hasFuel()) {
    winnerIndex = 1;
  }

  std::cout << "Car with index: " << winnerIndex << " won!" << std::endl;
}

void RaceTrack::advance() {
  std::for_each(_cars.begin(), _cars.end(), [](std::unique_ptr<Car>& car) { car->advance(); });
}

void RaceTrack::createManualCar(std::vector<int> const& shifts, int maxSpeed, int startFuel) {
  _cars.emplace_back(std::unique_ptr<Car>(new ManualCar(shifts, maxSpeed, startFuel)));
}

void RaceTrack::createAutomaticCar(int maxSpeed, int startFuel) {
  _cars.emplace_back(std::unique_ptr<Car>(new AutomaticCar(maxSpeed, startFuel)));
}

void RaceTrack::increaseSpeed(int speedIncrease, int fuelConsumtion) {
  std::for_each(_cars.begin(), _cars.end(),
                [speedIncrease, fuelConsumtion](std::unique_ptr<Car>& car) {
                  car->increaseSpeed(speedIncrease, fuelConsumtion);
                });
}

void RaceTrack::decreaseSpeed(int speedDecrease) {
  std::for_each(_cars.begin(), _cars.end(),
                [speedDecrease](std::unique_ptr<Car>& car) { car->decreaseSpeed(speedDecrease); });
}
