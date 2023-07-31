package com.deepak.realtimeinventorybackend.inventory;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class StockResponseDto {
    private Long id;
    private Integer quantity;
    private String stockName;
    private String category;
    private Instant createAt;
    private Instant modifiedAt;
    private String expiryDate;
    private String manufacturingDate;
    private String brandName;
    private String quantityUnit;

}
