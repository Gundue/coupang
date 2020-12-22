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
public class Review {
    @Id
    @Column(length = 20, nullable = false)
    private String userId;
    @Column(length = 40, nullable = false)
    private String productId;

    @Builder
    public Review(String userId, String productId) {
        this.userId = userId;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return String.format(
                "Review[userId='%s',productId='%s']",
                this.userId, this.productId
        );
    }
}
