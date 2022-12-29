package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OrderItem {
	
	@ApiModelProperty(dataType="int",notes="ProductId of the OrderItem",name="productId",required=true,value="test 1")
	int productId;
	@ApiModelProperty(dataType="int",notes="OrderId of the OrderItem",name="orderId",required=true,value="test 1")
	int orderId;
	
	public OrderItem(int productId, int orderId) {
		super();
		this.productId = productId;
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public int getOrderId() {
		return orderId;
	}

	@Override
	public String toString() {
		return "OrderItem [productId=" + productId + ", orderId=" + orderId + "]";
	}
	
}
