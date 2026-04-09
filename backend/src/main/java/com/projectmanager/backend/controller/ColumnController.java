package com.projectmanager.backend.controller;

import com.projectmanager.backend.dto.ColumnResponse;
import com.projectmanager.backend.dto.CreateColumnRequest;
import com.projectmanager.backend.model.BoardColumn;
import com.projectmanager.backend.service.ColumnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards/{boardId}/columns")
public class ColumnController {

    private final ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @PostMapping
    public BoardColumn createColumn(
            @PathVariable Long boardId,
            @RequestBody CreateColumnRequest request
    ) {
        return columnService.createColumn(
                boardId,
                request.getName(),
                request.getPosition()
        );
    }

    @GetMapping
    public List<ColumnResponse> getColumns(@PathVariable Long boardId) {
        return columnService.getColumns(boardId);
    }
}