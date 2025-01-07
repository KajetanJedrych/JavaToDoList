package org.example.todolist.controller;


import org.example.todolist.model.Task;
import org.example.todolist.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/new")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "tasks/form";
    }

    @PostMapping
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "tasks/form";
    }

    @PostMapping("/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task") Task task) {
        Task existingTask = taskService.getTaskById(id);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setCompleted(task.isCompleted());
            taskService.saveTask(existingTask);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("incompleteTasks", taskService.getIncompleteTasks());
        model.addAttribute("completedTasks", taskService.getCompletedTasks());
        return "tasks/list";
    }
    @PostMapping("/toggle/{id}")
    public String toggleTaskStatus(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            task.setCompleted(!task.isCompleted());
            taskService.saveTask(task);
        }
        return "redirect:/tasks";
    }
}