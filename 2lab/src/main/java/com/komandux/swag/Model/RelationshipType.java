package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum RelationshipType {
	Supplier,
	Customer,
	SupplierAndCustomer,
	Other
}
