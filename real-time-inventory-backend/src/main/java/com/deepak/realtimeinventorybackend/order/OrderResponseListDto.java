package com.deepak.realtimeinventorybackend.order;

import com.deepak.realtimeinventorybackend.inventory.StockResponseDto;
import lombok.Data;

import java.util.List;
@Data
public class OrderResponseListDto {
    private List<OrderResponseDto> orders;
    private  Long total;
}
