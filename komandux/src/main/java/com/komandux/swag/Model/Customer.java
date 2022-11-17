package com.komandux.swag.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Customer {
	@ApiModelProperty(dataType="int",notes="Id of the Customer",name="customerId",required=true,value="test 1")
	int customerId;
	@ApiModelProperty(notes = "Name of the Customer",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Surname of the Customer",name="surname",required=true,value="test surname")
	private String surname;
	@ApiModelProperty(dataType="Date",notes = "DateOfBirth of the Customer",name="dataOfBirth",required=true, value="test 12/05/2015")
	private Date dataOfBirth;
	@ApiModelProperty(notes = "PhoneNumber of the Customer",name="phoneNumber",required=true,value="test phoneNumber")
	private String phoneNumber;
	@ApiModelProperty(notes = "EmailAddress of the Customer",name="emailAddress",required=true,value="test emailAddress")
	private String emailAddress;
	@ApiModelProperty(dataType="Date",notes = "JoinDate of the Customer",name="joinDate",required=true, value="test 12/05/2015")
	private Date joinDate;
	@ApiModelProperty(notes = "MembershipCard of the Customer",name="membershipCard",required=true,value="test membershipCard")
	private String membershipCard;
	
	public Customer(int customerId, String name, String surname, Date dataOfBirth, String phoneNumber, String emailAddress,
			Date joinDate, String membershipCard) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.surname = surname;
		this.dataOfBirth = dataOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.joinDate = joinDate;
		this.membershipCard = membershipCard;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

	public Date getDataOfBirth() {
		return dataOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public String getMembershipCard() {
		return membershipCard;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", surname=" + surname + ", dataOfBirth="
				+ dataOfBirth + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", joinDate="
				+ joinDate + ", membershipCard=" + membershipCard + "]";
	}
}
