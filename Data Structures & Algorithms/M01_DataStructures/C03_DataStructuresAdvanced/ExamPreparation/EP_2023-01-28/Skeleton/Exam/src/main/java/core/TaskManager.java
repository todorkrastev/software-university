package core;

import models.Task;

public interface TaskManager {
    void addTask(Task task);

    boolean contains(Task task);

    int size();

    Task getTask(String taskId);

    void deleteTask(String taskId);

    Task executeTask();

    void rescheduleTask(String taskId);

    Iterable<Task> getDomainTasks(String domain);

    Iterable<Task> getTasksInEETRange(int lowerBound, int upperBound);

    Iterable<Task> getAllTasksOrderedByEETThenByName();
}
