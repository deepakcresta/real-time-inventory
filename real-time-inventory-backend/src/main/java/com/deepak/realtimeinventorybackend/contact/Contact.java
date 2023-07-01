package com.deepak.realtimeinventorybackend.contact;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "contact-us")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    private String message;

}