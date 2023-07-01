package com.deepak.realtimeinventorybackend.inventory;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    public StockRepository stockRepository;

    public void addStock(StockCreateDto stockCreateDto) {
        Stock stock = new Stock();

        stock.setStockName(stockCreateDto.getStockName());
        stock.setCategory(stockCreateDto.getCategory());
        stock.setQuantity(stockCreateDto.getQuantity());
        stock.setCreateAt(java.time.Instant.now());
        stock.setModifiedAt(java.time.Instant.now());


        Stock savedStock = stockRepository.save(stock);
//        StockResponseDto responseDto = new StockResponseDto();
//        responseDto.setCategory(savedStock.getCategory());
//        responseDto.setStockName(savedStock.getStockName());
//        responseDto.setQuantity(savedStock.getQuantity());
//        responseDto.setCreateAt(savedStock.getCreateAt());
//        responseDto.setModifiedAt(savedStock.getModifiedAt());
//        return responseDto;
    }

    public StockResponseDto getStockResponseDto(Stock savedStock) {
        StockResponseDto responseDto = new StockResponseDto();
        responseDto.setId(savedStock.getId());
        responseDto.setStockName(savedStock.getStockName());
        responseDto.setCategory(savedStock.getCategory());
        responseDto.setQuantity(savedStock.getQuantity());
        responseDto.setExpiryDate(savedStock.getExpiryDate());
        responseDto.setManufacturingDat(savedStock.getManufacturingDat());
        responseDto.setBrandName(savedStock.getBrandName());
        responseDto.setCreateAt(savedStock.getCreateAt());
        responseDto.setCreateAt(java.time.Instant.now());
        return responseDto;
    }

    public StockResponseListDto getAll() {
        List<StockResponseDto> stockResponseDtoList = new ArrayList<>();
        List<Stock> stock = (List<Stock>) stockRepository.findAll();

        for (Stock stocks : stock) {
            stockResponseDtoList.add(getStockResponseDto(stocks));
        }
        StockResponseListDto response = new StockResponseListDto();
        response.setStocks(stockResponseDtoList);
        response.setTotal((long) stock.size());

        return response;
    }

    public StockResponseDto getById(Long id) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if (optionalStock.isPresent()) {
            return getStockResponseDto(optionalStock.get());
        }
        return null;
    }
    @Transactional
    public  void deleteStock(Long id){
        stockRepository.deleteById(id);
    }

}
