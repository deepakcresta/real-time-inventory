package com.deepak.realtimeinventorybackend.inventory;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        stock.setQuantityUnit(stockCreateDto.getQuantityUnit());
        stock.setManufacturingDate(stockCreateDto.getManufacturingDate());
        stock.setExpiryDate(stockCreateDto.getExpiryDate());
        stock.setBrandName(stockCreateDto.getBrandName());



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
        responseDto.setManufacturingDate(savedStock.getManufacturingDate());
        responseDto.setBrandName(savedStock.getBrandName());
        responseDto.setCreateAt(java.time.Instant.now());
        responseDto.setModifiedAt(java.time.Instant.now());
        responseDto.setQuantityUnit(savedStock.getQuantityUnit());
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

    public Stock update(Long id, StockUpdateDto stockCreateDto) {
        Optional<Stock> optional = stockRepository.findById(id);
        if (optional.isPresent()) {
            Stock stock = optional.get();
            stock.setBrandName(stockCreateDto.getBrandName());
            stock.setCategory(stockCreateDto.getCategory());
            stock.setStockName(stockCreateDto.getStockName());
            stock.setQuantity(stockCreateDto.getQuantity());
            stock.setExpiryDate(stockCreateDto.getExpiryDate());
            stock.setManufacturingDate(stockCreateDto.getManufacturingDate());
            stock.setModifiedAt(java.time.Instant.now());
            stock.setQuantityUnit(stockCreateDto.getQuantityUnit());
            return stockRepository.save(stock);
        }
        return null;
    }



    @Transactional
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

}
