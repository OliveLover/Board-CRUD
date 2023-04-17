package com.example.crud.service;

import com.example.crud.dto.BoardRequestDto;
import com.example.crud.dto.BoardResponseDto;
import com.example.crud.entity.Board;
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
    public String saveBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return requestDto.getContents();
    }

    @Transactional
    public List<BoardResponseDto> getBoard() {
        List<Board> board = boardRepository.findAllByOrderByCreatedAtDesc();
        List<BoardResponseDto> dtos = new ArrayList<>();
        for (Board boards : board) {
            dtos.add(new BoardResponseDto(boards));
        }
        return dtos;
    }

    @Transactional
    public BoardResponseDto selectGetBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new BoardResponseDto(board);
    }

    @Transactional
    public String update(Long id, String password, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(password.equals(board.getPassword())) {
            board.update(requestDto);
            return board.getContents();
        }
        else {
            return "패스워드가 맞지 않습니다.";
        }

    }

    public String deleteBoard(Long id, String password) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(password.equals(board.getPassword())) {
            boardRepository.deleteById(id);
            return "삭제 완료";
        }
        else {
            return "패스워드가 맞지 않습니다.";
        }
    }

}
