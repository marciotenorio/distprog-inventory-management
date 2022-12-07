package br.imd.distprog.inventorymanagement.dto.product;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class ProductPostRequestBody {

    private String name;

    @NotNull
    private Long locationId;

    @NotNull
    private Long vendorId;

    private BigDecimal price;
}
