package br.imd.distprog.inventorymanagement.dto.product;

import br.imd.distprog.inventorymanagement.model.Location;
import br.imd.distprog.inventorymanagement.model.Vendor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class ProductPutRequestBody {

    private Long id;

    private String name;

    @NotNull
    private Location location;

    @NotNull
    private Vendor vendor;

    private BigDecimal price;
}
