package com.fasheng.location;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/location")
public class LocationController {
	@RequestMapping("/test1")  
	@ResponseBody  
	public String testRest(ModelMap model){
	    return "222222222222222222";  
	}
	
	@RequestMapping("/test2")  
	@ResponseBody  
	public String testRest(@RequestParam("code") String code, ModelMap model){
	    return "code=" + code;  
	}
}
