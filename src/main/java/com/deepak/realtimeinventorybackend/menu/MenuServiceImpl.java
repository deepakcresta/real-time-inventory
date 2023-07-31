package com.deepak.realtimeinventorybackend.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    public MenuRepository menuRepository;

    @Override
    public MenuCreateDto addMenu(MenuCreateDto menuCreateDto) {
        Menu menu = new Menu();

        menu.setMenuName(menuCreateDto.getMenuName());
        menu.setMenuType(menuCreateDto.getMenuName());
        menu.setCreatedDate(java.time.Instant.now());
        menu.setModifiedDate(java.time.Instant.now());

        Menu saveMenu = menuRepository.save(menu);
        return menuCreateDto;
    }

    public MenuResponseDto getMenuResponseDto(Menu savedMenu) {
        MenuResponseDto response = new MenuResponseDto();
        response.setMenuName(savedMenu.getMenuName());
        response.setCreatedDate(java.time.Instant.now());
        response.setModifiedDate(java.time.Instant.now());
        response.setMenuType(savedMenu.getMenuType());
        return response;
    }

    @Override
    public MenuListDto getAll() {
        List<MenuResponseDto> menuList = new ArrayList<>();
        List<Menu> menu = (List<Menu>) menuRepository.findAll();
        for (Menu menus : menu) {
            menuList.add(getMenuResponseDto(menus));
        }
        MenuListDto response = new MenuListDto();
        response.setMenus(menuList);
        response.setTotal((long) menu.size());
        return response;
    }

}
