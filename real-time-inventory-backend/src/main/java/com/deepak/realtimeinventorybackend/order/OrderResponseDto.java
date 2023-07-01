package com.deepak.realtimeinventorybackend.order;

import lombok.Data;

import java.time.Instant;
@Data
public class OrderResponseDto {
    private Long id;
    private String tableNumber;
    private String orderName;
    private Long quantity;
    private Instant orderTime;
    private String orderType;
}
