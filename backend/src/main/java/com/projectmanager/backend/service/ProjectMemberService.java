package com.projectmanager.backend.service;

import com.projectmanager.backend.enums.ProjectRole;
import com.projectmanager.backend.model.Project;
import com.projectmanager.backend.model.ProjectMember;
import com.projectmanager.backend.model.User;
import com.projectmanager.backend.repository.ProjectMemberRepository;
import com.projectmanager.backend.repository.ProjectRepository;
import com.projectmanager.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectMemberService(ProjectMemberRepository projectMemberRepository,
                                ProjectRepository projectRepository,
                                UserRepository userRepository) {
        this.projectMemberRepository = projectMemberRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public ProjectMember addMember(Long projectId, Long userId, ProjectRole role) {

        // Validaciones básicas
        if (projectMemberRepository.findByProjectIdAndUserId(projectId, userId).isPresent()) {
            throw new RuntimeException("El usuario ya es miembro del proyecto");
        }

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        ProjectMember member = new ProjectMember();
        member.setProject(project);
        member.setUser(user);
        member.setRole(role);

        return projectMemberRepository.save(member);
    }

    public List<ProjectMember> getMembers(Long projectId) {
        return projectMemberRepository.findByProjectId(projectId);
    }

    public void removeMember(Long projectId, Long userId) {

        ProjectMember member = projectMemberRepository
                .findByProjectIdAndUserId(projectId, userId)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));

        if (member.getRole() == ProjectRole.OWNER) {
            throw new RuntimeException("No se puede eliminar al OWNER del proyecto");
        }

        projectMemberRepository.delete(member);
    }
}