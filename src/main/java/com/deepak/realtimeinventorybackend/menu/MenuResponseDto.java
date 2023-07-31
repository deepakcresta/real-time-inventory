package com.deepak.realtimeinventorybackend.menu;

import lombok.Data;

import java.time.Instant;

@Data
public class MenuResponseDto {
    private Long id;
    private String menuName;
    private Instant createdDate;
    private Instant modifiedDate;
    private String menuType;
}

