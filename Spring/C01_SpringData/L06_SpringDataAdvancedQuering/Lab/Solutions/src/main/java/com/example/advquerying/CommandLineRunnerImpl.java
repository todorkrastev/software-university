package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public CommandLineRunnerImpl(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Please, enter exercise number");
        int exNum = Integer.parseInt(reader.readLine());

        switch (exNum) {
            case 1 -> p01_SelectShampoosBySize();
            case 2 -> p02_SelectShampoosBySizeOrLabel();
            case 3 -> p03_SelectShampoosByPrice();
            case 4 -> p04_SelectIngredientsByName();
            case 5 -> p05_SelectIngredientsByName();
            case 6 -> p06_CountShampoosByPrice();
            case 7 -> p07_SelectShampoosByIngredients();
            case 8 -> p08_SelectShampoosByIngredientsCount();
            case 9 -> p09_DeleteIngredientsByName();
            case 10 -> p10_UpdateIngredientsByPrice();
            case 11 -> p11_UpdateIngredientsByNames();
        }
    }

    private void p11_UpdateIngredientsByNames() throws IOException {
        System.out.println("Please, increase price with desired percentage -> 10");
        BigDecimal percentage = new BigDecimal(reader.readLine());

        System.out.println("Please, enter the names of the ingredients that requires increase of the price -> Apple, Aloe Vera, Wild Rose");
        Set<String> namesForUpdate =
                Arrays
                        .stream(reader.readLine().trim().split(",\\s+"))
                        .collect(Collectors.toSet());

        int affectedIngredients =
                this.ingredientService
                        .increasePricesWithGivenPercentageAndListOfNames(percentage, namesForUpdate);

        printSeparatorLine();
        System.out.println("Successfully updated the price with " + percentage + "%. Total ingredients changed: " + affectedIngredients + ".\nNames of updated ingredients: ");
        namesForUpdate.forEach(System.out::println);
        printSeparatorLine();
    }

    private void p10_UpdateIngredientsByPrice() throws IOException {
        System.out.println("Please, increase price with desired percentage -> 10");
        BigDecimal percentage = new BigDecimal(reader.readLine());

        int affectedIngredients =
                this.ingredientService
                        .increasePriceByGivenPercentage(percentage);

        printSeparatorLine();
        System.out.println("Successfully updated the price of all ingredients with " + percentage + "%. Total ingredients changed: " + affectedIngredients);
        printSeparatorLine();
    }

    private void p09_DeleteIngredientsByName() throws IOException {
        System.out.println("Please, delete ingredients by given name -> Apple");
        String ingredient = reader.readLine();

        int affectedIngredients =
                this.ingredientService
                        .deleteIngredientByGivenName(ingredient);

        printSeparatorLine();
        System.out.printf("%d are successfully deleted.%n", affectedIngredients);
        printSeparatorLine();
    }

    private void p08_SelectShampoosByIngredientsCount() throws IOException {
        System.out.println("Please, select all shampoos with ingredients less than given number -> 2");
        int number = Integer.parseInt(reader.readLine());

        printSeparatorLine();
        this.shampooService
                .findAllShampoosWithIngredientsLessThanGivenNumber(number);
        printSeparatorLine();
    }

    private void p07_SelectShampoosByIngredients() throws IOException {
        System.out.println("Please, select all shampoos with ingredients by given list -> Berry, Mineral-Collagen");

        Set<String> ingredients =
                Arrays
                        .stream(reader.readLine().trim().split(",\\s+"))
                        .collect(Collectors.toSet());

        printSeparatorLine();
        this.shampooService
                .findAllShampoosByGivenListWithIngredients(ingredients);
        printSeparatorLine();
    }

    private void p06_CountShampoosByPrice() throws IOException {
        System.out.println("Please, enter price -> 8.50");

        BigDecimal price = new BigDecimal(reader.readLine());

        int size =
                this.shampooService
                        .countAllShampoosWithPriceLowerThanGivenOne(price);

        printSeparatorLine();
        System.out.println(size);
        printSeparatorLine();
    }

    private void p05_SelectIngredientsByName() throws IOException {
        System.out.println("Please, select all ingredients by given name -> Lavender, Herbs, Apple");

        Set<String> names =
                Arrays
                        .stream(reader.readLine().trim().split(",\\s+"))
                        .collect(Collectors.toSet());

        printSeparatorLine();
        this.ingredientService
                .selectIngredientsByName(names);
        printSeparatorLine();
    }

    private void p04_SelectIngredientsByName() throws IOException {
        System.out.println("Please, select all ingredients which name starts with given letters");
        String letters = reader.readLine();

        printSeparatorLine();
        this.ingredientService
                .findAllIngredientsWhichNameStartsWithGivenLetter(letters);
        printSeparatorLine();
    }

    private void p03_SelectShampoosByPrice() throws IOException {
        System.out.println("Please, select shampoos by price -> 5");
        BigDecimal price = new BigDecimal(reader.readLine());

        printSeparatorLine();
        this.shampooService
                .findAllShampoosWhichPriceIsHigherThanGivenOne(price);
        printSeparatorLine();
    }

    private void p02_SelectShampoosBySizeOrLabel() throws IOException {
        System.out.println("Please, select size of shampoo -> Small, Medium or Large");
        String sizeName = reader.readLine().toUpperCase();
        Size size = Size.valueOf(sizeName);

        System.out.println("Please, select id of label -> 10");
        int labelID = Integer.parseInt(reader.readLine());

        printSeparatorLine();
        this.shampooService
                .findAllShampoosByGivenSizeOrLabel(size, labelID);
        printSeparatorLine();
    }

    private void p01_SelectShampoosBySize() throws IOException {
        System.out.println("Please, select size of shampoo -> Small, Medium or Large");
        String sizeName = reader.readLine().toUpperCase();
        Size size = Size.valueOf(sizeName);

        printSeparatorLine();
        this.shampooService
                .findAllShampoosByGivenSizeOrderedByShampooId(size);
        printSeparatorLine();
    }

    private void printSeparatorLine() {
        System.out.println("*".repeat(150));
    }
}
