package com.komandux.swag.Model;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Discount {
	@ApiModelProperty(dataType="int",notes="Product of the Discount",name="product",required=true,value="test 1")
	int product;
	@ApiModelProperty(dataType="DiscountType",notes="DiscountType of the Discount",name="discountType",required=true,value="test discountType")
	DiscountType discountType;
	@ApiModelProperty(dataType="BigDecimal",notes="Ammount of the Discount",name="ammount",required=true,value="test 1.0")
	BigDecimal ammount;
	@ApiModelProperty(dataType="Date",notes="DiscountStart of the Discount",name="discountStart",required=true,value="test discountStart")
	Date discountStart;
	@ApiModelProperty(dataType="Date",notes="DiscountEnd of the Discount",name="discountEnd",required=true,value="test discountEnd")
	Date discountEnd;
	
	public Discount(int product, DiscountType discountType, BigDecimal ammount, Date discountStart, Date discountEnd) {
		super();
		this.product = product;
		this.discountType = discountType;
		this.ammount = ammount;
		this.discountStart = discountStart;
		this.discountEnd = discountEnd;
	}

	public int getProduct() {
		return product;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public BigDecimal getAmmount() {
		return ammount;
	}

	public Date getDiscountStart() {
		return discountStart;
	}

	public Date getDiscountEnd() {
		return discountEnd;
	}

	@Override
	public String toString() {
		return "Discount [product=" + product + ", discountType=" + discountType + ", ammount=" + ammount
				+ ", discountStart=" + discountStart + ", discountEnd=" + discountEnd + "]";
	}
}
