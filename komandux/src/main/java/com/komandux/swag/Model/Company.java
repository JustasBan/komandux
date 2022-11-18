package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Company {
	@ApiModelProperty(dataType="int",notes="SupplierId of the Company",name="supplierId",required=true,value="test 1")
	int supplierId;
	@ApiModelProperty(notes="CompanyName of the Company",name="Company",required=true,value="test companyName")
	String companyName;
	@ApiModelProperty(dataType="ServiceType",notes="ServiceType of the Company",name="serviceType",required=true,value="test serviceType")
	ServiceType serviceType;
	@ApiModelProperty(notes="Address of the Company",name="address",required=true,value="test address")
	String address;
	@ApiModelProperty(notes="ContactInformation of the Company",name="contactInformation",required=true,value="test contactInformation")
	String contactInformation;
	@ApiModelProperty(dataType="RelationshipType",notes="RelationshipType of the Company",name="relationshipType",required=true,value="test relationshipType")
	RelationshipType relationshipType;
	
	public Company(int supplierId, String companyName, ServiceType serviceType, String address,
			String contactInformation, RelationshipType relationshipType) {
		super();
		this.supplierId = supplierId;
		this.companyName = companyName;
		this.serviceType = serviceType;
		this.address = address;
		this.contactInformation = contactInformation;
		this.relationshipType = relationshipType;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public String getAddress() {
		return address;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public RelationshipType getRelationshipType() {
		return relationshipType;
	}

	@Override
	public String toString() {
		return "Company [supplierId=" + supplierId + ", companyName=" + companyName + ", serviceType=" + serviceType
				+ ", address=" + address + ", contactInformation=" + contactInformation + ", relationshipType="
				+ relationshipType + "]";
	}
}
