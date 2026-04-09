package com.projectmanager.backend.controller;

import com.projectmanager.backend.dto.AssignUserRequest;
import com.projectmanager.backend.dto.CreateTaskRequest;
import com.projectmanager.backend.dto.MoveTaskRequest;
import com.projectmanager.backend.dto.TaskResponse;
import com.projectmanager.backend.model.Task;
import com.projectmanager.backend.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/columns/{columnId}/tasks")
    public Task createTask(
            @PathVariable Long columnId,
            @RequestBody CreateTaskRequest request
    ) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        return taskService.createTask(columnId, task);
    }

    @GetMapping("/columns/{columnId}/tasks")
    public List<Task> getTasks(@PathVariable Long columnId) {
        return taskService.getTasks(columnId);
    }

    @PatchMapping("/tasks/{taskId}/move")
    public Task moveTask(
            @PathVariable Long taskId,
            @RequestBody MoveTaskRequest request
    ) {
        return taskService.moveTask(
                taskId,
                request.getTargetColumnId(),
                request.getNewPosition()
        );
    }

    @PatchMapping("/tasks/{taskId}/assign")
    public TaskResponse assignUser(
            @PathVariable Long taskId,
            @RequestBody AssignUserRequest request
    ) {
        return taskService.assignUser(
                taskId,
                request.getUserId()
        );
    }
}