package com.mh.taskmanager.mapper;

import com.mh.taskmanager.dto.TaskRequestDTO;
import com.mh.taskmanager.dto.TaskResponseDTO;
import com.mh.taskmanager.model.Goal;
import com.mh.taskmanager.model.Task;

public class TaskMapper {

    // Convert Entity -> ResponseDTO
    public static TaskResponseDTO toDTO(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setPriority(task.getPriority());
        dto.setStatus(task.getStatus());
        dto.setCategory(task.getCategory());
        dto.setDueDate(task.getDueDate());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());
        dto.setCompletedAt(task.getCompletedAt());
        dto.setArchived(task.isArchived());
        dto.setSortOrder(task.getSortOrder());
        dto.setNotes(task.getNotes());

        // If the task belongs to a goal, set its ID
        dto.setGoalId(task.getGoal() != null ? task.getGoal().getId() : null);

        return dto;
    }

    // Convert RequestDTO -> Entity (NEW Task)
    public static Task fromDTO(TaskRequestDTO request, Goal goal) {
        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus(request.getStatus());
        task.setCategory(request.getCategory());
        task.setDueDate(request.getDueDate());
        task.setSortOrder(request.getSortOrder());
        task.setNotes(request.getNotes());
        task.setGoal(goal); // may be null

        return task;
    }

    // Update an existing task from a RequestDTO
    public static void updateEntity(Task task, TaskRequestDTO request, Goal goal) {
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus(request.getStatus());
        task.setCategory(request.getCategory());
        task.setDueDate(request.getDueDate());
        task.setSortOrder(request.getSortOrder());
        task.setNotes(request.getNotes());
        task.setGoal(goal);
    }
}
