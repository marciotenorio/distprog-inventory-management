package br.imd.distprog.inventorymanagement.service;

import br.imd.distprog.inventorymanagement.dto.vendor.VendorMapper;
import br.imd.distprog.inventorymanagement.dto.vendor.VendorPostRequestBody;
import br.imd.distprog.inventorymanagement.dto.vendor.VendorPutRequestBody;
import br.imd.distprog.inventorymanagement.exception.BadRequestException;
import br.imd.distprog.inventorymanagement.model.Vendor;
import br.imd.distprog.inventorymanagement.repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendorService {

    private VendorRepository vendorRepository;

    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Vendor save(VendorPostRequestBody vendorPostRequestBody) {
        Vendor vendor = VendorMapper.INSTANCE.postRequestBodyToVendor(vendorPostRequestBody);
        return vendorRepository.save(vendor);
    }

    public void deleteById(Long id) {
        findByIdOrThrowBadRequestException(id);
        vendorRepository.deleteById(id);
    }

    public void replace(VendorPutRequestBody vendorPutRequestBody) {
        Vendor incomingVendor = findByIdOrThrowBadRequestException(vendorPutRequestBody.getId());
        Vendor vendor = VendorMapper.INSTANCE.putRequestBodyToVendor(vendorPutRequestBody);
        vendor.setId(incomingVendor.getId());
        vendorRepository.save(vendor);
    }

    public Vendor findByIdOrThrowBadRequestException(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Vendor not found!"));
    }

}
