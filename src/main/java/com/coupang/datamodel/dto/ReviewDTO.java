package com.coupang.datamodel.dto;

import com.coupang.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {

    private String userId;
    private String productId;

    public ReviewDTO(Review review) {
        this.userId = review.getUserId();
        this.productId = review.getProductId();
    }

    @Override
    public String toString() {
        return String.format(
                "Review[userId='%s',productId='%s']",
                this.userId, this.productId
        );
    }
}
