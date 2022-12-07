package br.imd.distprog.inventorymanagement.service;

import br.imd.distprog.inventorymanagement.dto.product.ProductMapper;
import br.imd.distprog.inventorymanagement.dto.product.ProductPostRequestBody;
import br.imd.distprog.inventorymanagement.dto.product.ProductPutRequestBody;
import br.imd.distprog.inventorymanagement.exception.BadRequestException;
import br.imd.distprog.inventorymanagement.exception.InvalidFieldsException;
import br.imd.distprog.inventorymanagement.model.Location;
import br.imd.distprog.inventorymanagement.model.Product;
import br.imd.distprog.inventorymanagement.model.Vendor;
import br.imd.distprog.inventorymanagement.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private LocationService locationService;

    private VendorService vendorService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(ProductPostRequestBody productPostRequestBody) {
        Location location = locationService.findByIdOrThrowBadRequestException(
                productPostRequestBody.getLocationId());
        Vendor vendor = vendorService.findByIdOrThrowBadRequestException(
                productPostRequestBody.getVendorId());
        Product product = ProductMapper.INSTANCE.postRequestBodyToProduct(productPostRequestBody);

        product.setLocation(location);
        product.setVendor(vendor);

        if(!vendor.isApproved()){
            throw new InvalidFieldsException("This vendor is not approved!");
        }

        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        findByIdOrThrowBadRequestException(id);
        productRepository.deleteById(id);
    }

    public void replace(ProductPutRequestBody productPutRequestBody) {
        Product incomingProduct = findByIdOrThrowBadRequestException(productPutRequestBody.getId());
        Product product = ProductMapper.INSTANCE.putRequestBodyToProduct(productPutRequestBody);
        product.setId(incomingProduct.getId());
        productRepository.save(product);
    }

    public Product findByIdOrThrowBadRequestException(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Product not found!"));
    }
}
