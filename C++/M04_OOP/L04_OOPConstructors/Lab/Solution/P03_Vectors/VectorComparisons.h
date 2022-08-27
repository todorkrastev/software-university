#ifndef CPP_ADVANCED_VECTORCOMPARISONS_H
#define CPP_ADVANCED_VECTORCOMPARISONS_H

#include "Vector.h"

struct VectorLengthComparer {
  const bool operator()(const Vector& a, const Vector& b) const {
    return a.getLength() < b.getLength();
  }
};

template<typename T, typename Comparator>
class ReverseComparer {
  Comparator comp;
public:
  const bool operator()(const T& a, const T& b) const {
    return !this->comp(a, b);
  }
};

#endif //CPP_ADVANCED_VECTORCOMPARISONS_H
