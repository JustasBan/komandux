package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Premise {
	@ApiModelProperty(dataType="int",notes="PremiseId of the Premise",name="premiseId",required=true,value="test 1")
	int premiseId;
	@ApiModelProperty(dataType="PremiseType",notes="PremiseType of the Premise",name="premiseType",required=true,value="test premiseType")
	PremiseType premiseType;
	@ApiModelProperty(notes="Location of the Premise",name="location",required=true,value="test location")
	String location;
	
	public Premise(int premiseId, PremiseType premiseType, String location) {
		super();
		this.premiseId = premiseId;
		this.premiseType = premiseType;
		this.location = location;
	}

	public int getPremiseId() {
		return premiseId;
	}

	public PremiseType getPremiseType() {
		return premiseType;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Premise [premiseId=" + premiseId + ", premiseType=" + premiseType + ", location=" + location + "]";
	}
}
