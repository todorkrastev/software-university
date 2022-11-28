#include "Field.h"

void Field::populateField(FieldData const& fieldData) {
  this->_fieldData = fieldData;
}

FieldData Field::getFieldData() const {
  return _fieldData;
}
