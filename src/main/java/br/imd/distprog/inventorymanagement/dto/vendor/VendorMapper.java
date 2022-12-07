package br.imd.distprog.inventorymanagement.dto.vendor;

import br.imd.distprog.inventorymanagement.model.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    Vendor postRequestBodyToVendor(VendorPostRequestBody vendorPostRequestBody);

    Vendor putRequestBodyToVendor(VendorPutRequestBody vendorPutRequestBody);
}
