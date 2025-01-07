package org.example.todolist.service;

import org.example.todolist.model.Task;
import org.example.todolist.model.Task.Priority;
import org.example.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }

    @Override
    public List<Task> getIncompleteTasks() {
        return taskRepository.findByCompleted(false);
    }

    @Override
    public Task toggleTaskStatus(Long id) {
        Task task = getTaskById(id);
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }

    @Override
    public List<Task> getTasksDueBeforeDate(LocalDate date) {
        return taskRepository.findByDueDateBefore(date);
    }

    @Override
    public List<Task> getOverdueTasks() {
        return taskRepository.findByDueDateBeforeAndCompletedFalse(LocalDate.now());
    }

    @Override
    public long countTotalTasks() {
        return taskRepository.count();
    }

    @Override
    public long countCompletedTasks() {
        return taskRepository.countByCompleted(true);
    }

    @Override
    public long countTasksByPriority(Priority priority) {
        return taskRepository.countByPriority(priority);
    }
}