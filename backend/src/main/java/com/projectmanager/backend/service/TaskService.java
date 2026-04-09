package com.projectmanager.backend.service;

import com.projectmanager.backend.dto.TaskResponse;
import com.projectmanager.backend.dto.UserSummary;
import com.projectmanager.backend.model.BoardColumn;
import com.projectmanager.backend.model.Task;
import com.projectmanager.backend.model.User;
import com.projectmanager.backend.repository.ColumnRepository;
import com.projectmanager.backend.repository.TaskRepository;
import com.projectmanager.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ColumnRepository columnRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,
                       ColumnRepository columnRepository,
                       UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.columnRepository = columnRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(Long columnId, Task taskData) {

        BoardColumn column = columnRepository.findById(columnId)
                .orElseThrow(() -> new RuntimeException("Columna no encontrada"));

        int position = taskRepository
                .findByBoardColumnIdOrderByPosition(columnId)
                .size();

        Task task = new Task();
        task.setTitle(taskData.getTitle());
        task.setDescription(taskData.getDescription());
        task.setPriority(taskData.getPriority());
        task.setDueDate(taskData.getDueDate());
        task.setBoardColumn(column);
        task.setPosition(position);

        return taskRepository.save(task);
    }

    public List<Task> getTasks(Long columnId) {
        return taskRepository.findByBoardColumnIdOrderByPosition(columnId);
    }

    public Task moveTask(Long taskId, Long targetColumnId, Integer newPosition) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task no encontrada"));

        BoardColumn sourceColumn = task.getBoardColumn();

        BoardColumn targetColumn = columnRepository.findById(targetColumnId)
                .orElseThrow(() -> new RuntimeException("Columna destino no encontrada"));

        List<Task> sourceTasks = taskRepository
                .findByBoardColumnIdOrderByPosition(sourceColumn.getId());

        List<Task> targetTasks = taskRepository
                .findByBoardColumnIdOrderByPosition(targetColumn.getId());

        sourceTasks.remove(task);

        for (int i = 0; i < sourceTasks.size(); i++) {
            sourceTasks.get(i).setPosition(i);
        }

        if (newPosition > targetTasks.size()) {
            newPosition = targetTasks.size();
        }

        targetTasks.add(newPosition, task);

        for (int i = 0; i < targetTasks.size(); i++) {
            targetTasks.get(i).setPosition(i);
            targetTasks.get(i).setBoardColumn(targetColumn);
        }

        taskRepository.saveAll(sourceTasks);
        taskRepository.saveAll(targetTasks);

        return task;
    }

    public TaskResponse assignUser(Long taskId, Long userId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task no encontrada"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        task.setAssignee(user);

        Task saved = taskRepository.save(task);

        return mapTask(saved);
    }

    private TaskResponse mapTask(Task task) {

        UserSummary assignee = null;

        if (task.getAssignee() != null) {
            assignee = new UserSummary(
                    task.getAssignee().getId(),
                    task.getAssignee().getEmail()
            );
        }

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPosition(),
                task.getPriority(),
                assignee
        );
    }
}