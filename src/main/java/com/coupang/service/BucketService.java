package com.coupang.service;

import com.coupang.datamodel.dto.BucketDTO;
import com.coupang.model.Bucket;
import com.coupang.repository.BucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BucketService {
    private final BucketRepository bucketRepository;

    @Autowired
    public BucketService(BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }

    public BucketDTO userById(String userId) throws Exception {
        return new BucketDTO(this.bucketRepository.findById(userId)
        .orElseThrow(()-> new Exception("해당유저에 유저가 없습니다")));
    }

    public void initializeBucket() {
        Bucket bucket1 = Bucket.builder()
                .userId("park")
                .productId("휴대폰")
                .productCount(2)
                .build();
        Bucket bucket2 = Bucket.builder()
                .userId("gun")
                .productId("컴퓨터")
                .productCount(5)
                .build();
        Bucket bucket3 = Bucket.builder()
                .userId("woo")
                .productId("노트북")
                .productCount(1)
                .build();

        this.bucketRepository.save(bucket1);
        this.bucketRepository.save(bucket2);
        this.bucketRepository.save(bucket3);
        this.bucketRepository.flush();

    }
}
