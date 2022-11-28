#include "BomberMan.h"

void BomberMan::bombPowerUp() {
  ++_bombPower;
}

int BomberMan::getBombPower() const {
  return _bombPower;
}

void BomberMan::bombPowerDown() {
  --_bombPower;
  if (_bombPower < 0) {
    _bombPower = 0;
  }
}

int BomberMan::placeBomb(FieldData const& fieldData, const int bombRow, const int bombCol) {
  if (_damagedFields.size() != fieldData.size()) {
    for (const auto& row: fieldData) {
      _damagedFields.emplace_back(row.size());
    }
  }

  int damage = 0;

  int startRow = bombRow - _bombPower;
  if (startRow < 0) { startRow = 0; }
  size_t endRow = bombRow + _bombPower;
  if (endRow > fieldData.size() - 1) { endRow = fieldData.size() - 1; }
  for (size_t row = startRow; row <= endRow; ++row) {
    if (!_damagedFields[row][bombCol]) {
      damage += fieldData[row][bombCol] - '0';
      _damagedFields[row][bombCol] = true;
    }
  }

  int startCol = bombCol - _bombPower;
  if (startCol < 0) { startCol = 0; }
  size_t endCol = bombCol + _bombPower;
  if (endCol > fieldData[bombRow].size() - 1) { endCol = fieldData[bombRow].size() - 1; }
  for (size_t col = startCol; col <= endCol; ++col) {
    if (!_damagedFields[bombRow][col]) {
      damage += fieldData[bombRow][col] - '0';
      _damagedFields[bombRow][col] = true;
    }
  }

  return damage;
}
