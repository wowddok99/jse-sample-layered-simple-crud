package com.example.jse_sample_layered_simple_crud.board.repository;

import com.example.jse_sample_layered_simple_crud.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommandRepository extends JpaRepository<Board, Long> {

}
