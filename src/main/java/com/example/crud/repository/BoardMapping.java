package com.example.crud.repository;

import java.time.LocalDateTime;

public interface BoardMapping {
    //String getId();
    String getWriterName();
    String getTitle();
    String getContents();
    LocalDateTime getCreatedAt();

}
