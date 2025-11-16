package com.mh.taskmanager.service;

import com.mh.taskmanager.model.Task;
import com.mh.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // === CREATE ===
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // === READ ===
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // === UPDATE ===
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    // === DELETE ===
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
