package br.imd.distprog.inventorymanagement.repository;

import br.imd.distprog.inventorymanagement.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
