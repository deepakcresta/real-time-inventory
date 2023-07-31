package com.deepak.realtimeinventorybackend.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity addStock (@RequestBody StockCreateDto stockCreateDto){
        stockService.addStock(stockCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public StockResponseListDto getAll(){

        return  stockService.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public  StockResponseDto getById(@PathVariable ("id") Long id){
        return  stockService.getById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code =  HttpStatus.NO_CONTENT)
    public void deleteStock(@PathVariable("id")Long id){
        stockService.deleteStock(id);
    }
    //Updating the stock
    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public  Stock update(@PathVariable Long id, @RequestBody StockUpdateDto request){
        return stockService.update(id, request);
    }

}
