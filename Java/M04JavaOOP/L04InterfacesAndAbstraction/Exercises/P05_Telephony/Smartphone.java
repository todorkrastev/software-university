package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P05_Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {

    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();

        this.urls
                .forEach(url -> {
                    if (url.matches("^[^0-9]+$")) {
                        output
                                .append("Browsing: ")
                                .append(url)
                                .append("!")
                                .append(System.lineSeparator());
                    } else {
                        output
                                .append("Invalid URL!")
                                .append(System.lineSeparator());
                    }
                });

        // second option - ternary operator
      /*   this.urls
                .forEach(url -> output.append(url.matches("^[^0-9]+$") ? String.format("Browsing: %s!", url)
                        : "Invalid URL!").append(System.lineSeparator())); */

        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();

        this.numbers
                .forEach(number -> {
                    if (number.matches("^[0-9]+$")) {
                        output
                                .append("Calling... ")
                                .append(number)
                                .append(System.lineSeparator());
                    } else {
                        output
                                .append("Invalid number!")
                                .append(System.lineSeparator());
                    }
                });

        // second option - ternary operator
       /* this.numbers
                .forEach(number -> output.append(number.matches("^[0-9]+$") ? String.format("Calling... %s", number)
                        : "Invalid number!").append(System.lineSeparator())); */

        return output.toString().trim();
    }
}
