package com.coupang.service;

import com.coupang.datamodel.dto.ProductDTO;
import com.coupang.model.Product;
import com.coupang.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO productById(String productId) throws Exception{
        return new ProductDTO(this.productRepository.findById(productId)
        .orElseThrow(()-> new Exception("해당 상품없음")));
    }

    public void initializeProducts() {
        Product product1 = Product.builder()
                .productId("감자")
                .productPay(100000)
                .productType("식품")
                .productNumber(2)
                .build();
        Product product2 = Product.builder()
                .productId("충전기")
                .productPay(5000)
                .productType("전자제품")
                .productNumber(5)
                .build();

        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.flush();
    }
}
