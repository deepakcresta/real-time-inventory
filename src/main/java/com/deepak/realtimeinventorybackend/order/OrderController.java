package com.deepak.realtimeinventorybackend.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity addOrder(@RequestBody OrderCreateDto orderCreateDto) {
        orderService.addOrder(orderCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public OrderResponseListDto getAll() {
        return orderService.getAll();

    }
}
