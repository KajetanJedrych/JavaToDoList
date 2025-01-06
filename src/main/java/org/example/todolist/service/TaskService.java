package org.example.todolist.service;

import org.example.todolist.model.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task saveTask(Task task);
    void deleteTask(Long id);
}
