package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CookiesProblem {
    public Integer solve(int targetSweetness, int[] cookiesSweetness) {
        Queue<Integer> cookies = new PriorityQueue<>();

        Arrays.stream(cookiesSweetness)
                .forEach(s -> cookies.offer(s));

        int counter = 0;
        while (cookies.size() > 1) {
            if (cookies.peek() >= targetSweetness) {
                break;
            }
            int newSweetness = cookies.poll() + cookies.poll() * 2;
            cookies.offer(newSweetness);
            counter++;
        }
        return cookies.peek() >= targetSweetness ? counter: -1;
    }
}