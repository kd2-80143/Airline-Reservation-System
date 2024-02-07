package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDTO;
import com.app.service.CustomerService;



@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	// 1. Add new customer
	@PostMapping
	public ResponseEntity<?> addNewCustomer(@RequestBody @Valid CustomerDTO dto)
	{
		System.out.println(" in add customer" + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addNewEmployee(dto));
	}
	
	// 2. Delete Customer
	@DeleteMapping("/{custId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long custId)
	{
		System.out.println("in delete customer " + custId);
		return ResponseEntity.ok(customerService.deleteCustDetails(custId));
	}
	
	// 3. Edit Customer
	
	// 4. Get Customer Details
	
	// 5. Get all Customer Details
}
