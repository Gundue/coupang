package com.coupang.datamodel.dto;

import com.coupang.model.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaleDTO {

    private String userId;
    private String productId;
    private int productPay;

    public SaleDTO(Sale sale) {
        this.userId = sale.getUserId();
        this.productId = sale.getProductId();
        this.productPay = sale.getProductPay();
    }

    @Override
    public String toString() {
        return String.format(
                "Sale[userId='%s', productId='%s', productPay=%d]" ,
                this.userId, this.productId, this.productPay
        );
    }
}
