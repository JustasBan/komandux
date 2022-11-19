package com.komandux.swag.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Customer {
	@ApiModelProperty(dataType="int", name="customerId")
	int customerId;
	@ApiModelProperty(dataType="String", name="name")
	private String name;
	@ApiModelProperty(dataType="String", name="surname")
	private String surname;
	@ApiModelProperty(dataType="Date", name="dataOfBirth")
	private Date dataOfBirth;
	@ApiModelProperty(dataType="String", name="phoneNumber")
	private String phoneNumber;
	@ApiModelProperty(dataType="String", name="emailAddress")
	private String emailAddress;
	@ApiModelProperty(dataType="Date", name="joinDate")
	private Date joinDate;
	@ApiModelProperty(dataType="String", name="membershipCard")
	private String membershipCard;
	@ApiModelProperty(dataType="LoyaltyType",name="loyaltyType")
	LoyaltyType loyaltyType;
	@ApiModelProperty(dataType="String", name="username")
	private String username;
	@ApiModelProperty(dataType="String", name="password")
	private String password;
	
	
	public Customer(int customerId, String name, String surname, Date dataOfBirth, String phoneNumber, String emailAddress,
			Date joinDate, String membershipCard, LoyaltyType loyaltyType) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.surname = surname;
		this.dataOfBirth = dataOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.joinDate = joinDate;
		this.membershipCard = membershipCard;
		this.loyaltyType = loyaltyType;
	}
	
	public Customer(int customerId, String name, String surname, Date dataOfBirth, String phoneNumber, String emailAddress,
			Date joinDate, String membershipCard, LoyaltyType loyaltyType, String username, String password)
	{
		super();
		this.customerId = customerId;
		this.name = name;
		this.surname = surname;
		this.dataOfBirth = dataOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.joinDate = joinDate;
		this.membershipCard = membershipCard;
		this.loyaltyType = loyaltyType;
		this.username = username;
		this.password = password;
	}
	
	public Customer() {}
	
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

	public LoyaltyType getLoyaltyType() {
		return loyaltyType;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setDataOfBirth(Date dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setLoyaltyType(LoyaltyType loyaltyType) {
		this.loyaltyType = loyaltyType;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", surname=" + surname + ", dataOfBirth="
				+ dataOfBirth + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", joinDate="
				+ joinDate + ", membershipCard=" + membershipCard
				+ ", loyaltyType=" + loyaltyType + ", username=" + username + ", password=" + password + "]";
	}
}
