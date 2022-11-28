package br.imd.distprog.inventorymanagement.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Long id;

    private String name;

    private Location location;

    private BigDecimal price;
}
