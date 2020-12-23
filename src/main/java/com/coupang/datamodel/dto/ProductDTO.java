package com.coupang.datamodel.dto;

import com.coupang.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

    private String productId;
    private int productPay;
    private String productType;
    private int productNumber;

    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.productPay = product.getProductPay();
        this.productType = product.getProductType();
        this.productNumber = product.getProductNumber();
    }

    @Override
    public String toString() {
        return String.format(
                "Product[productId='%s', productPay=%d, productType='%s', productNumber=%d]",
                this.productId, this.productPay, this.productType, this.productNumber
        );
    }
}
