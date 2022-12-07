package br.imd.distprog.inventorymanagement.repository;

import br.imd.distprog.inventorymanagement.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
