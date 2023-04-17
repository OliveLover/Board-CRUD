package com.example.crud.dto;

import com.example.crud.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String writerName;
    private String title;
    private String contents;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.writerName = board.getWriterName();
        this.title = board.getTitle();
        this.contents = board.getContents();
    }
}
