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
package com.fasheng.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasheng.common.constants.ResponseCodeEnum;
import com.fasheng.service.dto.PartnerUserDTO;
import com.fasheng.service.dto.UserDTO;
import com.fasheng.service.service.DataServiceLocator;
import com.fasheng.service.service.interfaces.PartnerUserService;
import com.fasheng.service.service.interfaces.UserService;
import com.fasheng.web.helper.UserHelper;
import com.fasheng.web.request.user.PartnerUserLoginRequest;
import com.fasheng.web.request.user.UserRequest;
import com.fasheng.web.response.BaseResponse;
import com.fasheng.web.response.user.UserResponse;

/**
 * TODO Comment of UserController
 * @author ZY
 *
 */


@Controller
@RequestMapping("/user")
public class UserController {
    PartnerUserService partnerUserService = DataServiceLocator.getPartnerUserService();
    UserService userService = DataServiceLocator.getUserService();
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public String register(@RequestParam("requestInfo") String requestInfo, ModelMap model) {
        UserRequest userRequest = JSON.parseObject(requestInfo, UserRequest.class);
        UserDTO userDTO = UserHelper.buildUserDTO(userRequest);
        userDTO = userService.insert(userDTO);
        UserResponse response = new UserResponse();
        if(userDTO != null) {
            response.setCode(ResponseCodeEnum.SUCCESS.getCode());
            response.setMsg(ResponseCodeEnum.SUCCESS.getDescription() + ", userId:" + userDTO.getUserId());
        } else {
            response.setCode(ResponseCodeEnum.DB_ERROR.getCode());
            response.setMsg(ResponseCodeEnum.DB_ERROR.getDescription());
        }
        return JSON.toJSONString(response);
    }
    
    @RequestMapping(value="/partner/login", method=RequestMethod.GET)   
    @ResponseBody
    public String partnerLogin(@RequestParam("requestInfo") String requestInfo, ModelMap model) {
        PartnerUserLoginRequest request = UserHelper.getPartnerUserLoginRequest(requestInfo);
        PartnerUserDTO dto = UserHelper.buildPartnerUserDTO(request);
        partnerUserService.insert(dto);
        return JSON.toJSONString(dto);
    }
    
    public static void main(String[] args) {
        BaseResponse response = new BaseResponse();
        response.setCode(343);
        response.setMsg("aaaaaa");
        System.out.println(JSON.toJSONString(response));
    }
}
