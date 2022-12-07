package br.imd.distprog.inventorymanagement.dto.vendor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendorPostRequestBody {

    private String name;

    private String type;

    private boolean isApproved;
}
