package com.projectmanager.backend.dto;

import java.time.LocalDateTime;

public class CreateTaskRequest {

    private String title;
    private String description;
    private Integer priority;
    private LocalDateTime dueDate;

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Integer getPriority() { return priority; }
    public LocalDateTime getDueDate() { return dueDate; }
}