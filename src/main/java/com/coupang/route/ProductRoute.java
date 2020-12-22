package com.coupang.route;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRoute {

    @GetMapping("/{productId}")
    public void getProduct(@PathVariable (value = "productId") String productId) {}

    @GetMapping("/gender")
    public void recommandGender() {}

}
