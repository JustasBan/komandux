package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum AccesToObjects {
	ReadAccess,
	WriteAccess,
	UpdateAccess,
	DeleteAccess,
	AccessToSensitiveInformation
}
