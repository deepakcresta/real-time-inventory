package com.deepak.realtimeinventorybackend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(OrderCreateDto orderCreateDto) {
        Order order = new Order();
        order.setOrderName(orderCreateDto.getOrderName());
        order.setOrderType(orderCreateDto.getOrderType());
        order.setQuantity(orderCreateDto.getQuantity());
        order.setOrderTime(java.time.Instant.now());
        order.setTableNumber(orderCreateDto.getTableNumber());

        Order saveOrder = orderRepository.save(order);
    }

    public OrderResponseDto getOrderResponseDto(Order saveOrder) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderName(saveOrder.getOrderName());
        orderResponseDto.setOrderType(saveOrder.getOrderType());
        orderResponseDto.setTableNumber(saveOrder.getTableNumber());
        orderResponseDto.setQuantity(saveOrder.getQuantity());
        orderResponseDto.setOrderTime(java.time.Instant.now());
        return orderResponseDto;
    }


    public OrderResponseListDto getAll() {
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        List<Order> order = (List<Order>) orderRepository.findAll();

        for (Order orders : order) {
            orderResponseDtoList.add(getOrderResponseDto(orders));
        }
        OrderResponseListDto response = new OrderResponseListDto();
        response.setOrders(orderResponseDtoList);
        response.setTotal((long) order.size());

        return response;
    }

}



