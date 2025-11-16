package com.mh.taskmanager.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GoalResponseDTO {

    private Long id;

    private String title;

    private String description;

    private boolean archived;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // summary of tasks under this goal
    private List<TaskResponseDTO> tasks;
}
