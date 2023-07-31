package com.deepak.realtimeinventorybackend.menu;

import lombok.Data;

import java.util.List;

@Data
public class MenuListDto {
    private List<MenuResponseDto> menus;
    private Long total;

}
