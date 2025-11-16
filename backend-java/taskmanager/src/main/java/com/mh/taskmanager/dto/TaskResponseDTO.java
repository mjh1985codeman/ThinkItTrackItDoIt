package com.mh.taskmanager.dto;

import com.mh.taskmanager.model.enums.Category;
import com.mh.taskmanager.model.enums.Priority;
import com.mh.taskmanager.model.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponseDTO {

    private Long id;

    private String title;

    private String description;

    private Priority priority;

    private Status status;

    private Category category;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime completedAt;

    private boolean archived;

    private Integer sortOrder;

    private String notes;

    private Long goalId; // nullable
}
