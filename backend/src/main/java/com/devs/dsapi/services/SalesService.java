package com.devs.dsapi.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devs.dsapi.entities.Sales;
import com.devs.dsapi.repositories.SalesRespositories;

@Service
public class SalesService {
	
	@Autowired
	private SalesRespositories repositories;
	
	public Page<Sales> findSale(String minDate,String maxDate,Pageable pageable){
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate  min = minDate.equals("") ? today.minusDays(365) :  LocalDate.parse(minDate);
		LocalDate  max = maxDate.equals("") ? today :  LocalDate.parse(maxDate);
		
		
		return repositories.findSales(min, max, pageable);
		
	}
	}
	