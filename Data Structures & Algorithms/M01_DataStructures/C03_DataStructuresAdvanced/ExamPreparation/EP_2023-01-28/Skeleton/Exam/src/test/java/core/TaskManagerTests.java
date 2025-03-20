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

    @Test
    public void testDeleteTask_WithExistentTask_ShouldRemoveTask() {
        Task task = getRandomTask();
        this.taskManager.addTask(task);

        this.taskManager.deleteTask(task.getId());

        assertFalse(this.taskManager.contains(task));
    }

    @Test
    public void testDeleteTask_WithNonExistentTask_ShouldThrowException() {
        try {
            this.taskManager.deleteTask(UUID.randomUUID().toString());
        } catch (IllegalArgumentException e) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }

    @Test
    public void testDeleteTask_ShouldDecreaseSize() {
        Task task1 = getRandomTask();
        Task task2 = getRandomTask();
        this.taskManager.addTask(task1);
        this.taskManager.addTask(task2);

        this.taskManager.deleteTask(task1.getId());

        assertEquals(1, this.taskManager.size());
    }

    @Test
    public void testGetDomainTasks_WithValidDomain_ShouldReturnCorrectTasks() {
        Task task1 = new Task(UUID.randomUUID().toString(), "Task1", 10, "domain1");
        Task task2 = new Task(UUID.randomUUID().toString(), "Task2", 20, "domain1");
        Task task3 = new Task(UUID.randomUUID().toString(), "Task3", 30, "domain2");
        this.taskManager.addTask(task1);
        this.taskManager.addTask(task2);
        this.taskManager.addTask(task3);

        Iterable<Task> domainTasks = this.taskManager.getDomainTasks("domain1");
        List<Task> domainTaskList = StreamSupport.stream(domainTasks.spliterator(), false).collect(Collectors.toList());

        assertEquals(2, domainTaskList.size());
        assertTrue(domainTaskList.contains(task1));
        assertTrue(domainTaskList.contains(task2));
    }

    @Test
    public void testGetDomainTasks_WithInvalidDomain_ShouldThrowException() {
        try {
            this.taskManager.getDomainTasks("invalidDomain");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }

    @Test
    public void testGetTasksInEETRange_WithValidRange_ShouldReturnCorrectTasks() {
        Task task1 = new Task(UUID.randomUUID().toString(), "Task1", 10, "domain1");
        Task task2 = new Task(UUID.randomUUID().toString(), "Task2", 20, "domain1");
        Task task3 = new Task(UUID.randomUUID().toString(), "Task3", 30, "domain2");
        this.taskManager.addTask(task1);
        this.taskManager.addTask(task2);
        this.taskManager.addTask(task3);

        Iterable<Task> tasksInRange = this.taskManager.getTasksInEETRange(15, 25);
        List<Task> tasksInRangeList = StreamSupport.stream(tasksInRange.spliterator(), false).collect(Collectors.toList());

        assertEquals(1, tasksInRangeList.size());
        assertTrue(tasksInRangeList.contains(task2));
    }

    @Test
    public void testGetTasksInEETRange_WithInvalidRange_ShouldReturnEmpty() {
        Task task1 = new Task(UUID.randomUUID().toString(), "Task1", 10, "domain1");
        Task task2 = new Task(UUID.randomUUID().toString(), "Task2", 20, "domain1");
        this.taskManager.addTask(task1);
        this.taskManager.addTask(task2);

        Iterable<Task> tasksInRange = this.taskManager.getTasksInEETRange(30, 40);
        List<Task> tasksInRangeList = StreamSupport.stream(tasksInRange.spliterator(), false).collect(Collectors.toList());

        assertTrue(tasksInRangeList.isEmpty());
    }

    @Test
    public void testGetAllTasksOrderedByEETThenByName_ShouldReturnCorrectOrder() {
        Task task1 = new Task(UUID.randomUUID().toString(), "A", 20, "domain1");
        Task task2 = new Task(UUID.randomUUID().toString(), "B", 10, "domain1");
        Task task3 = new Task(UUID.randomUUID().toString(), "C", 20, "domain2");
        this.taskManager.addTask(task1);
        this.taskManager.addTask(task2);
        this.taskManager.addTask(task3);

        Iterable<Task> orderedTasks = this.taskManager.getAllTasksOrderedByEETThenByName();
        List<Task> orderedTaskList = StreamSupport.stream(orderedTasks.spliterator(), false).collect(Collectors.toList());

        assertEquals(3, orderedTaskList.size());
        assertEquals(task1, orderedTaskList.get(0));
        assertEquals(task3, orderedTaskList.get(1));
        assertEquals(task2, orderedTaskList.get(2));
    }
}
