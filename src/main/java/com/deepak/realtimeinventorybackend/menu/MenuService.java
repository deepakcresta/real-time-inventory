package com.deepak.realtimeinventorybackend.menu;

public interface MenuService {
    MenuCreateDto addMenu(MenuCreateDto menuCreateDto);

    MenuListDto getAll();
}
