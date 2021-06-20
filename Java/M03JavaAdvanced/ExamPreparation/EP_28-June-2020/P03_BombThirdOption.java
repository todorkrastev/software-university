import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P03_BombThirdOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        //bomb effects -> queue
        //bomb casing -> stack

        ArrayDeque<Integer> effectsQueue = Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casingStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(casingStack::push);

        //o	"Cherry Bombs: {count}"
        //o	"Datura Bombs: {count}"
        //o	"Smoke Decoy Bombs: {count}"
        int cherryCounter = 0;
        int daturaCounter = 0;
        int smokeDecoyCounter = 0;
        while (!effectsQueue.isEmpty() && !casingStack.isEmpty() && !hasBombPouch(cherryCounter, daturaCounter, smokeDecoyCounter)) {
            //stack -> LIFO
//stack.push -> add element
//stack.pop -> remove element
//stack.peek -> getting topmost element

            //queue -> FIFO
//queue.offer -> add element -> returns false if queue is full
//queue.poll -> remove element -> returns null if queue is empty
//queue.peek -> check first element
            int currEffect = effectsQueue.peek(); // getting topmost element
            int currCasing = casingStack.pop(); // remove element
            int sum = currCasing + currEffect;

            switch (sum) {
                case 40:
                    daturaCounter++;
                    effectsQueue.poll();
                    break;
                case 60:
                    cherryCounter++;
                    effectsQueue.poll();
                    break;
                case 120:
                    smokeDecoyCounter++;
                    effectsQueue.poll();
                    break;
                default:
                    casingStack.push(currCasing - 5);
                    break;
            }
        }
        if (hasBombPouch(cherryCounter, daturaCounter, smokeDecoyCounter)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        String output = "Bomb Effects: " + (effectsQueue.isEmpty() ? "empty"
                : effectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(output);

        output = "Bomb Casings: " + (casingStack.isEmpty() ? "empty"
                : casingStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(output);
        System.out.printf("Cherry Bombs: %d%n", cherryCounter);
        System.out.printf("Datura Bombs: %d%n", daturaCounter);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeDecoyCounter);
    }

    private static boolean hasBombPouch(int cherryCounter, int daturaCounter, int smokeDecoyCounter) {
        return 3 <= cherryCounter && 3 <= daturaCounter && 3 <= smokeDecoyCounter;
    }
}
