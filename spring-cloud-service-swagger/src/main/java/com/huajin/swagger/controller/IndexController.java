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
	 * ��ҳ
	 * @return
	 */
	@ApiOperation(value="��ҳ", notes="��ȡ��ҳ����")
	//@ApiImplicitParam(name = "id", value = "�û�ID", required = true, paramType = "path")
	@GetMapping("/index/{id}")
	//@ApiIgnore//ʹ�ø�ע��������API
	public String index(@PathVariable("id") Integer id){
		return id.toString();
	}
}
