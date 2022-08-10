#include "Application.h"
#include "Logger.h"

void Application::someAwesomeMethod() {
  Logger::getInstance().print("Is this really workring?!?", LogTarget::FILE);
}
