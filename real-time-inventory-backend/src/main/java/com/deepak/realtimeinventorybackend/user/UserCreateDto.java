package com.deepak.realtimeinventorybackend.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    private Long id;
    private String userName;
    private String password;
    private String createAt;
    private String modifiedAt;
}
