package br.imd.distprog.inventorymanagement.model;

import br.imd.distprog.inventorymanagement.util.DBSchema;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "location", schema = DBSchema.INVENTORY_MANAGEMENT_SCHEMA)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String state;

    private String city;

    private String street;

    private int number;
}
