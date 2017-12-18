package com.kuaifu.backsys.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("用户描述")
public class User {

	@ApiModelProperty(value="用户名称", required=false)
	private String userName;
	
	@ApiModelProperty(value="用户id", required=true)
	private String userId;
}
