package com.manhattan;

import com.manhattan.models.productsShop.dtos.ProductInRangeList;
import com.manhattan.models.productsShop.dtos.ProductInRangeXmlDto;
import com.manhattan.services.carDealer.interfaces.*;
import com.manhattan.services.common.FileService;
import com.manhattan.services.productShop.interfaces.CategoryService;
import com.manhattan.services.productShop.interfaces.ProductService;
import com.manhattan.services.productShop.interfaces.SeedProductShopService;
import com.manhattan.services.productShop.interfaces.UserService;
import com.manhattan.utils.ConsoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.stream.Collectors;

import static com.manhattan.utils.CommonConstants.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedProductShopService seedProductShopService;
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    private final SeedCarDealerService seedCarDealerService;
    private final SupplierService supplierService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SaleService saleService;

    private final FileService fileService;
    private final ConsoleService console;

    public ConsoleRunner(UserService userService,
                         ProductService productService,
                         CategoryService categoryService,
                         SeedProductShopService seedService,
                         SeedCarDealerService seedCarDealerService,
                         SaleService saleService, FileService fileService,
                         SupplierService supplierService, CustomerService customerService, CarService carService, ConsoleService console) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.seedProductShopService = seedService;
        this.seedCarDealerService = seedCarDealerService;
        this.saleService = saleService;
        this.fileService = fileService;
        this.supplierService = supplierService;
        this.customerService = customerService;
        this.carService = carService;
        this.console = console;
    }

    @Override
    public void run(String... args) throws Exception {
        // 2.	Seed the Database
        console.printInfoMessage("Seeding ProductShop...");
        seedProductShopData();
        // 3.	Query and Export Data
        // Query 1 – Products in Range
        console.printInfoMessage(String.format("Generating {%s} ...", PRODUCTS_IN_RANGE_XML_FILE));
        saveAllProductsInRangeXml();
        printAllProductsInRangeXml();
        // 3.	Query and Export Data
        // Query 1 – Products in Range
        console.printInfoMessage(String.format("Generating {%s} ...", PRODUCTS_IN_RANGE_FILE));
        saveAllProductsInRange();

        // Query 2 – Successfully Sold Products
        console.printInfoMessage(String.format("Generating {%s} ...", USERS_SOLD_FILE));
        successfullySoldProducts();

        // Query 3 – Categories by Products Count
        console.printInfoMessage(String.format("Generating {%s} ...", CATEGORIES_BY_PRODUCTS_FILE));
        categoriesByProductsCount();

        // Query 4 – Users and Products
        console.printInfoMessage(String.format("Generating {%s} ...", USERS_AND_PRODUCTS_FILE));
        usersAndProducts();

        // 5. Car Dealer Import Data
        console.printInfoMessage("Seeding CarDealer...");
        seedCarDealerData();

        // Query 1 – Ordered Customers
        console.printInfoMessage(String.format("Generating {%s} ...", ORDERED_CUSTOMERS_FILE));
        orderedCustomers();

        // Query 2 – Cars from Make Toyota
        console.printInfoMessage(String.format("Generating {%s} ...", TOYOTA_CARS_FILE));
        carsFromMakeToyota();

        // Query 3 – Local Suppliers
        console.printInfoMessage(String.format("Generating {%s} ...", LOCAL_SUPPLIERS_FILE));
        localSuppliers();

        // Query 4 – Cars with Their List of Parts
        console.printInfoMessage(String.format("Generating {%s} ...", CARS_AND_PARTS_FILE));
        carsWithTheirListOfParts();

        // Query 5 – Total Sales by Customer
        console.printInfoMessage(String.format("Generating {%s} ...", CUSTOMERS_TOTAL_SALES_FILE));
        totalSalesByCustomer();

        // Query 6 – Sales with Applied Discount
        /*Get all sales with information about the car, the customer and the price of the sale with and without discount.
        Export the list of sales to JSON in the format provided below.*/
        console.printInfoMessage(String.format("Generating {%s} ...", SALES_DISCOUNTS_FILE));
        salesWithDiscount();


    }


    private void salesWithDiscount() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + SALES_DISCOUNTS_FILE,
                        this.saleService.getAllSalesWithDiscount());
    }

    private void totalSalesByCustomer() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + CUSTOMERS_TOTAL_SALES_FILE,
                        this.customerService.getAllCustomersWithTotalOfTheSales());
    }

    private void carsWithTheirListOfParts() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + CARS_AND_PARTS_FILE,
                        this.carService.getAllCars());
    }

    private void localSuppliers() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + LOCAL_SUPPLIERS_FILE,
                        this.supplierService.gatAllLocalSuppliers());
    }

    private void carsFromMakeToyota() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + TOYOTA_CARS_FILE,
                        this.carService.getCarsByMake("Toyota"));
    }

    private void orderedCustomers() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + ORDERED_CUSTOMERS_FILE,
                        this.customerService.getCustomersOrderedByBirthDateAndYoungerDrivers());
    }

    private void seedCarDealerData() throws IOException {
        if (this.supplierService.hasNoRecords())
            this.seedCarDealerService.seed();
    }

    private void usersAndProducts() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + USERS_AND_PRODUCTS_FILE,
                        this.userService.getAllUsersWithMoreThanOneSoldProductsOrderByProductSoldDescThenByLastName());
    }

    private void categoriesByProductsCount() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + CATEGORIES_BY_PRODUCTS_FILE,
                        this.categoryService.getCategoriesOrderByNumberOfProducts());
    }

    private void successfullySoldProducts() throws IOException {
        this.fileService
                .writeToJSONFile(OUTPUT_FILE_PATH + USERS_SOLD_FILE,
                        this.userService.getAllUsersWithMoreThanOneSoldProducts());
    }

    private void saveAllProductsInRange() throws IOException {
        this.fileService.writeToJSONFile(OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE,
                this.productService
                        .getNotBoughtProductsWithPriceInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000)));
    }

    private void saveAllProductsInRangeXml() throws JAXBException, IOException {
        this.fileService.writeToXMLFile(OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_XML_FILE,
                new ProductInRangeList(this.productService
                        .getNotBoughtProductsWithPriceInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                        .stream().map(ProductInRangeXmlDto::new).collect(Collectors.toList())));
    }

    private void printAllProductsInRangeXml() throws JAXBException, IOException {
        console.printGreenMessage(
                this.fileService.readXMLFile(
                                OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_XML_FILE,
                                ProductInRangeList.class)
                        .getProducts()
                        .stream()
                        .map(x -> String.format("%s %.2f %s", x.getName(), x.getPrice(), x.getSeller()))
                        .collect(Collectors.joining(System.lineSeparator())));
    }

    private void seedProductShopData() throws IOException {
        if (this.productService.hasNoRecords())
            this.seedProductShopService.seed();
    }
}
