package bg.softuni.java_advanced.preparation_exam_16_12_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P01_Cooking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientStack::push);

        Map<String, Integer> foodMap = new TreeMap<>();
        foodMap.put("Bread", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pastry", 0);
        foodMap.put("Fruit Pie", 0);

        //stack -> LIFO
//stack.push -> add element
//stack.pop -> remove element
//stack.peek -> getting topmost element

        //queue -> FIFO
//queue.offer -> add element -> returns false if queue is full
//queue.poll -> remove element -> returns null if queue is empty
//queue.peek -> check first element


        while (!liquidsQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int ingredient = ingredientStack.peek();
            int liquid = liquidsQueue.poll();
            int sum = liquid + ingredient;

            if (sum == 25) {
                removeElement(ingredientStack);
                foodMap.put("Bread", foodMap.get("Bread") + 1);
            } else if (sum == 50) {
                removeElement(ingredientStack);
                foodMap.put("Cake", foodMap.get("Cake") + 1);
            } else if (sum == 75) {
                removeElement(ingredientStack);
                foodMap.put("Pastry", foodMap.get("Pastry") + 1);
            } else if (sum == 100) {
                removeElement(ingredientStack);
                foodMap.put("Fruit Pie", foodMap.get("Fruit Pie") + 1);
            } else {
                ingredientStack.push(ingredientStack.pop() + 3);
            }
        }
        if (hasAllFoods(foodMap)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        String outputLiquids = "Liquids left: "
                + (liquidsQueue.isEmpty() ? "none" :
                liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(outputLiquids);

        String outputIngredients = "Ingredients left: "
                + (ingredientStack.isEmpty() ? "none" :
                ingredientStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(outputIngredients);

        foodMap
                .forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

    }

    private static boolean hasAllFoods(Map<String, Integer> cookedMealMap) {
        return 1 <= cookedMealMap.get("Bread") && 1 <= cookedMealMap.get("Cake") && 1 <= cookedMealMap.get("Pastry") && 1 <= cookedMealMap.get("Fruit Pie");
    }

    private static void removeElement(ArrayDeque<Integer> ingredientStack) {
        ingredientStack.pop();
    }
}
