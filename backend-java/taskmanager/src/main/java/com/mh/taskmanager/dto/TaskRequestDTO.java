package com.mh.taskmanager.dto;

import com.mh.taskmanager.model.enums.Category;
import com.mh.taskmanager.model.enums.Priority;
import com.mh.taskmanager.model.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequestDTO {

    private String title;

    private String description;

    private Priority priority;

    private Status status;

    private Category category;

    private LocalDateTime dueDate;

    private String notes;

    private Integer sortOrder;

    private Long goalId; // optional
}
