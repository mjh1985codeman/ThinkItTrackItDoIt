package com.mh.taskmanager.dto;

import lombok.Data;

@Data
public class GoalRequestDTO {

    private String title;

    private String description;

    private boolean archived;
}
