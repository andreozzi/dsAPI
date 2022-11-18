package com.devs.dsapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs.dsapi.entities.Sales;
import com.devs.dsapi.repositories.SaleRepository;

@Service 
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	
	public List<Sales> findSales(){
		return repository.findAll();
		
	}

}
