package com.example.crud.entity;

import com.example.crud.dto.SignupRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;

    public User(SignupRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.password = requestDto.getPassword();
        this.email = requestDto.getEmail();
    }
}


//유저                    보드
//                          Id
//Id                       title
//userName            userName
//password             password
//                            contents

//@validatation
/*
일반적으로 게시판을 구현할 때는 User 엔티티와 Board 엔티티를 다음과 같이 구성하는 것이 일반적입니다.

User 엔티티:

id: 사용자 ID
name: 사용자 이름
email: 사용자 이메일
password: 사용자 비밀번호

Board 엔티티:

id: 게시글 ID
title: 게시글 제목
content: 게시글 내용
created_at: 게시글 작성일시
updated_at: 게시글 수정일시
author: 게시글 작성자 (User 엔티티와 연관)
즉, Board 엔티티에는 게시글의 제목, 내용, 작성일시, 수정일시,
작성자 정보가 포함됩니다. 그리고 작성자 정보는 User 엔티티와 연관되어 있습니다.
이러한 구조로 구성하면 게시글 작성자의 정보를 쉽게 가져올 수 있으며, 게시글 수정시 수정일시도
자동으로 갱신됩니다.
 */