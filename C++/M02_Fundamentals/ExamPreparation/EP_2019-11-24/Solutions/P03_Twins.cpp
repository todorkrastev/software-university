#include <iostream>
#include <unordered_map>
#include <queue>

int main() {
    int clients;
    std::cin >> clients;

    std::unordered_map<std::string, std::queue<std::string>> cashiers{ };
    cashiers["Pepi"] = { };
    cashiers["Mimi"] = { };

    while (clients-- > 0) {
        std::string cashierName, clientName;
        int minutes;
        std::cin >> cashierName >> clientName >> minutes;
        for (int i = 0; i < minutes; ++i) {
            cashiers[cashierName].emplace(clientName);
        }
    }

    int workTime;
    std::cin >> workTime;

    while (workTime-- > 0) {
        if (!cashiers["Pepi"].empty()) {
            std::cout << "Pepi" << " processing " << cashiers["Pepi"].front() << std::endl;
            cashiers["Pepi"].pop();
        }
        else {
            std::cout << "Pepi Idle" << std::endl;
        }

        if (!cashiers["Mimi"].empty()) {
            std::cout << "Mimi" << " processing " << cashiers["Mimi"].front() << std::endl;
            cashiers["Mimi"].pop();
        }
        else {
            std::cout << "Mimi Idle" << std::endl;
        }
    }

    return 0;
}