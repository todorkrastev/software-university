#include "Logger.h"
#include "Application.h"

int main() {
  //usage
  Logger::getInstance().print("Hello from main");

  Application app;
  app.someAwesomeMethod();

  Logger::getInstance().print("Bye from main");

  return 0;
}
