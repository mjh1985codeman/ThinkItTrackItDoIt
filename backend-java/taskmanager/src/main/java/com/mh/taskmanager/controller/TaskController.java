package com.mh.taskmanager.controller;

import com.mh.taskmanager.dto.TaskRequestDTO;
import com.mh.taskmanager.dto.TaskResponseDTO;
import com.mh.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET all tasks (sorted by sortOrder)
    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET one task
    @GetMapping("/{id}")
    public TaskResponseDTO getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    // CREATE task
    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO request) {
        return taskService.createTask(request);
    }

    // UPDATE task
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO request) {
        return taskService.updateTask(id, request);
    }

    // DELETE task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
