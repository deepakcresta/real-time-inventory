package com.deepak.realtimeinventorybackend.inventory;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data

@Table(name = "inventory_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String stockName;
    private String category;
    private Instant createAt;
    private Instant modifiedAt;
    private String expiryDate;
    private String manufacturingDat;
    private String brandName;


}
