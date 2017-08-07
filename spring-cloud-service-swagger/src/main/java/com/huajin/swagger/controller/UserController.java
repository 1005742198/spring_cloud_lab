package com.huajin.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 用户管理接口
 * @author zhiya.chai
 *
 */
@RestController
@RequestMapping("/users")
@Api(value = "user", description = "用户管理11")
public class UserController {

	@ApiOperation(value = "用户信息",notes = "获取用户信息")
	@GetMapping("/getbyid")
	public String getUser(@ApiParam(value="用户Id",required = true) @RequestParam Integer id) {
		return "user";
	}
}
