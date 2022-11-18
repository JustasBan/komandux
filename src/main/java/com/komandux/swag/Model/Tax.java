package com.komandux.swag.Model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Tax {
	
	@ApiModelProperty(dataType="int",notes="Group of the Tax",name="group",required=true,value="test 1")
	int group;
	@ApiModelProperty(dataType="BigDecimal",notes="Tax of the Tax",name="tax",required=true,value="test 1.0")
	BigDecimal tax;
	@ApiModelProperty(dataType="TaxType",notes="TaxType of the Tax",name="taxType",required=true,value="test taxType")
	TaxType taxType;
	@ApiModelProperty(dataType="TaxReason",notes="TaxReason of the Tax",name="taxReason",required=true,value="test taxReason")
	TaxReason taxReason;
	
	public Tax(int group, BigDecimal tax, TaxType taxType, TaxReason taxReason) {
		super();
		this.group = group;
		this.tax = tax;
		this.taxType = taxType;
		this.taxReason = taxReason;
	}
	
	public int getGroup() {
		return group;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public TaxType getTaxType() {
		return taxType;
	}
	public TaxReason getTaxReason() {
		return taxReason;
	}

	@Override
	public String toString() {
		return "Tax [group=" + group + ", tax=" + tax + ", taxType=" + taxType + ", taxReason=" + taxReason + "]";
	}	
}
