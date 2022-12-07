package br.imd.distprog.inventorymanagement.controller;


import br.imd.distprog.inventorymanagement.dto.product.ProductPostRequestBody;
import br.imd.distprog.inventorymanagement.dto.product.ProductPutRequestBody;
import br.imd.distprog.inventorymanagement.model.Product;
import br.imd.distprog.inventorymanagement.service.ProductService;
import br.imd.distprog.inventorymanagement.util.Route;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Route.PRODUCTS)
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid ProductPostRequestBody productPostRequestBody){
        return new ResponseEntity<>(productService.save(productPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ProductPutRequestBody productPutRequestBody){
        productService.replace(productPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
