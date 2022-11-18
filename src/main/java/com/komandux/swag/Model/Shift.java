package com.komandux.swag.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Shift {

	@ApiModelProperty(dataType="int", name="shiftId")
	int shiftId;
	@ApiModelProperty(dataType="int", name="employeeId")
	int employeeId;
	@ApiModelProperty(dataType="Date", name="startTime")
	Date startTime;
	@ApiModelProperty(dataType="Date", name="endTime")
	Date endTime;
	
	public Shift(int shiftId, int employeeId, Date startTime, Date endTime) {
		super();
		this.shiftId = shiftId;
		this.employeeId = employeeId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getShiftId() {
		return shiftId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return "Shift [shiftId=" + shiftId + ", employeeId=" + employeeId + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
}
