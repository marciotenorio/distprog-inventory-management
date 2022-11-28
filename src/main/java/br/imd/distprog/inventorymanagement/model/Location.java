package br.imd.distprog.inventorymanagement.model;

import lombok.Data;

@Data
public class Location {

    private Long id;

    private String country;

    private String state;

    private String city;

    private String street;

    private int number;
}
