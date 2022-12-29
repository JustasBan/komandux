package com.komandux.swag.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Tip {

	@ApiModelProperty(dataType="int", name="tipId")
	int tipId;
	@ApiModelProperty(dataType="String", name="giver")
	String giver;
	@ApiModelProperty(dataType="TipType", name="tipType")
	TipType tipType;
	@ApiModelProperty(dataType="Date", name="givenDate")
	Date givenDate;
	@ApiModelProperty(dataType="int", name="receiverId")
	int receiverId;
	
	public Tip(int tipId, String giver, TipType tipType, Date givenDate, int receiverId) {
		super();
		this.tipId = tipId;
		this.giver = giver;
		this.tipType = tipType;
		this.givenDate = givenDate;
		this.receiverId = receiverId;
	}

	public int getTipId() {
		return tipId;
	}

	public String getGiver() {
		return giver;
	}

	public TipType getTipType() {
		return tipType;
	}

	public Date getGivenDate() {
		return givenDate;
	}

	public int getReceiverId() {
		return receiverId;
	}

	@Override
	public String toString() {
		return "Tip [tipId=" + tipId + ", giver=" + giver + ", tipType=" + tipType + ", givenDate=" + givenDate
				+ ", receiverId=" + receiverId + "]";
	}
}
