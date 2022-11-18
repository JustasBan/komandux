package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Loyalty {
	@ApiModelProperty(dataType="int",notes="Customerid of the Loyalty",name="customerid",required=true,value="test 1")
	int customerid;
	@ApiModelProperty(dataType="double",notes="LoyaltyDiscount of the Loyalty",name="loyaltyDiscount",required=true,value="test 1.0")
	double loyaltyDiscount;
	@ApiModelProperty(dataType="LoyaltyType",notes="LoyaltyType of the Loyalty",name="loyaltyType",required=true,value="test loyaltyType")
	LoyaltyType loyaltyType;
	
	public Loyalty(int customerid, double loyaltyDiscount, LoyaltyType loyaltyType) {
		super();
		this.customerid = customerid;
		this.loyaltyDiscount = loyaltyDiscount;
		this.loyaltyType = loyaltyType;
	}

	public int getCustomerid() {
		return customerid;
	}

	public double getLoyaltyDiscount() {
		return loyaltyDiscount;
	}

	public LoyaltyType getLoyaltyType() {
		return loyaltyType;
	}

	@Override
	public String toString() {
		return "Loyalty [customerid=" + customerid + ", loyaltyDiscount=" + loyaltyDiscount + ", loyaltyType="
				+ loyaltyType + "]";
	}

}
