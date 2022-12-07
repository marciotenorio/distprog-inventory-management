package br.imd.distprog.inventorymanagement.dto.location;

import br.imd.distprog.inventorymanagement.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location postRequestBodyToLocation(LocationPostRequestBody locationPostRequestBody);

    Location putRequestBodyToLocation(LocationPutRequestBody locationPutRequestBody);
}
