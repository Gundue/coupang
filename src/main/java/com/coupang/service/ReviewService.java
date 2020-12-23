package com.coupang.service;

import com.coupang.datamodel.dto.BucketDTO;
import com.coupang.datamodel.dto.ReviewDTO;
import com.coupang.model.Bucket;
import com.coupang.model.Review;
import com.coupang.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewDTO userById(String userId) throws Exception{
        return new ReviewDTO(this.reviewRepository.findById(userId)
        .orElseThrow(()-> new Exception("해당유저가 없습니다")));
    }

    public void initializeReview() {
        Review review1 = Review.builder()
                .userId("park")
                .productId("배게")
                .build();
        Review review2 = Review.builder()
                .userId("gun")
                .productId("이불")
                .build();

        this.reviewRepository.save(review1);
        this.reviewRepository.save(review2);
        this.reviewRepository.flush();
    }


}
