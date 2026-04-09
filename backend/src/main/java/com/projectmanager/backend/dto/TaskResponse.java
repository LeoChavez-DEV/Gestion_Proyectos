package com.projectmanager.backend.dto;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private Integer position;
    private Integer priority;
    private UserSummary assignee;

    public TaskResponse(Long id, String title, String description,
                        Integer position, Integer priority,
                        UserSummary assignee) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.priority = priority;
        this.assignee = assignee;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getPriority() {
        return priority;
    }

    public UserSummary getAssignee() {
        return assignee;
    }
}