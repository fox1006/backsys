package com.kuaifu.backsys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API for screen [Registered User Management]")
@RestController
public class UserSignupMng {

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@ApiOperation(value = "Fetch list of user", notes = "Pagination is required. Response Parameters in rows[] section: groupId, groupItem, whse, vendor", response = Map.class)
	@RequestMapping(path="searchUser", method=RequestMethod.GET)
	public Map<String, String> searchUserList(@RequestParam(value = "userName", required = false) String userName) {
		Map<String, String> ret = new HashMap<>();
		ret.put("userName", userName);	
		return ret;
	}
}
