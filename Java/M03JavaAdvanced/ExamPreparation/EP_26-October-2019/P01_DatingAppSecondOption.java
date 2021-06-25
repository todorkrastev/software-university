import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_DatingAppSecondOption {

    private static ArrayDeque<Integer> malesStack;
    private static ArrayDeque<Integer> femalesQueue;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        malesStack = new ArrayDeque<>();
                Arrays.stream(reader.readLine().trim().split("\\s+"))
                        .map(Integer::parseInt)
                        .forEach(malesStack::push);
        femalesQueue = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matchesCounter = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int currMale = malesStack.peek();
            int currFemale = femalesQueue.peek();

            if (isEqualOrLessThanZero(currMale, currFemale)) {
                removeElementEqualOrLessThanZero(currMale, currFemale);
            } else if (isDivisibleBy25(currMale, currFemale)) {
                removeElementDivisibleBy25(currMale, currFemale);
            } else if (isElementsEqual(currMale, currFemale)) {
                removeElements();
                matchesCounter++;
            } else if (!isElementsEqual(currMale, currFemale)) {
                removeFemaleAndDecreaseMaleWith2();
            }
        }
        System.out.println("Matches: " + matchesCounter);
        String outputMales = "Males left: " + (malesStack.isEmpty() ? "none"
                : malesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(outputMales);
        String outputFemales = "Females left: " + (femalesQueue.isEmpty() ? "none"
                : femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(outputFemales);
    }

    private static void removeFemaleAndDecreaseMaleWith2() {
        femalesQueue.poll();
        malesStack.push(malesStack.pop() - 2);
    }

    private static void removeElements() {
        malesStack.pop();
        femalesQueue.poll();
    }

    private static boolean isElementsEqual(int currMale, int currFemale) {
        return currMale == currFemale;
    }

    private static boolean isDivisibleBy25(int currMale, int currFemale) {
        return currMale % 25 == 0 || currFemale % 25 == 0;
    }

    private static boolean isEqualOrLessThanZero(int currMale, int currFemale) {
        return currMale <= 0 || currFemale <= 0;
    }

    private static void removeElementDivisibleBy25(int currMale, int currFemale) {
        if (currMale % 25 == 0) {
            malesStack.pop();
            malesStack.pop();
        }
        if (currFemale % 25 == 0) {
            femalesQueue.poll();
            femalesQueue.poll();
        }
    }

    private static void removeElementEqualOrLessThanZero(int currMale, int currFemale) {
        if (currMale <= 0) {
            malesStack.pop();
        }
        if (currFemale <= 0) {
            femalesQueue.poll();
        }
    }
}
