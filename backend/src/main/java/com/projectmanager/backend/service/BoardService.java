package com.projectmanager.backend.service;

import com.projectmanager.backend.model.Board;
import com.projectmanager.backend.model.Project;
import com.projectmanager.backend.repository.BoardRepository;
import com.projectmanager.backend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final ProjectRepository projectRepository;

    public BoardService(BoardRepository boardRepository,
                        ProjectRepository projectRepository) {
        this.boardRepository = boardRepository;
        this.projectRepository = projectRepository;
    }

    public Board createBoard(Long projectId, String name) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow();

        Board board = new Board();
        board.setName(name);
        board.setProject(project);

        return boardRepository.save(board);
    }

    public List<Board> getBoards(Long projectId) {
        return boardRepository.findByProjectId(projectId);
    }
}