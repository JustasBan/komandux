package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum RefundType {
	FullRefundAndKeepItems,
	PartialRefundAndKeepItems,
	FullRefundAndReturnItems,
	PartialRefundAndReturnItems
}
