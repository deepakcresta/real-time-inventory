package com.deepak.realtimeinventorybackend.order;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data

@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableNumber;
    private String orderName;
    private Long quantity;
    private Instant orderTime;
    private String orderType;
}