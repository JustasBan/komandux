package com.komandux.swag.Model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Employee {

	@ApiModelProperty(dataType="int", name="employeeId")
	int employeeId;
	@ApiModelProperty(dataType="String", name="email")
	String email;
	@ApiModelProperty(dataType="String", name="password")
	String password;
	@ApiModelProperty(dataType="BigDecimal", name="hourlyPayRate")
	BigDecimal hourlyPayRate;
	@ApiModelProperty(dataType="int", name="position")
	int position;
	
	public Employee(int employeeId, String email, String password, BigDecimal hourlyPayRate, int position) {
		super();
		this.employeeId = employeeId;
		this.email = email;
		this.password = password;
		this.hourlyPayRate = hourlyPayRate;
		this.position = position;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public BigDecimal getHourlyPayRate() {
		return hourlyPayRate;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", email=" + email + ", password=" + password + ", hourlyPayRate="
				+ hourlyPayRate + ", position=" + position + "]";
	}
}
