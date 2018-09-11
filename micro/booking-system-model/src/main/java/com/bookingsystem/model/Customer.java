package com.bookingsystem.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "CUSTOMERID")
	private Long customerId;

	@Column(name = "CUSTOMERNAME")
	private String customerName;

	

	@Column(name = "ISBREAKFAST")
	private boolean isBreakfast;

	@Column(name = "HEADS")
	private Integer heads;
	
	@Column(name = "ROOMTYPEID")
	private Long roomTypeId;
	

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public boolean isBreakfast() {
		return isBreakfast;
	}

	public void setBreakfast(boolean isBreakfast) {
		this.isBreakfast = isBreakfast;
	}


	public Integer getHeads() {
		return heads;
	}

	public void setHeads(Integer heads) {
		this.heads = heads;
	}


	@Override
	public String toString() {
		return "CUSTOMER [customerId=" + customerId + ", customerName=" + customerName + ", isBreakfast=" + isBreakfast
				+ ", heads=" + heads +", roomTypeId=" + roomTypeId + "]";
	}
}
