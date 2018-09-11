package com.bookingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bookingsystem.model.RoomBook;

public interface RoomBookRepository extends CrudRepository<RoomBook, Long> {
	
	@Query("select rb from RoomBook rb where rb.roomId = :id")
	List<RoomBook> findByRoomId(@Param(value="id") Long roomId);
	
	@Query("select rb from RoomBook rb where rb.customerId = :id")
	List<RoomBook> findByCustomerId(@Param(value="id") Long customerId);
	


}
