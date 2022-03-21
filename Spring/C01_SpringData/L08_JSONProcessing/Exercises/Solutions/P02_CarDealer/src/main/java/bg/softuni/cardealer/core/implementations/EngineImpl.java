package bg.softuni.cardealer.core.implementations;

import bg.softuni.cardealer.core.Engine;
import bg.softuni.cardealer.services.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

@Service
public class EngineImpl implements Engine {
    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SaleService saleService;
    private final SupplierService supplierService;

    private final BufferedReader reader;
    private final Gson gson;

    private static int input;

    public EngineImpl(CarService carService, CustomerService customerService, PartService partService, SaleService saleService, SupplierService supplierService, BufferedReader reader, Gson gson) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
        this.reader = reader;
        this.gson = gson;
    }

    @Override
    public void run() throws IOException {
        seedData();

        printWelcomeMessage();

        do {
            do {
                validateInput("Please, select query number [1-6]");
            } while (input < 1 || input > 6);

            switch (input) {

            }

            input = 0;

        } while (!isProgramRunning());

        printGoodbyeMessage();
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files.write(Path.of(filePath), Collections.singleton(content));
    }


    private void seedData() throws IOException {
        this.supplierService.seedSuppliers();
        this.partService.seedParts();
        this.carService.seedCars();
    }

    private void printGoodbyeMessage() {
        System.out.println("Thank you for spending your time exploring my code!");
        printSeparatorLine();
    }

    private boolean isProgramRunning() throws IOException {
        printSeparatorLine();

        String answer;
        do {
            System.out.println("Would you like to continue exploring more queries?: [Y/N]");
            answer = this.reader.readLine().trim().toLowerCase();

            printSeparatorLine();
        } while (!answer.equals("n") && !answer.equals("y"));
        return !answer.equals("y");
    }

    private void validateInput(String message) {
        try {
            System.out.println(message);
            input = Integer.parseInt(this.reader.readLine());
            printSeparatorLine();
        } catch (Exception e) {
            printSeparatorLine();
            System.out.println("Invalid input!");
            printSeparatorLine();
        }
    }

    private void printSelectedQueryMessage(String query) {
        System.out.printf("You selected query: %s%n", query);
    }

    private void printSeparatorLine() {
        System.out.println("*".repeat(150));
    }

    private void printWelcomeMessage() {
        printSeparatorLine();
        System.out.println("Hello There! Welcome to my code!");
        printSeparatorLine();
    }
}
