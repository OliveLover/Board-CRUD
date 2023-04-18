package com.example.crud.dto;

import com.example.crud.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long boardId;
    private String userName;
    private String title;
    private String contents;

    public BoardResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.userName = board.getUserName();
        this.title = board.getTitle();
        this.contents = board.getContents();
    }
}
