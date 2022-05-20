#include <iostream>
#include <string>
#include <deque>
#include <cmath>

const size_t MAX_CONSOLE_SIZE = 5;
const size_t SLIDER_SIZE = 3;

const int ENTER_DATA = 1;
const int MOVE_SLIDER_UP = 2;
const int MOVE_SLIDER_DOWN = 3;
const int PRINT_CONTENT = 4;
const int EXIT = 5;
const int MAX_MENU_OPTIONS = 5;

void printMenu() {
  std::cout << "\nChoose option:\n";
  std::cout << "1) enter new data\n";
  std::cout << "2) move slider up\n";
  std::cout << "3) move slider down\n";
  std::cout << "4) print content\n";
  std::cout << "5) exit\n\n";
}

bool isValdOption(int chosenOption) {
  if (0 > chosenOption) {
    return false;
  }

  if (5 < chosenOption) {
    return false;
  }

  return true;
}

std::string readData() {
  std::string input;
  getline(std::cin, input);
  return input;
}

void enterData(std::deque<std::string> &console, int &consoleSliderFromIdx,
               int &consoleSliderToIdx) {
  const std::string newData = readData();
  console.push_back(newData);
  if (MAX_CONSOLE_SIZE < console.size()) {
    console.pop_front();
  }

  const int maxSliderToIdx = (int)(MAX_CONSOLE_SIZE - 1);
  consoleSliderToIdx = consoleSliderFromIdx + SLIDER_SIZE - 1;
  consoleSliderToIdx = std::min(consoleSliderToIdx, maxSliderToIdx);
}

void moveSliderUp(int &consoleSliderFromIdx, int &consoleSliderToIdx) {
  if (0 == consoleSliderFromIdx) {
    return;
  }

  --consoleSliderFromIdx;
  --consoleSliderToIdx;
}

void moveSliderDown(int &consoleSliderFromIdx, int &consoleSliderToIdx) {
  const int maxSliderToIdx = (int)(MAX_CONSOLE_SIZE - 1);
  if (maxSliderToIdx == consoleSliderToIdx) {
    return;
  }

  ++consoleSliderFromIdx;
  ++consoleSliderToIdx;
}

void printContent(const std::deque<std::string> &console, int fromIdx,
                  int toIdx) {
  if (console.empty()) {
    return;
  }

  for (int i = fromIdx; i <= toIdx && i < (int)console.size(); ++i) {
    std::cout << "row" << i << ": " << console[i] << '\n';
  }
}

void handleChosenOption(std::deque<std::string> &console, int chosenOption,
                        int &consoleSliderFromIdx, int &consoleSliderToIdx,
                        bool &exitFlag) {
  switch (chosenOption) {
  case ENTER_DATA:
    enterData(console, consoleSliderFromIdx, consoleSliderToIdx);
    break;
  case MOVE_SLIDER_UP:
    moveSliderUp(consoleSliderFromIdx, consoleSliderToIdx);
    break;
  case MOVE_SLIDER_DOWN:
    moveSliderDown(consoleSliderFromIdx, consoleSliderToIdx);
    break;
  case PRINT_CONTENT:
    printContent(console, consoleSliderFromIdx, consoleSliderToIdx);
    break;
  case EXIT:
    exitFlag = true;
    break;
  default:
    std::cerr << "Received invalid option: " << chosenOption << std::endl;
    break;
  }
}

void playGame(std::deque<std::string> &console, int &consoleSliderFromIdx,
              int &consoleSliderToIdx) {
  bool exitFlag = false;
  int chosenOption = -1;
  while (!exitFlag) {
    printMenu();
    std::cin >> chosenOption;
    std::cin.ignore();
    if (!isValdOption(chosenOption)) {
      std::cout << "Chosen a valid option between 1 and " << MAX_MENU_OPTIONS
                << std::endl;
      continue;
    }

    handleChosenOption(console, chosenOption, consoleSliderFromIdx,
        consoleSliderToIdx, exitFlag);
  }
}

int main() {
  std::deque<std::string> console;
  int consoleSliderFromIdx = 0;
  int consoleSliderToIdx = 0;
  playGame(console, consoleSliderFromIdx, consoleSliderToIdx);

  return 0;
}
