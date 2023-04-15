package com.example.crud.service;

import com.example.crud.dto.BoardRequestDto;
import com.example.crud.entity.Board;
import com.example.crud.repository.BoardMapping;
import com.example.crud.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board saveBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return board;
    }

    @Transactional
    public List<BoardMapping> getBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public String update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getContents();
    }
}
