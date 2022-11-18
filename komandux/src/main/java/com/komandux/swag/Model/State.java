package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum State {
	Pending,
	Approved,
	Shipping,
	Delivered,
	Closed
}
