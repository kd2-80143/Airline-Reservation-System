package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ReservationDTO;
import com.app.service.ReservationService;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

	@Autowired
	private ReservationService rService;
	
	//Add Booking
	@PostMapping
	public ResponseEntity<?> addNewBooking(@RequestBody ReservationDTO rdto)
	{
		System.out.println("Reserv Controller : "+rdto);
		return ResponseEntity.status(HttpStatus.CREATED).body(rService.addNewBooking(rdto));
	}
	
	
	//Update Booking
	@PutMapping("{id}")
	public ResponseEntity<?> updateBooking(@PathVariable Long id, @RequestBody ReservationDTO rdto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(rService.updateBooking(id,rdto));
	}
	
	//Cancel Booking
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(rService.deleteBooking(id));
	}
	
	// Method to update payment status from NA to Completed
    @PostMapping("/{reservationId}/updatePaymentStatus")
    public ResponseEntity<String> updatePaymentStatus(@PathVariable Long reservationId) {
        // Call the service layer to update the payment status
        boolean updated = rService.updatePaymentStatus(reservationId);
        if (updated) {
            return new ResponseEntity<>("Payment status updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update payment status", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
