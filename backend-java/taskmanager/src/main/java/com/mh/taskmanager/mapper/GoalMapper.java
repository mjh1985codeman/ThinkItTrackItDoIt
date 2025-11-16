package com.mh.taskmanager.mapper;

import com.mh.taskmanager.dto.GoalRequestDTO;
import com.mh.taskmanager.dto.GoalResponseDTO;
import com.mh.taskmanager.model.Goal;

import java.util.stream.Collectors;

public class GoalMapper {

    // Convert Entity -> DTO
    public static GoalResponseDTO toDTO(Goal goal) {
        GoalResponseDTO dto = new GoalResponseDTO();

        dto.setId(goal.getId());
        dto.setTitle(goal.getTitle());
        dto.setDescription(goal.getDescription());
        dto.setArchived(goal.isArchived());
        dto.setCreatedAt(goal.getCreatedAt());
        dto.setUpdatedAt(goal.getUpdatedAt());

        // Map tasks INSIDE the goal
        dto.setTasks(
                goal.getTasks()
                        .stream()
                        .map(TaskMapper::toDTO)
                        .collect(Collectors.toList()));

        return dto;
    }

    // Create new Goal from DTO
    public static Goal fromDTO(GoalRequestDTO request) {
        Goal goal = new Goal();

        goal.setTitle(request.getTitle());
        goal.setDescription(request.getDescription());
        goal.setArchived(request.isArchived());

        return goal;
    }

    // Update existing goal
    public static void updateEntity(Goal goal, GoalRequestDTO request) {
        goal.setTitle(request.getTitle());
        goal.setDescription(request.getDescription());
        goal.setArchived(request.isArchived());
    }
}
