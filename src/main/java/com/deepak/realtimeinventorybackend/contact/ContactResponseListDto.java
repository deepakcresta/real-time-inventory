package com.deepak.realtimeinventorybackend.contact;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContactResponseListDto {
    private List<ContactResponseDto> contacts;

    private Long total;

}
