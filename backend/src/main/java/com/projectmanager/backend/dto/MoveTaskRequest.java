package com.projectmanager.backend.dto;

public class MoveTaskRequest {

    private Long targetColumnId;
    private Integer newPosition;

    public Long getTargetColumnId() {
        return targetColumnId;
    }

    public Integer getNewPosition() {
        return newPosition;
    }
}