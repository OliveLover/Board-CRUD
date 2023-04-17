package com.example.crud.repository;

import com.example.crud.dto.BoardRequestDto;
import com.example.crud.dto.BoardResponseDto;
import com.example.crud.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByCreatedAtDesc();
    List<BoardResponseDto> findOneById(Long id);
}
