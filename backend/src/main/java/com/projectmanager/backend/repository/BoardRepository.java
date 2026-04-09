package com.projectmanager.backend.repository;

import com.projectmanager.backend.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByProjectId(Long projectId);

}