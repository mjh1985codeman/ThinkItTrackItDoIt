package com.mh.taskmanager.controller;

import com.mh.taskmanager.model.Task;
import com.mh.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // === CREATE ===
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // === READ: Get All ===
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // === READ: Get by ID ===
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    // === UPDATE ===
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        // Ensure the ID in the URL matches the object
        updatedTask.setId(id);
        return taskService.updateTask(updatedTask);
    }

    // === DELETE ===
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
