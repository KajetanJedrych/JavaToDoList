package org.example.todolist.repository;

import org.example.todolist.model.Task;
import org.example.todolist.model.Task.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);
    List<Task> findByPriority(Priority priority);
    List<Task> findByDueDateBefore(LocalDate date);
    List<Task> findByDueDateBeforeAndCompletedFalse(LocalDate date);
    long countByCompleted(boolean completed);
    long countByPriority(Priority priority);
}