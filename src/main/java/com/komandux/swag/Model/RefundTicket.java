package com.komandux.swag.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RefundTicket {
	
	@ApiModelProperty(dataType="int", name="refundTicketId")
	int refundTicketId;
	@ApiModelProperty(dataType="int", name="relatedOrder")
	int relatedOrder;
	@ApiModelProperty(dataType="Date", name="requestDate")
	Date requestDate;
	@ApiModelProperty(dataType="boolean", name="granted")
	boolean granted;
	@ApiModelProperty(dataType="String", name="reason")
	String reason;
	@ApiModelProperty(dataType="RefundType", name="refundType")
	RefundType refundType;
	
	public RefundTicket(int refundTicketId, int relatedOrder, Date requestDate, boolean granted, String reason,
			RefundType refundType) {
		super();
		this.refundTicketId = refundTicketId;
		this.relatedOrder = relatedOrder;
		this.requestDate = requestDate;
		this.granted = granted;
		this.reason = reason;
		this.refundType = refundType;
	}

	public int getRefundTicketId() {
		return refundTicketId;
	}

	public int getRelatedOrder() {
		return relatedOrder;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public boolean isGranted() {
		return granted;
	}
	
	public void setGranted() {
		granted = true;
	}

	public String getReason() {
		return reason;
	}

	public RefundType getRefundType() {
		return refundType;
	}
	public void setRefundType(RefundType refundType) {
		this.refundType = refundType; ;
	}

	@Override
	public String toString() {
		return "RefundTicket [refundTicketId=" + refundTicketId + ", relatedOrder=" + relatedOrder + ", requestDate="
				+ requestDate + ", granted=" + granted + ", reason=" + reason + ", refundType=" + refundType + "]";
	}
}
