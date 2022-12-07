package br.imd.distprog.inventorymanagement.controller;

import br.imd.distprog.inventorymanagement.dto.location.LocationPostRequestBody;
import br.imd.distprog.inventorymanagement.dto.location.LocationPutRequestBody;
import br.imd.distprog.inventorymanagement.model.Location;
import br.imd.distprog.inventorymanagement.service.LocationService;
import br.imd.distprog.inventorymanagement.util.Route;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Route.LOCATIONS)
@AllArgsConstructor
public class LocationController {

    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> findAll(){
        return ResponseEntity.ok(locationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> findById(@PathVariable Long id){
        return ResponseEntity.ok(locationService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody LocationPostRequestBody locationPostRequestBody){
        return new ResponseEntity<>(locationService.save(locationPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody LocationPutRequestBody locationPutRequestBody){
        locationService.replace(locationPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        locationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
