package br.imd.distprog.inventorymanagement.dto.location;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationPutRequestBody {

    private Long id;

    private String country;

    private String state;

    private String city;

    private String street;

    private int number;
}
