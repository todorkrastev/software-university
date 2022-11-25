#include "InputParser.h"
#include "StringWrapper.h"

int main() {
  const Input input = readInput();
  const StringWrapper first(input.line);
  const StringWrapper second(input.letter, input.repetitions);

  StringWrapper third;
  third.append(first.getContent()).append(second.getContent());
  third.printContent();

  return 0;
}

