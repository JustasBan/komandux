package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum TaxReason {
	VAT,
	SalesTax,
	ExcisesTax,
	Tariff,
	LicenseFees,
	Poll,
	Other
}
