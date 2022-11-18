package com.komandux.swag.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Group {

	@ApiModelProperty(dataType="int",notes="GroupId of the Group",name="groupId",required=true,value="test 1")
	int groupId;
	@ApiModelProperty(notes="GroupName of the Group",name="groupName",required=true,value="test groupName")
	String groupName;
	
	public Group(int groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + "]";
	}
	
}
