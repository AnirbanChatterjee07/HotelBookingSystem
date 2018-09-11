package com.bookingsystem.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingsystem.model.Customer;
import com.bookingsystem.model.RoomType;
import com.bookingsystem.model.RoomBook;
import com.bookingsystem.model.RoomDetails;
import com.bookingsystem.repository.CustomerRepository;
import com.bookingsystem.repository.RoomTypeRepository;
import com.bookingsystem.repository.RoomBookRepository;
import com.bookingsystem.repository.RoomDetailsRepository;

@Service
public class BookingSystemService {

	Logger LOGGER = LoggerFactory.getLogger(BookingSystemService.class);
	@Autowired
	RoomTypeRepository roomTypeRepo;
	@Autowired
	RoomBookRepository roomBookRepo;
	@Autowired
	CustomerRepository custRepo;
	@Autowired
	RoomDetailsRepository roomDetailsRepo;

	public String test() {

		LOGGER.info("inside service");

		List<RoomType> roomtype = new ArrayList<RoomType>();
		roomtype = (List<RoomType>) roomTypeRepo.findAll();

		List<RoomBook> rooms = new ArrayList<RoomBook>();
		rooms = (List<RoomBook>) roomBookRepo.findAll();

		List<Customer> customer = new ArrayList<Customer>();
		customer = (List<Customer>) custRepo.findAll();

		return roomtype.toString() + "  " + rooms.toString() + " " + customer.toString();
	}

	public List<RoomBook> getAllBookingsForRoomId(Long roomId) {

		LOGGER.info("getAllBookingsForRoomId");
		List<RoomBook> bookings = new ArrayList<RoomBook>();
		bookings = roomBookRepo.findByRoomId(roomId);
		LOGGER.info("All the bookings of the roomId - {} is as follows {}", roomId, bookings.toString());
		return bookings;
	}

	public List<RoomBook> getAllBookingsForCustomerId(Long customerId) {

		LOGGER.info("getAllBookingsForCustomerId");
		List<RoomBook> bookings = new ArrayList<RoomBook>();
		bookings = roomBookRepo.findByCustomerId(customerId);
		LOGGER.info("All the bookings of the customerId - {} is as follows {}", customerId, bookings.toString());
		return bookings;
	}

	private void markRoomUnavailable(Date dateFrom, Date dateTo) {
		List<RoomBook> rooms = new ArrayList<RoomBook>();
		rooms = (List<RoomBook>) roomBookRepo.findAll();
		for (RoomBook roomBook : rooms) {

			if ((dateFrom.after(roomBook.getBookedFrom()) && dateFrom.before(roomBook.getBookedTo()))
					|| (dateTo.after(roomBook.getBookedFrom()) && dateTo.before(roomBook.getBookedTo()))) {
				
                     roomDetailsRepo.updateRoomAvailability(roomBook.getRoomId());
			}
		}
	}
	
	public RoomDetails checkAvailabilityOfRoomWithinDateRange(Long roomId,Date dateFrom, Date dateTo)
	{
		markRoomUnavailable(dateFrom, dateTo);
		RoomDetails roomDet = new RoomDetails();
		roomDet=roomDetailsRepo.findByRoomId(roomId);
		return roomDet;
	}

}
