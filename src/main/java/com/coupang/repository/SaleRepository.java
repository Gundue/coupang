package com.coupang.repository;

import com.coupang.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {
    public List<Sale> findByUserId(String userId);
}
