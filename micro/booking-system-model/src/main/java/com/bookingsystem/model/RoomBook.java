package com.bookingsystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_BOOK")
public class RoomBook {

    @Id
    @Column(name = "ROOMBOOKID")
    private Long roomBookId;
    
    @Column(name = "ROOMID")
    private Long roomId;
    
    @Column(name = "CUSTOMERID")
    private Long customerId;
    
    @Column(name = "BOOKEDFROM")
    private Date bookedFrom;
    
    @Column(name = "BOOKEDTO")
    private Date bookedTo;

   
    public Long getRoomId() {
		return roomId;
	}


	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}


	public Long getRoomBookId() {
		return roomBookId;
	}


	public void setRoomBookId(Long roomBookId) {
		this.roomBookId = roomBookId;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Date getBookedFrom() {
		return bookedFrom;
	}


	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}


	public Date getBookedTo() {
		return bookedTo;
	}


	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}


	@Override
    public String toString() {
        return "ROOMBOOK [roomBookId="+roomBookId+", roomId=" + roomId + ", customerId="
            + customerId + ", bookedFrom=" + bookedFrom.toString()
            + ", bookedTo=" + bookedTo.toString() + "]";
    }
}
