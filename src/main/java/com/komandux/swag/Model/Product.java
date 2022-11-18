package com.komandux.swag.Model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Product {

	@ApiModelProperty(dataType="int",notes="ProductId of the Product",name="productId",required=true,value="test 1")
	int productId;
	@ApiModelProperty(name="barcode")
	String barcode;
	@ApiModelProperty(name="name")
	String name;
	@ApiModelProperty(dataType="BigDecimal", name="price")
	BigDecimal price;
	
	public Product(int productId, String barcode, String name, BigDecimal price) {
		super();
		this.productId = productId;
		this.barcode = barcode;
		this.name = name;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", barcode=" + barcode + ", name=" + name + ", price=" + price + "]";
	}
}
