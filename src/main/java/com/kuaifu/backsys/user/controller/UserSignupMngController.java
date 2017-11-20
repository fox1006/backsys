package com.kuaifu.backsys.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kuaifu.backsys.bean.GenericResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 后面加入lombok包，可以省点事
 * 使用RestController注解可以省去每个方法前的ResponseBody注解
 * @author 
 *
 */
@Api(value = "API UserSignupMng", produces="生产者", consumes="消费者")
@RestController
public class UserSignupMngController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	@ApiOperation(value = "根据条件查找用户信息", notes = "可以模糊查询，需要翻页", response = GenericResponse.class)
    @ApiImplicitParams({
       @ApiImplicitParam(name = "userName", value = "用户名", required = true,
               dataType = "string", paramType = "query", defaultValue = "steve")
    })
    @ApiResponses(value = {
           @ApiResponse(code = 200, message = "Successful — 请求已完成"),
           @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
           @ApiResponse(code = 401, message = "未授权客户机访问数据"),
           @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
           @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
	@RequestMapping(path="searchUser", method=RequestMethod.GET)
	public GenericResponse searchUserList(@RequestParam(value = "userName", required = true) String userName) {
		GenericResponse resp = new GenericResponse();
		
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> retMap = new HashMap<>();
		retMap.put("userName", userName);
		retMap.put("userId", String.valueOf(new Random().nextDouble()));
		list.add(retMap);
		
		resp.setRows(list);
		resp.setMessage("查找成功");
		resp.setCode("200");
		
		return resp;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	@ApiOperation(value = "添加用户信息", notes = "添加用户...", response = GenericResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
     )
	@RequestMapping(path="addUser", method=RequestMethod.POST)
	public GenericResponse addUser(@RequestParam(value = "userName", required = false) String userName) {
		GenericResponse resp = new GenericResponse();
		resp.setMessage("Add user "+ userName + "successful");
		resp.setCode("200");
		return resp;
		
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "删除用户", notes = "删除用户...", response = GenericResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
     )
	@RequestMapping(path="deleteUser", method=RequestMethod.DELETE)
	public GenericResponse deleteUser(@RequestParam(value = "userId", required = false) String userId) {
		GenericResponse resp = new GenericResponse();
		resp.setMessage("delete user successful");
		resp.setCode("200");
		return resp;
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "更新用户信息", notes = "更新用户...", response = GenericResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
     )
	@RequestMapping(path="updateUser", method=RequestMethod.PUT)
	public GenericResponse updateUser(@RequestParam(value = "userId", required = false) String userId) {
		GenericResponse resp = new GenericResponse();
		resp.setMessage("update user successful");
		resp.setCode("200");
		return resp;
	}
}
