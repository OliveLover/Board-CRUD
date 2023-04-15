package com.example.crud.controller;

import com.example.crud.dto.BoardRequestDto;
import com.example.crud.entity.Board;
import com.example.crud.repository.BoardMapping;
import com.example.crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/saveBoard")
    public Board saveBoard(@RequestBody BoardRequestDto requestDto){
        return boardService.saveBoard(requestDto);
    }

    @GetMapping("/api/getBoard")
    public List<BoardMapping> getBoard() {
        return boardService.getBoard();
    }
}
