package com.deepak.realtimeinventorybackend.menu;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class MenuCreateDto {
    private Long id;
    private String menuName;
    private Instant createdDate;
    private Instant modifiedDate;
    private String menuType;
//    private String credentialName;
//    private  Long quantity;
//    private List<MenuCredentialDto> menuCredentials;
}
