package com.projectmanager.backend.dto;

import com.projectmanager.backend.enums.ProjectRole;

public class AddProjectMemberRequest {

    private Long userId;
    private ProjectRole role;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ProjectRole getRole() {
        return role;
    }

    public void setRole(ProjectRole role) {
        this.role = role;
    }
}