package br.imd.distprog.inventorymanagement.model;

import br.imd.distprog.inventorymanagement.util.DBSchema;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "vendor", schema = DBSchema.INVENTORY_MANAGEMENT_SCHEMA)
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private VendorType type;

    private boolean isApproved;
}
