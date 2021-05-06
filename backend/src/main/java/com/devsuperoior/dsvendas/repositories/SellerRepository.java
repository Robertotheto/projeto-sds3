package com.devsuperoior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperoior.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long> {
	
}
