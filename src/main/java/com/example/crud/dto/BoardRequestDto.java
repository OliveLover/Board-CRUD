package com.example.crud.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String userName;
    private String title;
    private String contents;
    private String password;
}
