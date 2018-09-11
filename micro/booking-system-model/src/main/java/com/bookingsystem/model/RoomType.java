package com.bookingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_TYPE")
public class RoomType {

   
    @Id
    @Column(name = "ROOMTYPEID")
    private Long roomTypeId;
    
    @Column(name = "ROOMTYPENAME")
    private String roomTypeName;
    
    @Column(name = "ROOMCOSTWITHREAKFAST")
    private Double roomCostWithBreakfast;
    
    @Column(name = "ROOMCOSTWITHOUTREAKFAST")
    private Double roomCostWithoutBreakfast;

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Double getRoomCostWithBreakfast() {
        return roomCostWithBreakfast;
    }

    public void setRoomCostWithBreakfast(Double roomCostWithBreakfast) {
        this.roomCostWithBreakfast = roomCostWithBreakfast;
    }

    public Double getRoomCostWithoutBreakfast() {
        return roomCostWithoutBreakfast;
    }

    public void setRoomCostWithoutBreakfast(Double roomCostWithoutBreakfast) {
        this.roomCostWithoutBreakfast = roomCostWithoutBreakfast;
    }

    @Override
    public String toString() {
        return "ROOMTYPE [roomTypeId=" + roomTypeId + ", roomTypeName="
            + roomTypeName + ", roomCostWithBreakfast=" + roomCostWithBreakfast
            + ", roomCostWithoutBreakfast=" + roomCostWithoutBreakfast + "]";
    }
}
