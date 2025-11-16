package com.mh.taskmanager.service;

import com.mh.taskmanager.dto.TaskRequestDTO;
import com.mh.taskmanager.dto.TaskResponseDTO;
import com.mh.taskmanager.mapper.TaskMapper;
import com.mh.taskmanager.model.Goal;
import com.mh.taskmanager.model.Task;
import com.mh.taskmanager.model.enums.Status;
import com.mh.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final GoalService goalService;

    public TaskService(TaskRepository taskRepository, GoalService goalService) {
        this.taskRepository = taskRepository;
        this.goalService = goalService;
    }

    // GET ALL (sorted by sortOrder)
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAllByOrderBySortOrderAsc()
                .stream()
                .map(TaskMapper::toDTO)
                .toList();
    }

    // GET ONE
    public TaskResponseDTO getTask(Long id) {
        Task task = findTaskEntity(id);
        return TaskMapper.toDTO(task);
    }

    // CREATE
    public TaskResponseDTO createTask(TaskRequestDTO request) {

        Goal goal = goalService.findGoalEntity(request.getGoalId());

        Task task = TaskMapper.fromDTO(request, goal);

        // timestamps
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        // mark completedAt if status is DONE
        if (task.getStatus() == Status.DONE) {
            task.setCompletedAt(LocalDateTime.now());
        }

        taskRepository.save(task);

        return TaskMapper.toDTO(task);
    }

    // UPDATE
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO request) {

        Task task = findTaskEntity(id);

        Goal goal = goalService.findGoalEntity(request.getGoalId());

        TaskMapper.updateEntity(task, request, goal);

        // timestamps
        task.setUpdatedAt(LocalDateTime.now());

        // set/unset completedAt
        if (task.getStatus() == Status.DONE && task.getCompletedAt() == null) {
            task.setCompletedAt(LocalDateTime.now());
        }

        if (task.getStatus() != Status.DONE) {
            task.setCompletedAt(null);
        }

        taskRepository.save(task);

        return TaskMapper.toDTO(task);
    }

    // DELETE (hard delete)
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Helper
    public Task findTaskEntity(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
