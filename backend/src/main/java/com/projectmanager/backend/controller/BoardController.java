package com.projectmanager.backend.controller;

import com.projectmanager.backend.model.Board;
import com.projectmanager.backend.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects/{projectId}/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public Board createBoard(
            @PathVariable Long projectId,
            @RequestBody Board request
    ) {
        return boardService.createBoard(projectId, request.getName());
    }

    @GetMapping
    public List<Board> getBoards(@PathVariable Long projectId) {
        return boardService.getBoards(projectId);
    }
}