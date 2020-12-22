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
public class Sale {
    @Id
    @Column(length = 20, nullable = false)
    private String userId;
    @Column(length = 40, nullable = false)
    private String productId;
    @Column(length = 20, nullable = false)
    private int productPay;

    @Builder
    public Sale(String userId, String productId, int productPay) {
        this.userId = userId;
        this.productId = productId;
        this.productPay = productPay;
    }

    @Override
    public String toString() {
        return String.format(
                "Sale[userId='%s', productId='%s', productPay=%d]" ,
                this.userId, this.productId, this.productPay
        );
    }
}
