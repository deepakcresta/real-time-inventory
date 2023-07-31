package com.deepak.realtimeinventorybackend.inventory;

import lombok.Data;

public class StockUpdateDto  extends  StockCreateDto{
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
