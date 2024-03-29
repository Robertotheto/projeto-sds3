package com.devsuperoior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperoior.dsvendas.dto.SaleSucessDTO;
import com.devsuperoior.dsvendas.dto.SaleSumDTO;
import com.devsuperoior.dsvendas.entities.Sale;



public interface SaleRepository extends JpaRepository<Sale,Long> {
	
	@Query("SELECT new com.devsuperoior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperoior.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> sucessGroupedBySeller();
}
