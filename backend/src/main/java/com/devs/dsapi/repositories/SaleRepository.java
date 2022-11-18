package com.devs.dsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.dsapi.entities.Sales;

public interface SaleRepository extends JpaRepository<Sales, Long> {
	

}
