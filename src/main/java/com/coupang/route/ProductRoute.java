package com.coupang.route;

import com.coupang.datamodel.dto.ProductDTO;
import com.coupang.repository.ProductRepository;
import com.coupang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRoute {
    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable (value = "productId") String productId) throws Exception{
        return this.productService.productById(productId);
    }

    @GetMapping("/initializeProducts")
    public void initializeProducts() {
        this.productService.initializeProducts();
    }

    @GetMapping("/gender")
    public void recommandGender() {}

}
