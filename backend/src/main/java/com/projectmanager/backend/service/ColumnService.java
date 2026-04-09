package com.projectmanager.backend.service;

import com.projectmanager.backend.dto.ColumnResponse;
import com.projectmanager.backend.model.Board;
import com.projectmanager.backend.model.BoardColumn;
import com.projectmanager.backend.repository.BoardRepository;
import com.projectmanager.backend.repository.ColumnRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnService {

    private final ColumnRepository columnRepository;
    private final BoardRepository boardRepository;

    public ColumnService(ColumnRepository columnRepository,
                         BoardRepository boardRepository) {
        this.columnRepository = columnRepository;
        this.boardRepository = boardRepository;
    }

    public BoardColumn createColumn(Long boardId, String name, Integer position) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board no encontrado"));

        BoardColumn boardColumn = new BoardColumn();
        boardColumn.setName(name);
        boardColumn.setPosition(position);
        boardColumn.setBoard(board);

        return columnRepository.save(boardColumn);
    }

    public List<ColumnResponse> getColumns(Long boardId) {
        return columnRepository.findByBoardIdOrderByPosition(boardId)
                .stream()
                .map(c -> new ColumnResponse(
                        c.getId(),
                        c.getName(),
                        c.getPosition()
                ))
                .toList();
    }
}