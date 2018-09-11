package com.bookingsystem.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bookingsystem.model.RoomBook;
import com.bookingsystem.model.RoomDetails;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bookingsystem.repository")
@EntityScan(basePackages = "com.bookingsystem.model")
public class BookingSystemAPI {

	@Autowired
	private BookingSystemService bookingSystemService;

	/*
	 * @RequestMapping(value = "/test", method = RequestMethod.GET) public
	 * String test() {
	 * 
	 * String st=bookingSystemService.test(); return st;
	 * 
	 * }
	 */

	@RequestMapping(value = "/get/allBookingsBy/roomId", method = RequestMethod.GET)
	public ResponseEntity<List<RoomBook>> getAllBookingsForRoomId(@FormParam(value = "roomId") Long roomId) {
		List<RoomBook> bookings = new ArrayList<RoomBook>();
		bookings = bookingSystemService.getAllBookingsForRoomId((long) 10);
		return ResponseEntity.accepted().body(bookings);

	}

	@RequestMapping(value = "/get/allBookingsBy/customerId", method = RequestMethod.GET)
	public ResponseEntity<List<RoomBook>> getAllBookingsForCustomerId(
			@FormParam(value = "customerId") Long customerId) {
		List<RoomBook> bookings = new ArrayList<RoomBook>();
		bookings = bookingSystemService.getAllBookingsForCustomerId((long) 201);
		return ResponseEntity.accepted().body(bookings);

	}

	@RequestMapping(value = "/get/availabilityOfRoomBy/roomId", method = RequestMethod.GET)
	public ResponseEntity<RoomDetails> getAvailabilityOfRoomByRoomId(@FormParam(value = "roomId") Long roomId,
			@FormParam(value = "dateFrom") Date dateFrom, @FormParam(value = "dateTo") Date dateTo) {
		RoomDetails roomDet = new RoomDetails();
		//Long longDate = 20180201110400L;
		dateFrom=new Date(1504828800000L); 
		dateTo=new Date(1505001600000L); 
		roomDet = bookingSystemService.checkAvailabilityOfRoomWithinDateRange((long) 10, dateFrom, dateTo);
		return ResponseEntity.accepted().body(roomDet);

	}

	public static void main(String[] args) {
		SpringApplication.run(BookingSystemAPI.class, args);

	}

}
