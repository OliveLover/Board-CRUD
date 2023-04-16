package com.example.crud.repository;

import com.example.crud.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<BoardMapping> findAllByOrderByCreatedAtDesc();
    List<BoardMapping> findOneById(Long id);
}
