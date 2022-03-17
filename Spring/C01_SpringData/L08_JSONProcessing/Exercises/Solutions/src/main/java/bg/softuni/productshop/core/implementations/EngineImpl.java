package bg.softuni.productshop.core.implementations;

import bg.softuni.productshop.core.Engine;
import bg.softuni.productshop.models.dtos.ProductNameAndPriceDto;
import bg.softuni.productshop.models.dtos.UserSoldDto;
import bg.softuni.productshop.services.CategoryService;
import bg.softuni.productshop.services.ProductService;
import bg.softuni.productshop.services.UserService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Service
public class EngineImpl implements Engine {

    private static final String OUTPUT_PATH = "src/main/resources/files/out/";
    public static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.json";
    public static final String SUCCESSFULLY_SOLD_PRODUCTS_FILE_NAME = "successfully-sold-products.json";

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader reader;
    private final Gson gson;
    private static int input;

    public EngineImpl(CategoryService categoryService, UserService userService, ProductService productService, BufferedReader reader, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.reader = reader;
        this.gson = gson;
    }

    @Override
    public void run() throws IOException {
        seedData();

        printWelcomeMessage();

        do {
            do {
                validateInput("Please, select query number [1-4]");
            } while (input < 1 || input > 4);

            switch (input) {
                case 1 -> q01_ProductsInRange();
                case 2 -> q02_SuccessfullySoldProducts();

                //TODO: -25:10
            }

            input = 0;

        } while (!isProgramRunning());

        printGoodbyeMessage();
    }

    private void q02_SuccessfullySoldProducts() throws IOException {
        printSelectedQueryMessage("""
                Query 2 - Successfully Sold Products
                Description -> Get all users who have at least 1 item sold with a buyer.
                Order them by last name, then by first name. Select the person's first and last name.
                For each of the products sold (products with buyers), select the product's name, price and the buyer's first and last name.""");

        List<UserSoldDto> userSoldDtoList = this.userService
                .findAllUsersWithMoreThanOneSoldProduct();

        String content = gson.toJson(userSoldDtoList);

        writeToFile(OUTPUT_PATH + SUCCESSFULLY_SOLD_PRODUCTS_FILE_NAME, content);
    }

    private void q01_ProductsInRange() throws IOException {
        printSelectedQueryMessage("""
                Query 1 - Products in Range
                Description -> Get all products in a specified price range (e.g. 500 to 1000), which have no buyer.
                Order them by price (from lowest to highest). Select only the product name, price and the full name of the seller.
                Export the result to JSON.""");

        System.out.println("Please, enter lowest price -> 500");
        long lowestPrice = Long.parseLong(reader.readLine());

        System.out.println("Please, enter highest price -> 1000");
        long highestPrice = Long.parseLong(reader.readLine());

        List<ProductNameAndPriceDto> productNameAndPriceDtoList = this.productService
                .findAllProductsInRangeOrderByPrice(BigDecimal.valueOf(lowestPrice), BigDecimal.valueOf(highestPrice));

        String content = gson.toJson(productNameAndPriceDtoList);

        writeToFile(OUTPUT_PATH + PRODUCTS_IN_RANGE_FILE_NAME, content);
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files.write(Path.of(filePath), Collections.singleton(content));
    }


    private void seedData() throws IOException {
        this.categoryService.seedCategories();
        this.userService.seedUsers();
        this.productService.seedProducts();
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

    private void printSelectedQueryMessage(String exercise) {
        System.out.printf("You selected query: %s%n", exercise);
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
