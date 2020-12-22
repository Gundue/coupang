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
public class Bucket {
    @Id
    @Column(length = 20, nullable = false)
    private String userId;
    @Column(length = 40, nullable = false)
    private String productId;
    @Column(length = 10, nullable = false)
    private int productCount;

    @Builder
    public Bucket(String userId, String productId, int productCount) {
        this.userId = userId;
        this.productId = productId;
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return String.format(
                "Bucket[userId='%s',productId='%s', productCount=%d]",
                this.userId, this.productId, this.productCount
        );
    }
}
