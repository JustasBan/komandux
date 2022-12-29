package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Position {

	@ApiModelProperty(dataType="int", name="positionId")
	int positionId;
	@ApiModelProperty(dataType="String", name="title")
	String title;
	@ApiModelProperty(dataType="String", name="description")
	String description;
	@ApiModelProperty(dataType="Permisions", name="permisions")
	Permisions permisions;
	@ApiModelProperty(dataType="AccesToObjects", name="accesToObjects")
	AccesToObjects accesToObjects;
	
	public Position(int positionId, String title, String description, Permisions permisions,
			AccesToObjects accesToObjects) {
		super();
		this.positionId = positionId;
		this.title = title;
		this.description = description;
		this.permisions = permisions;
		this.accesToObjects = accesToObjects;
	}

	public int getPositionId() {
		return positionId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Permisions getPermisions() {
		return permisions;
	}

	public AccesToObjects getAccesToObjects() {
		return accesToObjects;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", title=" + title + ", description=" + description
				+ ", permisions=" + permisions + ", accesToObjects=" + accesToObjects + "]";
	}
}
