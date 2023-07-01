package com.deepak.realtimeinventorybackend.stock_sales;
import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table(name = "inventory_sale")
public class Sale{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String stockName;
    private String category;
    private String createAt;
    private String modifiedAt;

}
