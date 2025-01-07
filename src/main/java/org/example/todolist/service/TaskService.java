package org.example.todolist.service;

import org.example.todolist.model.Task;
import org.example.todolist.model.Task.Priority;
import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    // Basic CRUD operations
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task saveTask(Task task);
    void deleteTask(Long id);

    // Task completion status methods
    List<Task> getCompletedTasks();
    List<Task> getIncompleteTasks();
    Task toggleTaskStatus(Long id);

    // Task filtering methods
    List<Task> getTasksByPriority(Priority priority);
    List<Task> getTasksDueBeforeDate(LocalDate date);
    List<Task> getOverdueTasks();

    // Task statistics methods
    long countTotalTasks();
    long countCompletedTasks();
    long countTasksByPriority(Priority priority);
}