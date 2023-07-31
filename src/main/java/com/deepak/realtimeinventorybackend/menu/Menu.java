package com.deepak.realtimeinventorybackend.menu;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menuName;
    private Instant createdDate;
    private Instant modifiedDate;

//    @OneToMany(mappedBy = "menus")
//    private List<MenuCredential> menuCredentials;
}
