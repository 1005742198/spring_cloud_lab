package com.huajin.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * �û�����ӿ�
 * @author zhiya.chai
 *
 */
@RestController
@RequestMapping("/users")
@Api(value = "user", description = "�û�����11")
public class UserController {

	@ApiOperation(value = "�û���Ϣ",notes = "��ȡ�û���Ϣ")
	@GetMapping("/getbyid")
	public String getUser(@ApiParam(value="�û�Id",required = true) @RequestParam Integer id) {
		return "user";
	}
}
