package com.coupang.service;

import com.coupang.datamodel.dto.SaleDTO;
import com.coupang.model.Sale;
import com.coupang.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SaleService {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public SaleDTO userById(String userId) throws Exception {
        return new SaleDTO(this.saleRepository.findById(userId)
        .orElseThrow(()-> new Exception("해당유저에 유저가 없습니다")));
    }

    public void initializeSales() {
        Sale sale1 = Sale.builder()
                .userId("park")
                .productId("장난감 기차")
                .productPay(1000)
                .build();
        Sale sale2 = Sale.builder()
                .userId("gun")
                .productId("칙칙폭폭")
                .productPay(2000)
                .build();
        Sale sale3 = Sale.builder()
                .userId("woo")
                .productId("땡땡")
                .productPay(3000)
                .build();

        this.saleRepository.save(sale1);
        this.saleRepository.save(sale2);
        this.saleRepository.save(sale3);
        this.saleRepository.flush();

    }
    public int getTotalAmountByUser(String userId) {
        List<Sale> sales = this.saleRepository.findByUserId(userId);
        int totalAmount = 0;
        for(Sale sale:sales) {
            totalAmount = totalAmount + sale.getProductPay();
        }
        return totalAmount;
    }
}
