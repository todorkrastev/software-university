#ifndef CPP_ADVANCED_SOLFEGENOTENAMING_H
#define CPP_ADVANCED_SOLFEGENOTENAMING_H

#include <string>
#include "NoteName.h"

struct SolfegeNoteNaming {
  NoteName operator()(const std::string& noteText) const {
    if (noteText == "Do") {
      return { 'C' };
    } else if (noteText == "Re") {
      return { 'D' };
    } else if (noteText == "Mi") {
      return { 'E' };
    } else if (noteText == "Fa") {
      return { 'F' };
    } else if (noteText == "Sol") {
      return { 'G' };
    } else if (noteText == "La") {
      return { 'A' };
    } else if (noteText == "Si") {
      return { 'B' };
    } else {
      return { '?' };
    }
  }
};

#endif //CPP_ADVANCED_SOLFEGENOTENAMING_H
