package com.coupang.route;

import com.coupang.datamodel.dto.BucketDTO;
import com.coupang.datamodel.dto.ReviewDTO;
import com.coupang.datamodel.dto.SaleDTO;
import com.coupang.datamodel.dto.UserDTO;
import com.coupang.model.Bucket;
import com.coupang.service.BucketService;
import com.coupang.service.ReviewService;
import com.coupang.service.SaleService;
import com.coupang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRoute {
    private final UserService userService;
    private final SaleService saleService;
    private final BucketService bucketService;
    private final ReviewService reviewService;

    @Autowired
    public UserRoute(UserService userService, SaleService saleService, BucketService bucketService, ReviewService reviewService) {
        this.userService = userService;
        this.saleService = saleService;
        this.bucketService = bucketService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public UserDTO getUser(@PathVariable(value = "userId") String userId) throws Exception{
        return this.userService.userById(userId);
    }
    @GetMapping("/initialize")
    public void initialize() {
        this.userService.initialize();
    }

    @GetMapping("/{userId}/salelist")
    public SaleDTO getSalelist(@PathVariable(value = "userId") String userId) throws Exception{
        return this.saleService.userById(userId);
    }

    @GetMapping("/initializeSales")
    public void initializeSales() {
        this.saleService.initializeSales();
    }

    @GetMapping("/{userId}/totalprice")
    public SaleDTO getTotalprice(@PathVariable(value = "userId") String userId) throws Exception{
        return this.saleService.getTotalAmountByUser(Integer.parseInt(userId));
    }

    @GetMapping("/{userId}/bucketlist")
    public BucketDTO getBucket(@PathVariable (value = "userId") String userId) throws Exception{
        return this.bucketService.userById(userId);
    }

    @GetMapping("/initializeBucket")
    public void initializeBucket() {
        this.bucketService.initializeBucket();
    }

    @GetMapping("/{userId}/review")
    public ReviewDTO getReview(@PathVariable (value = "userId") String userId) throws Exception{
        return this.reviewService.userById(userId);
    }

    @GetMapping("/initializeReview")
    public void initializeReview() {
        this.reviewService.initializeReview();
    }

}
