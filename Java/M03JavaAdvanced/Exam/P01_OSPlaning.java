import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_OSPlaning {

    private static ArrayDeque<Integer> tasksStack;
    private static ArrayDeque<Integer> threadsQueue;
    private static int neededToBeKilled = 0;
    private static int currThread;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        // Integer tasks, separated by ", " -> stack
        tasksStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);
        // Integer threads, separated by a single space -> queue
        threadsQueue = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        neededToBeKilled = Integer.parseInt(reader.readLine());

        while (!tasksStack.isEmpty() && !threadsQueue.isEmpty()) {
            //stack -> LIFO
//stack.push -> add element
//stack.pop -> remove element
//stack.peek -> getting topmost element

            //queue -> FIFO
//queue.offer -> add element -> returns false if queue is full
//queue.poll -> remove element -> returns null if queue is empty
//queue.peek -> check first element
            int currTask = tasksStack.peek();
            currThread = threadsQueue.peek();

            if (isFound(currTask)) break;

            if (isGreaterOrEqualTo(currTask)) {
                removeBothElements();
            } else if (isLessThan(currTask)) {
                removeThreadElement();
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", currThread, neededToBeKilled);
        System.out.println(threadsQueue
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void removeThreadElement() {
        threadsQueue.poll();
    }

    private static boolean isLessThan(int currTask) {
        return currThread < currTask;
    }

    private static boolean isGreaterOrEqualTo(int currTask) {
        return currTask <= currThread;
    }

    private static void removeBothElements() {
        tasksStack.pop();
        threadsQueue.poll();
    }

    private static boolean isFound(int currTask) {
        return currTask == neededToBeKilled;
    }
}

