package com.mh.taskmanager.model;

import com.mh.taskmanager.model.enums.Category;
import com.mh.taskmanager.model.enums.Priority;
import com.mh.taskmanager.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;

    @Enumerated(EnumType.STRING)
    private Status status = Status.TODO;

    @Enumerated(EnumType.STRING)
    private Category category = Category.PERSONAL;

    @Lob
    private String notes;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    private LocalDateTime completedAt;

    private boolean archived = false;

    private Integer sortOrder = 0; // default for now

    // OPTIONAL relationship to Goal
    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = true)
    private Goal goal;
}
