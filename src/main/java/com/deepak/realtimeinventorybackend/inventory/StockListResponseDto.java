package com.deepak.realtimeinventorybackend.inventory;

import lombok.Data;

import java.util.List;
@Data
public class StockListResponseDto {
    private  List<StockResponseDto> stocks;
     private int total;
}
