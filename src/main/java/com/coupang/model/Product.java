package com.coupang.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @Column(length = 40, nullable = false)
    private String productId;
    @Column(length = 10, nullable = false)
    private int productPay;
    @Column(length = 40, nullable = false)
    private String productType;
    @Column(length = 40, nullable = false)
    private int productNumber;

    @Builder
    public Product(String productId, int productPay, String productType, int productNumber) {
        this.productId = productId;
        this.productPay = productPay;
        this.productType = productType;
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[productId='%s', productPay=%d, productType='%s', productNumber=%d]",
                this.productId, this.productPay, this.productType, this.productNumber
        );
    }
}
