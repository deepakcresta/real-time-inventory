package com.deepak.realtimeinventorybackend.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactCreateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String phoneNumber;

    private String email;

    private String message;

}
