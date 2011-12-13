package com.fasheng.location;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasheng.dto.ProvinceDTO;
import com.fasheng.service.DataServiceLocator;
import com.fasheng.service.interfaces.ProvinceService;

@Controller
@RequestMapping("/location")
public class LocationController {
	@RequestMapping("/test1")  
	@ResponseBody  
	public String testRest(ModelMap model){
		ProvinceService provinceService = DataServiceLocator.getProvinceService();
		List<ProvinceDTO> provinceList = provinceService.getAllProvinces();
		return JSON.toJSONString(provinceList);  
	}
	
	@RequestMapping("/test2")  
	@ResponseBody  
	public String testRest(@RequestParam("code") String code, ModelMap model){
	    return "code=" + code;  
	}
}
