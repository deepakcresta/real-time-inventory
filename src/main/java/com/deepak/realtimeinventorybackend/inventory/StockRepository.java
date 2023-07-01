package com.deepak.realtimeinventorybackend.inventory;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository  extends CrudRepository<Stock, Long> {
}
