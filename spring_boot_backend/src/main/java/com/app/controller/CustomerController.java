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

import com.app.dto.ApiResponse;
import com.app.dto.CustomerDTO;


import com.app.dto.LoginDTO;
import com.app.service.CustomerService;
import com.app.service.LoginService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;

	@Autowired
	private LoginService loginservice;

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

	@PostMapping("/login")
	public ResponseEntity<?> checkLoginDetails(@RequestBody LoginDTO ldto)
	{
		System.out.println("in login "+ldto);
		return ResponseEntity.ok(loginservice.checkLoginDetails(ldto));
	}

	@PostMapping("/otpviaEmail")
	public ApiResponse sendOtpToEmail(@RequestBody String email)
	{
		return  customerService.sendOtpToMailService(email);
	}

}
