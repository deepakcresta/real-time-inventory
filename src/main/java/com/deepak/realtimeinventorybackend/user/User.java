package com.deepak.realtimeinventorybackend.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String createAt;
    private String modifiedAt;
}