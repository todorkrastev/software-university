package core;

import models.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class TaskManagerTests {
    private interface InternalTest {
        void execute();
    }

    private TaskManager taskManager;

    private Task getRandomTask() {
        return new Task(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                (int) Math.min(1, Math.random() * 1_000_000_000),
                UUID.randomUUID().toString());
    }

    @Before
    public void setup() {
        this.taskManager = new TaskManagerImpl();
    }

    public void performCorrectnessTesting(InternalTest[] methods) {
        Arrays.stream(methods)
                .forEach(method -> {
                    this.taskManager = new TaskManagerImpl();

                    try {
                        method.execute();
                    } catch (IllegalArgumentException ignored) { }
                });

        this.taskManager = new TaskManagerImpl();
    }

    // Correctness Tests

    @Test
    public void testSize_ShouldReturnCorrectResults() {
        this.taskManager.addTask(getRandomTask());
        this.taskManager.addTask(getRandomTask());
        this.taskManager.addTask(getRandomTask());

        assertEquals(this.taskManager.size(), 3);
    }

    @Test
    public void testContains_WithExistentTask_ShouldReturnTrue() {
        Task task = getRandomTask();
        this.taskManager.addTask(task);

        assertTrue(this.taskManager.contains(task));
    }

    @Test
    public void testGetTask_WithExistentTask_ShouldReturnCorrectResults() {
        Task task = getRandomTask();
        this.taskManager.addTask(task);

        assertEquals(task, this.taskManager.getTask(task.getId()));
    }

    @Test
    public void testGetTask_WithNonExistentTask_ShouldThrowException() {
        Task task = getRandomTask();
        this.taskManager.addTask(task);

        // Little bit of hacks
        try {
            this.taskManager.getTask(getRandomTask().getId());
        } catch (IllegalArgumentException e) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }

    @Test
    public void testExecuteTask_WithCorrectData_ShouldReturnCorrectResults() {
        Task task = getRandomTask();
        this.taskManager.addTask(task);
        this.taskManager.addTask(getRandomTask());
        this.taskManager.addTask(getRandomTask());

        Task executed = this.taskManager.executeTask();

        assertEquals(task, executed);
    }

    @Test
    public void testRescheduleTask_WithExistentTask_ShouldReturnCorrectResults() {
        Task task = getRandomTask();
        this.taskManager.addTask(task);
        this.taskManager.executeTask();
        this.taskManager.rescheduleTask(task.getId());
        Task rescheduledExecuted = this.taskManager.executeTask();

        assertEquals(task, rescheduledExecuted);
    }

    // Performance Tests

    @Test
    public void testContains_With100000Results_ShouldPassQuickly() {
        this.performCorrectnessTesting(new InternalTest[] {
                this::testContains_WithExistentTask_ShouldReturnTrue
        });

        int count = 100000;

        Task taskToContain = null;

        for (int i = 0; i < count; i++)
        {
            if(i == count / 2) {
                taskToContain = getRandomTask();
                this.taskManager.addTask(taskToContain);
            } else {
                this.taskManager.addTask(getRandomTask());
            }
        }

        long start = System.currentTimeMillis();

        this.taskManager.contains(taskToContain);

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 5);
    }

    @Test
    public void testRescheduleTask_With100000Results_ShouldPassQuickly() {
        this.performCorrectnessTesting(new InternalTest[] {
                this::testRescheduleTask_WithExistentTask_ShouldReturnCorrectResults
        });

        int count = 100000;

        for (int i = 0; i < count; i++)
        {
            this.taskManager.addTask(getRandomTask());
        }

        long start = System.currentTimeMillis();

        Task task = this.taskManager.executeTask();
        this.taskManager.rescheduleTask(task.getId());

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 15);
    }
}
