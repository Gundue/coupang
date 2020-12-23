package com.coupang.datamodel.dto;

import com.coupang.model.Bucket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BucketDTO {

    private String userId;
    private String productId;
    private int productCount;

    public BucketDTO(Bucket bucket) {
        this.userId = bucket.getUserId();
        this.productId = bucket.getProductId();
        this.productCount = bucket.getProductCount();
    }

    @Override
    public String toString() {
        return String.format(
                "Bucket[userId='%s',productId='%s', productCount=%d]",
                this.userId, this.productId, this.productCount
        );
    }
}
