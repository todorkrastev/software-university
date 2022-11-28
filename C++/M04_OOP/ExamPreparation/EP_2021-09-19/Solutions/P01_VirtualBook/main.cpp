#include "InputParser.h"
#include "VirtualBook.h"

#include <iostream>

static std::string PRINT_ALL_PAGES = "print_all";
static std::string REMOVE_LAST_PAGE = "remove_last";
static std::string REMOVE_ALL_PAGE = "remove_all";

static void populatePageData(VirtualBook &book,
                             const std::vector<PageData> &pagesData) {
  for (size_t i = 0; i < pagesData.size(); ++i) {
    VirtualPage page(i + 1);
    for (const auto& content : pagesData[i]) {
      page.addContent(content);
    }
    book.addPage(page);
  }
}

static void processCommands(VirtualBook &book,
                            const std::vector<std::string> &commands) {
  for (const auto& command : commands) {
    if (PRINT_ALL_PAGES == command) {
      std::cout << "Printing all pages" << std::endl;
      book.printContent();
    } else if (REMOVE_LAST_PAGE == command) {
      std::cout << "Removing last page" << std::endl;
      book.removeLastPage();
    } else if (REMOVE_ALL_PAGE == command) {
      std::cout << "Removing all pages" << std::endl;
      book.removeAllPages();
    } else {
      std::cerr << "Invalid input" << std::endl;
    }
  }
}

int main() {
  const Input input = readInput();
  VirtualBook book;
  populatePageData(book, input.pagesData);
  processCommands(book, input.commands);

  return EXIT_SUCCESS;
}

