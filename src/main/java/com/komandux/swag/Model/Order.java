package com.komandux.swag.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Order {
	
	@ApiModelProperty(dataType="int",notes="OrderId of the Order",name="orderId",required=true,value="test 1")
	int orderId;
	@ApiModelProperty(dataType="DATE", name="purchaseDate")
	Date purchaseDate;
	@ApiModelProperty(dataType="State", name="state")
	State state;
	@ApiModelProperty(dataType="DeliveryMethod", name="deliveryMethod")
	DeliveryMethod deliveryMethod;
	@ApiModelProperty(dataType="Date", name="deliveryDate")
	Date deliveryDate;
	@ApiModelProperty(dataType="PaymentMethod", name="paymentMethod")
	PaymentMethod paymentMethod;
	@ApiModelProperty(dataType="String", name="transactionDetails")
	String transactionDetails;
	@ApiModelProperty(dataType="String", name="additionalComments")
	String additionalComments;
	
	public Order(int orderId, Date purchaseDate, State state, DeliveryMethod deliveryMethod, Date deliveryDate,
			PaymentMethod paymentMethod, String transactionDetails, String additionalComments) {
		super();
		this.orderId = orderId;
		this.purchaseDate = purchaseDate;
		this.state = state;
		this.deliveryMethod = deliveryMethod;
		this.deliveryDate = deliveryDate;
		this.paymentMethod = paymentMethod;
		this.transactionDetails = transactionDetails;
		this.additionalComments = additionalComments;
	}

	public int getOrderId() {
		return orderId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public State getState() {
		return state;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", purchaseDate=" + purchaseDate + ", state=" + state + ", deliveryMethod="
				+ deliveryMethod + ", deliveryDate=" + deliveryDate + ", paymentMethod=" + paymentMethod
				+ ", transactionDetails=" + transactionDetails + ", additionalComments=" + additionalComments + "]";
	}
}
