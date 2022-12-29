package com.komandux.swag.Model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Product {

	@ApiModelProperty(dataType="int",value="ProductId of the Product",name="productId",required=true, example="1")
	int productId;
	@ApiModelProperty(dataType="string", name="barcode", value="barcode of the Product")
	String barcode;
	@ApiModelProperty(dataType="string", name="name", value="Name of the Product",required=true, example="Nike jogging shoes")
	String name;
	@ApiModelProperty(dataType="BigDecimal", value="Price of the Product",required=true, example="30.3")
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
