package com.huajin.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
public class IndexController {

	/**
	 * 首页
	 * @return
	 */
	@ApiOperation(value="首页", notes="获取首页内容")
	//@ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path")
	@GetMapping("/index/{id}")
	//@ApiIgnore//使用该注解忽略这个API
	public String index(@PathVariable("id") Integer id){
		return id.toString();
	}
}
