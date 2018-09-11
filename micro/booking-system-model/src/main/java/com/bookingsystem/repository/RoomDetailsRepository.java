package com.bookingsystem.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookingsystem.model.RoomDetails;
@Transactional
public interface RoomDetailsRepository extends CrudRepository<RoomDetails, Long> {
    @Modifying
	@Query("update RoomDetails rd set rd.isAvailable = false where rd.roomId = :id")
	public void updateRoomAvailability(@Param(value="id") Long roomId);
	
	@Query("select rd from RoomDetails rd where rd.roomId = :id")
	RoomDetails findByRoomId(@Param(value="id") Long roomId);
}
