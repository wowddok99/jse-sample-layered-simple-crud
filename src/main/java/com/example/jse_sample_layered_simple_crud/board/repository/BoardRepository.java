package com.example.jse_sample_layered_simple_crud.board.repository;

import com.example.jse_sample_layered_simple_crud.board.domain.Board;
import com.example.jse_sample_layered_simple_crud.board.repository.projection.BoardProjection.BoardDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<BoardDetailProjection> findBoardById(Long id);
}
