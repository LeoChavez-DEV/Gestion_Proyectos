package com.projectmanager.backend.controller;

import com.projectmanager.backend.dto.AddProjectMemberRequest;
import com.projectmanager.backend.model.ProjectMember;
import com.projectmanager.backend.service.ProjectMemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects/{projectId}/members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    public ProjectMemberController(ProjectMemberService projectMemberService) {
        this.projectMemberService = projectMemberService;
    }

    @PostMapping
    public ProjectMember addMember(
            @PathVariable Long projectId,
            @RequestBody AddProjectMemberRequest request
    ) {
        return projectMemberService.addMember(
                projectId,
                request.getUserId(),
                request.getRole()
        );
    }

    @GetMapping
    public List<ProjectMember> getMembers(@PathVariable Long projectId) {
        return projectMemberService.getMembers(projectId);
    }

    @DeleteMapping("/{userId}")
    public void removeMember(
            @PathVariable Long projectId,
            @PathVariable Long userId
    ) {
        projectMemberService.removeMember(projectId, userId);
    }
}