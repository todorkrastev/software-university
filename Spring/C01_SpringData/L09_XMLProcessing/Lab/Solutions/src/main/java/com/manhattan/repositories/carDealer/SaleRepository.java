package com.manhattan.repositories.carDealer;

import com.manhattan.models.carDealer.dtos.SalesDiscountsDto;
import com.manhattan.models.carDealer.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT " +
            "NEW com.manhattan.models.carDealer.dtos" +
            ".SalesDiscountsDto(ca.make, ca.model, ca.travelledDistance, " +
            "cu.name, s.discountPercentage, SUM(pa.price), cu.youngerDriver)" +
            "FROM Sale s JOIN s.customer cu " +
            "JOIN s.car ca " +
            "JOIN ca.parts pa " +
            "GROUP BY ca")
    List<SalesDiscountsDto> findAllWithDiscounts();
}
