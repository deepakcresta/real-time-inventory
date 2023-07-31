//package com.deepak.realtimeinventorybackend.menuCredentaials;
//
//import com.deepak.realtimeinventorybackend.menu.Menu;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.Instant;
//@Data
//public class MenuCredential {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String credentialName;
//    private Long quantity;
//    private String unit;
//    private Instant createdDate;
//    private Instant modifiedDate;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "menu_id")
//    private Menu menu;
//
//
//}
