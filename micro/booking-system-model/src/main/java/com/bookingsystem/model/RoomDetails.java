package com.bookingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_DETAILS")
public class RoomDetails {

	@Id
	@Column(name = "ROOMID")
	private Long roomId;

	@Column(name = "ROOMTYPEID")
	private Long roomTypeId;

	@Column(name = "ISAVAILABLE")
	private boolean isAvailable;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "ROOMDETAILS [roomId=" + roomId + ",roomTypeId=" + roomTypeId + ", isAvailable=" + isAvailable + "]";
	}
}
