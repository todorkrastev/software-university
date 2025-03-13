package implementations;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PriorityQueueTest {
    private PriorityQueue<Integer> queue;

    @Before
    public void setUp() {
        this.queue = new PriorityQueue<>();
        List<Integer> elements = new ArrayList<>(List.of(15, 25, 6, 9, 5, 8, 17, 16));
        for (Integer element : elements) {
            this.queue.add(element);
        }
    }

    @Test
    public void testPollSingleElement() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(13);
        assertEquals(Integer.valueOf(13), priorityQueue.poll());
    }

    @Test
    public void testPollMultipleElements() {
        Integer[] expected = {25, 17, 16, 15, 9, 8, 6, 5};
        int index = 0;
        assertEquals(expected.length, queue.size());
        while (queue.size() != 0) {
            assertEquals(expected[index++], queue.poll());
        }
    }
}