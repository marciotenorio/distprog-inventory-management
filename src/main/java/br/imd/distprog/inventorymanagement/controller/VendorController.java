package br.imd.distprog.inventorymanagement.controller;

import br.imd.distprog.inventorymanagement.dto.vendor.VendorPostRequestBody;
import br.imd.distprog.inventorymanagement.dto.vendor.VendorPutRequestBody;
import br.imd.distprog.inventorymanagement.model.Location;
import br.imd.distprog.inventorymanagement.model.Vendor;
import br.imd.distprog.inventorymanagement.service.VendorService;
import br.imd.distprog.inventorymanagement.util.Route;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Route.VENDORS)
@AllArgsConstructor
public class VendorController {

    private VendorService vendorService;

    @GetMapping
    public ResponseEntity<List<Vendor>> findAll(){
        return ResponseEntity.ok(vendorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> findById(@PathVariable Long id){
        return ResponseEntity.ok(vendorService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Vendor> save(@RequestBody VendorPostRequestBody vendorPostRequestBody){
        return new ResponseEntity<>(vendorService.save(vendorPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody VendorPutRequestBody vendorPutRequestBody){
        vendorService.replace(vendorPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        vendorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
