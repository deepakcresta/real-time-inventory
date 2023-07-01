package com.deepak.realtimeinventorybackend.inventory;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter

public class StockResponseListDto {
        private List<StockResponseDto>stocks;
        private  Long total;
}
