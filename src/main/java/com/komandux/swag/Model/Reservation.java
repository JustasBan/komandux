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
	
	public Reservation(int reservationId, Date createdDate, Date reservationDate, Date duration,
			String reservationNotes) {
		super();
		this.reservationId = reservationId;
		this.createdDate = createdDate;
		this.reservationDate = reservationDate;
		this.duration = duration;
		this.reservationNotes = reservationNotes;
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

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", createdDate=" + createdDate + ", reservationDate="
				+ reservationDate + ", duration=" + duration + ", reservationNotes=" + reservationNotes + "]";
	}
}
