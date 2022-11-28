#ifndef CPP_ADVANCED_FIELD_H
#define CPP_ADVANCED_FIELD_H


#include "Defines.h"

class Field {

public:
  FieldData getFieldData() const;

  void populateField(FieldData const& fieldData);

private:
  FieldData _fieldData;
};

#endif //CPP_ADVANCED_FIELD_H
