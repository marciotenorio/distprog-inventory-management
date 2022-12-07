package br.imd.distprog.inventorymanagement.model;


import br.imd.distprog.inventorymanagement.util.DBSchema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "product", schema = DBSchema.INVENTORY_MANAGEMENT_SCHEMA)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @NotNull
    private Location location;

    @OneToOne
    @NotNull
    private Vendor vendor;

    private BigDecimal price;
}
