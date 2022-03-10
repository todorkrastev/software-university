package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final ShampooService shampooService;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public CommandLineRunnerImpl(ShampooService shampooService) {
        this.shampooService = shampooService;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Please, enter exercise number");
        int exNum = Integer.parseInt(reader.readLine());

        switch (exNum) {
            case 1 -> {
                p01_SelectShampoosBySize();
            }
            case 2 -> {
                p02_SelectShampoosBySizeOrLabel();
            }
            case 3 -> {
                p03_SelectShampoosByPrice();
            }

            case 4 -> {
                p04_SelectIngredientsByName();
            }
        }
    }

    private void p04_SelectIngredientsByName() {

    }

    private void p03_SelectShampoosByPrice() throws IOException {
        System.out.println("Please, select shampoos by price -> 5");
        BigDecimal price = new BigDecimal(reader.readLine());

        this.shampooService.findAllShampoosWhichPriceIsHigherThanGivenOne(price);
    }

    private void p02_SelectShampoosBySizeOrLabel() throws IOException {
        System.out.println("Please, select size of shampoo -> Small, Medium or Large");
        String sizeName = reader.readLine().toUpperCase();
        Size size = Size.valueOf(sizeName);

        System.out.println("Please, select id of label -> 10");
        int labelID = Integer.parseInt(reader.readLine());

        shampooService.findAllShampoosByGivenSizeOrLabel(size, labelID);
    }

    private void p01_SelectShampoosBySize() throws IOException {
        System.out.println("Please, select size of shampoo -> Small, Medium or Large");
        String sizeName = reader.readLine().toUpperCase();
        Size size = Size.valueOf(sizeName);

        shampooService.findAllShampoosByGivenSizeOrderedByShampooId(size);
    }
}
