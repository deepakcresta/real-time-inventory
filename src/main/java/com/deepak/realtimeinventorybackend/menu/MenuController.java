package com.deepak.realtimeinventorybackend.menu;

import com.deepak.realtimeinventorybackend.contact.ContactResponseListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu")
@CrossOrigin(origins = "*")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MenuCreateDto addMenu(@RequestBody MenuCreateDto menuCreateDto) {
        return menuService.addMenu(menuCreateDto);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public MenuListDto getAll() {
        return menuService.getAll();
    }


}
