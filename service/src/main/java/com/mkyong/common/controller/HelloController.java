package com.mkyong.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasheng.dao.ProvinceDAO;
import com.fasheng.model.ProvinceDO;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	@Autowired
	public ProvinceDAO provinceDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		ProvinceDO pdo = provinceDAO.selectByPrimaryKey(9);
		String provinceName = pdo.getProvinceName();
		model.addAttribute("message", provinceName + "Spring 3 MVC Hello World");
		return "hello";

	}
	
}