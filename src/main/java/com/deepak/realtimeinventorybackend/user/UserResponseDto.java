package com.deepak.realtimeinventorybackend.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {
    private Long id;
    private String userName;
    private String password;
    private String createAt;
    private String modifiedAt;

}
