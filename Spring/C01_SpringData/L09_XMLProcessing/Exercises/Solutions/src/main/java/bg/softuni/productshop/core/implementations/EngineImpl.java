package bg.softuni.productshop.core.implementations;

import bg.softuni.productshop.constants.GlobalConstant;
import bg.softuni.productshop.core.Engine;
import bg.softuni.productshop.models.dtos.*;
import bg.softuni.productshop.services.CategoryService;
import bg.softuni.productshop.services.ProductService;
import bg.softuni.productshop.services.UserService;
import bg.softuni.productshop.utils.XmlParser;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

@Service
public class EngineImpl implements Engine {

    private final BufferedReader reader;
    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private static int input;

    public EngineImpl(BufferedReader reader, XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.reader = reader;
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run() throws IOException, JAXBException {

        seedData();

        printWelcomeMessage();

        do {
            do {
                validateInput();
            } while (input < 1 || input > 4);

            switch (input) {
                case 1 -> q01_ProductsInRange();
                case 2 -> q02_SuccessfullySoldProducts();
                case 3 -> q03_CategoriesByProductsCount();
                case 4 -> q04_UsersAndProducts();
            }

            input = 0;

        } while (!isProgramRunning());

        printGoodbyeMessage();
    }

    private void q04_UsersAndProducts() throws JAXBException {
        printSelectedQueryMessage("""
                Query 4 - Users and Products
                Description -> Get all users, who have at least 1 product sold.
                Order them by the number of products sold (from highest to lowest), then by last name (ascending).
                Select only their first and last name, age and for each product - name and price.""");


        UserViewRootWithOneSoldProduct userViewRootWithOneSoldProductList =
                this.userService.getAllUsersWithMoreThanOneSoldProductOrderByNumberOfSoldProductsDescThenByLastNameAsc();

        System.out.println();

        this.xmlParser.writeToFile(
                GlobalConstant.OUTPUT_FILE_PATH + GlobalConstant.USERS_AND_PRODUCTS_FILE_NAME,
                userViewRootWithOneSoldProductList
        );
    }

    private void q03_CategoriesByProductsCount() throws JAXBException {
        printSelectedQueryMessage("""
                Query 3 - Categories by Products Count
                Description -> Get all categories.
                Order them by the number of products in each category (a product can be in many categories).
                For each category select its name, the number of products, the average price of those products and the total revenue (total price sum) of those products (regardless if they have a buyer or not).""");


        CategoryViewRootDto categoryViewRootDto = this.categoryService.getAllCategoriesOrderByNumberOfProducts();

        this.xmlParser.writeToFile(
                GlobalConstant.OUTPUT_FILE_PATH + GlobalConstant.CATEGORIES_BY_PRODUCTS_COUNT_FILE_NAME,
                categoryViewRootDto
        );
    }

    private void q02_SuccessfullySoldProducts() throws JAXBException {
        printSelectedQueryMessage("""
                Query 2 - Successfully Sold Products
                Description -> Get all users who have at least 1 item sold with a buyer.
                Order them by last name, then by first name. Select the person's first and last name.
                For each of the products sold (products with buyers), select the product's name, price and the buyer's first and last name.""");


        UserViewRootDto userViewRootDto = this.userService
                .findAllUsersWithMoreThanOneSoldProduct();

        this.xmlParser.writeToFile(
                GlobalConstant.OUTPUT_FILE_PATH + GlobalConstant.SUCCESSFULLY_SOLD_PRODUCTS_FILE_NAME,
                userViewRootDto);
    }

    private void q01_ProductsInRange() throws IOException, JAXBException {
        printSelectedQueryMessage("""
                Query 1 - Products in Range
                Description -> Get all products in a specified price range (e.g. 500 to 1000), which have no buyer.
                Order them by price (from lowest to highest). Select only the product name, price and the full name of the seller.
                Export the result to JSON.""");

        System.out.println("Please, enter lowest price -> 500");
        long lowestPrice = Long.parseLong(reader.readLine());

        System.out.println("Please, enter highest price -> 1000");
        long highestPrice = Long.parseLong(reader.readLine());

        ProductViewRootDto productViewRootDto = this.productService
                .findAllProductsInRangeOrderByPrice(BigDecimal.valueOf(lowestPrice), BigDecimal.valueOf(highestPrice));

        this.xmlParser.writeToFile(
                GlobalConstant.OUTPUT_FILE_PATH + GlobalConstant.PRODUCTS_IN_RANGE_FILE_NAME,
                productViewRootDto);
    }

    private void seedProducts() throws JAXBException, FileNotFoundException {
        if (this.productService.getEntityCount() == 0) {
            ProductSeedRootDto productSeedRootDto = this.xmlParser
                    .fromFile(
                            GlobalConstant.RESOURCES_FILE_PATH + GlobalConstant.PRODUCTS_FILE_NAME,
                            ProductSeedRootDto.class);

            this.productService.seedProducts(productSeedRootDto.getProducts());
        }
    }

    private void seedUsers() throws JAXBException, FileNotFoundException {
        if (this.userService.getEntityCount() == 0) {
            UserSeedRootDto userSeedRootDto = this.xmlParser
                    .fromFile(
                            GlobalConstant.RESOURCES_FILE_PATH + GlobalConstant.USERS_FILE_NAME,
                            UserSeedRootDto.class);

            this.userService.seedUsers(userSeedRootDto.getUsers());
        }
    }

    private void seedCategories() throws JAXBException, FileNotFoundException {
        if (this.categoryService.getEntityCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = this.xmlParser
                    .fromFile(
                            GlobalConstant.RESOURCES_FILE_PATH + GlobalConstant.CATEGORIES_FILE_NAME,
                            CategorySeedRootDto.class);

            this.categoryService.seedCategories(categorySeedRootDto.getCategories());
        }
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        seedCategories();
        seedUsers();
        seedProducts();
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

    private void printSelectedQueryMessage(String exercise) {
        System.out.printf("You selected query: %s%n", exercise);
    }

    private void validateInput() {
        try {
            System.out.println("Please, select query number [1-4]");
            input = Integer.parseInt(this.reader.readLine());
            printSeparatorLine();
        } catch (Exception e) {
            printSeparatorLine();
            System.out.println("Invalid input!");
            printSeparatorLine();
        }
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
