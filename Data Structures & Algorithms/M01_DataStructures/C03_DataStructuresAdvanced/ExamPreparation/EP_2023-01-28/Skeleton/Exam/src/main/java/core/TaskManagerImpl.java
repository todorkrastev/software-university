package core;

import models.Task;

import java.util.*;
import java.util.stream.Collectors;

public class TaskManagerImpl implements TaskManager {

    private final LinkedHashMap<String, Task> tasksById;
    private final LinkedHashSet<Task> pendingTasks;
    private final Map<String, Task> executedTasks;

    public TaskManagerImpl() {
        this.tasksById = new LinkedHashMap<>();
        this.pendingTasks = new LinkedHashSet<>();
        this.executedTasks = new HashMap<>();
    }

    @Override
    public void addTask(Task task) {
        this.tasksById.put(task.getId(), task);
        this.pendingTasks.add(task);
    }

    @Override
    public boolean contains(Task task) {
        return this.tasksById.containsKey(task.getId());
    }

    @Override
    public int size() {
        return this.pendingTasks.size();
    }

    @Override
    public Task getTask(String taskId) {
        Task searchTask = tasksById.get(taskId);

        if (searchTask == null) {
            throw new IllegalArgumentException("Task not found");
        }

        return searchTask;
    }

    @Override
    public void deleteTask(String taskId) {
        Task removed = tasksById.remove(taskId);

        if (removed == null) {
            throw new IllegalArgumentException("Task not found");
        }

        pendingTasks.remove(removed);
        executedTasks.remove(taskId);
    }

    @Override
    public Task executeTask() {
        if (pendingTasks.isEmpty()) {
            throw new IllegalArgumentException("No tasks to execute");
        }

        Iterator<Task> iterator = pendingTasks.iterator();
        Task firstTask = iterator.next();
        iterator.remove();
        executedTasks.put(firstTask.getId(), firstTask);

        return firstTask;
    }

    @Override
    public void rescheduleTask(String taskId) {
        Task executed = executedTasks.remove(taskId);

        if (executed == null) {
            throw new IllegalArgumentException("Task not found");
        }

        pendingTasks.add(executed);
    }

    @Override
    public Iterable<Task> getDomainTasks(String domain) {
        List<Task> result = this.pendingTasks.stream()
                .filter(t -> t.getDomain().equals(domain))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException("No tasks with domain " + domain);
        }

        return result;
    }

    @Override
    public Iterable<Task> getTasksInEETRange(int lowerBound, int upperBound) {
        return this.pendingTasks.stream()
                .filter(t -> t.getEstimatedExecutionTime() >= lowerBound && t.getEstimatedExecutionTime() <= upperBound)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Task> getAllTasksOrderedByEETThenByName() {
        return tasksById.values()
                .stream()
                .sorted(Comparator.comparing(Task::getEstimatedExecutionTime, Comparator.reverseOrder())
                        .thenComparing(t -> t.getName().length()))
                .collect(Collectors.toList());
    }
}