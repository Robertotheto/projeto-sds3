package com.devsuperoior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperoior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long> {
	
}
