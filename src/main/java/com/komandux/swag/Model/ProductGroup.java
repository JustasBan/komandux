package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProductGroup {
	
	@ApiModelProperty(dataType="int",notes="GroupId of the ProductGroup",name="groupId",required=true,value="test 1")
	int groupId;
	@ApiModelProperty(dataType="int",notes="ProductId of the ProductGroup",name="productId",required=true,value="test 1")
	int productId;
	
	public ProductGroup(int groupId, int productId) {
		super();
		this.groupId = groupId;
		this.productId = productId;
	}

	public int getGroupId() {
		return groupId;
	}

	public int getProductId() {
		return productId;
	}

	@Override
	public String toString() {
		return "ProductGroup [groupId=" + groupId + ", productId=" + productId + "]";
	}
	
}
