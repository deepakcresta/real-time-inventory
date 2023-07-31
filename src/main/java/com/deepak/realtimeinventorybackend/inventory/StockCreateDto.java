package com.deepak.realtimeinventorybackend.inventory;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class StockCreateDto {
    private Long id;
    private Integer quantity;
    private String stockName;
    private String category;
    private Instant createAt;
    private Instant modifiedAt;
    private Instant expiryDate;
    private String manufacturingDat;
    private String brandName;

}
