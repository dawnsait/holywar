/**
 * Project: web
 * 
 * File Created at 2011-12-15
 * $Id$
 * 
 * Copyright 2011 FashengOL Croporation Limited.
 * All rights reserved.
 *
 */
package com.fasheng.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasheng.constant.ResponseCodeEnum;
import com.fasheng.dto.UserDTO;
import com.fasheng.response.user.UserRegisterResponse;

/**
 * TODO Comment of UserController
 * @author ZY
 *
 */


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("email") String email,
                           @RequestParam("password") String password, ModelMap model) {
        
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setCode(ResponseCodeEnum.SUCCESS.getCode());
        userRegisterResponse.setUserName(email);
        
        return JSON.toJSONString(userRegisterResponse);  

    }
}
