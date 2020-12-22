package com.coupang.route;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRoute {

    @GetMapping("/{userId}")
    public void getUser(@PathVariable(value = "userId") String userId) {}

    @GetMapping("/{userId}/salelist")
    public void getSalelist(@PathVariable(value = "userId") String userId) {}

    @GetMapping("/{userId}/totalprice")
    public void getTotalprice(@PathVariable(value = "userId") String userId) {}

    @GetMapping("/{userId}/bucketlist")
    public void getBucket(@PathVariable (value = "userId") String userId) {}

    @GetMapping("/{userId}/review")
    public void getReview(@PathVariable (value = "userId") String userId) {}
}
