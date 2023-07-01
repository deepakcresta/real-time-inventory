package com.deepak.realtimeinventorybackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    @ResponseStatus(code =  HttpStatus.OK)
    public  UserResponseDto addUser(@RequestBody UserCreateDto userCreateDto){
        return  userService.addUser(userCreateDto);
    }


}
