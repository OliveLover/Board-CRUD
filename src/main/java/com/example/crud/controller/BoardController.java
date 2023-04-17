package com.example.crud.controller;

import com.example.crud.dto.BoardRequestDto;
import com.example.crud.dto.BoardResponseDto;
import com.example.crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/saveBoard")
    public String saveBoard(@RequestBody BoardRequestDto requestDto){
        return boardService.saveBoard(requestDto);
    }

    @GetMapping("/api/getBoard")
    public List<BoardResponseDto> getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/api/getBoard/{id}")
    public BoardResponseDto selectGetBoard(@PathVariable Long id) {
        return boardService.selectGetBoard(id);
    }

    @PutMapping("/api/modBoard/{id}/{password}")
    public String updateBoard(@PathVariable Long id, @PathVariable String password, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, password, requestDto);
    }

    @DeleteMapping("/api/delBoard/{id}/{password}")
    public String deleteBoard(@PathVariable Long id, @PathVariable String password) {
        return boardService.deleteBoard(id, password);
    }

}
