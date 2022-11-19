package com.komandux.swag.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Reservation {
	@ApiModelProperty(dataType="int",notes="ReservationId of the Reservation",name="reservationId",required=true,value="test 1")
	int reservationId;
	@ApiModelProperty(dataType="Date",notes = "CreatedDate of the Reservatioin",name="createdDate",required=true, value="test createdDate")
	Date createdDate;
	@ApiModelProperty(dataType="Date",notes = "ReservationDate of the Reservatioin",name="reservationDate",required=true, value="test reservationDate")
	Date reservationDate;
	@ApiModelProperty(dataType="Date",notes = "Duration of the Reservatioin",name="duration",required=true, value="test duration")
	Date duration;
	@ApiModelProperty(notes = "ReservationNotes of the Reservatioin",name="reservationNotes",required=true, value="test reservationNotes")
	String reservationNotes;

	@ApiModelProperty(dataType="PremiseType",notes="PremiseType of the Premise",name="premiseType",required=true,value="test premiseType")
	PremiseType premiseType;

	@ApiModelProperty(notes="Location of the Premise",name="location",required=true,value="test location")
	String location;
	
	public Reservation(int reservationId, Date createdDate, Date reservationDate, Date duration,
			String reservationNotes, PremiseType premiseType, String location) {
		super();
		this.reservationId = reservationId;
		this.createdDate = createdDate;
		this.reservationDate = reservationDate;
		this.duration = duration;
		this.reservationNotes = reservationNotes;
		this.premiseType = premiseType;
		this.location = location;
	}

	public int getReservationId() {
		return reservationId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public Date getDuration() {
		return duration;
	}

	public String getReservationNotes() {
		return reservationNotes;
	}

	public PremiseType getPremiseType() {
		return premiseType;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", createdDate=" + createdDate + ", reservationDate="
				+ reservationDate + ", duration=" + duration + ", reservationNotes=" + reservationNotes + ", premiseType=" + premiseType + ", location=" + location + "]";
	}
}
