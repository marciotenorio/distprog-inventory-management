package br.imd.distprog.inventorymanagement.service;

import br.imd.distprog.inventorymanagement.dto.location.LocationMapper;
import br.imd.distprog.inventorymanagement.dto.location.LocationPostRequestBody;
import br.imd.distprog.inventorymanagement.dto.location.LocationPutRequestBody;
import br.imd.distprog.inventorymanagement.exception.BadRequestException;
import br.imd.distprog.inventorymanagement.model.Location;
import br.imd.distprog.inventorymanagement.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location save(LocationPostRequestBody locationPostRequestBody) {
        Location location = LocationMapper.INSTANCE.postRequestBodyToLocation(locationPostRequestBody);
        return locationRepository.save(location);
    }

    public void deleteById(Long id) {
        findByIdOrThrowBadRequestException(id);
        locationRepository.deleteById(id);
    }

    public void replace(LocationPutRequestBody locationPutRequestBody) {
        Location incomingLocation = findByIdOrThrowBadRequestException(locationPutRequestBody.getId());
        Location location = LocationMapper.INSTANCE.putRequestBodyToLocation(locationPutRequestBody);
        location.setId(incomingLocation.getId());
        locationRepository.save(location);
    }

    public Location findByIdOrThrowBadRequestException(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Location not found!"));
    }
}
