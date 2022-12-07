package br.imd.distprog.inventorymanagement.dto.product;

import br.imd.distprog.inventorymanagement.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product postRequestBodyToProduct(ProductPostRequestBody productPostRequestBody);

    Product putRequestBodyToProduct(ProductPutRequestBody productPutRequestBody);
}
