package bg.softuni.java_advanced.exam_preparation_23_October_2019.P03_HealthyHeaven;

public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        Restaurant restaurant = new Restaurant("Casa Domingo");

// Initialize the entities
        Vegetable tomato = new Vegetable("Tomato", 20);
        Vegetable cucumber = new Vegetable("Cucumber", 15);

        Salad salad = new Salad("Tomatoes with cucumbers");

        salad.add(tomato);
        salad.add(cucumber);

        System.out.println(salad.getTotalCalories()); // 35
        System.out.println(salad.getProductCount());  // 2

        System.out.println(salad);
// * Salad Tomatoes with cucumbers is 35 calories and have 2 products:
//  - Tomato have 20 calories
//  - Cucumber have 15 calories

        restaurant.add(salad);

        System.out.println(restaurant.buy("Invalid salad")); // false

// Initialize the second entities
        Vegetable corn = new Vegetable("Corn", 90);
        Salad casaDomingo = new Salad("Casa Domingo");

        casaDomingo.add(tomato);
        casaDomingo.add(cucumber);
        casaDomingo.add(corn);

        restaurant.add(casaDomingo);

        System.out.println(restaurant.getHealthiestSalad()); // Tomatoes with cucumbers

        System.out.println(restaurant.generateMenu());
// Casa Domingo have 2 salads:
// * Salad Tomatoes with cucumbers is 35 calories and have 2 products:
//  - Tomato have 20 calories
//  - Cucumber have 15 calories
// * Salad Casa Domingo is 125 calories and have 3 products:
//  - Tomato have 20 calories
//  - Cucumber have 15 calories
//  - Corn have 90 calories
    }
}
