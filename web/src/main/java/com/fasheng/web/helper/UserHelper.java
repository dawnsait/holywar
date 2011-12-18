package com.fasheng.web.helper;

import com.alibaba.fastjson.JSON;
import com.fasheng.service.dto.PartnerUserDTO;
import com.fasheng.service.dto.UserDTO;
import com.fasheng.web.request.user.PartnerUserLoginRequest;
import com.fasheng.web.request.user.UserRequest;

public class UserHelper {

    public static PartnerUserLoginRequest getPartnerUserLoginRequest(String requestInfo) {
        return JSON.parseObject(requestInfo, PartnerUserLoginRequest.class);
    }
    
    public static PartnerUserDTO buildPartnerUserDTO(PartnerUserLoginRequest request) {
        PartnerUserDTO dto = new PartnerUserDTO();
        dto.setAccessToken(request.getAccessToken());
        dto.setRefreshToken(request.getRefreshToken());
        dto.setPartnerUserId(request.getPartnerUserId());
        dto.setVersion(request.getVersion());
        dto.setUserId(request.getUserId());
        dto.setType(request.getType());
        return dto;
    }
    
    public static UserDTO buildUserDTO(UserRequest userRequest) {
        UserDTO dto = new UserDTO();
        dto.setDegrade(userRequest.getDegrade());
        dto.setEmail(userRequest.getEmail());
        dto.setFirstName(userRequest.getFirstName());
        dto.setLastName(userRequest.getLastName());
        dto.setMobile(userRequest.getMobile());
        dto.setNickName(userRequest.getNickName());
        dto.setPortrait(userRequest.getPortrait());
        dto.setRealName(userRequest.getRealName());
        dto.setScore(userRequest.getScore());
        dto.setStatus(userRequest.getStatus());
        dto.setTelephone(userRequest.getTelephone());
        dto.setUserId(userRequest.getUserId());
        dto.setUserName(userRequest.getUserName());
        dto.setPassword(userRequest.getPassword());
        return dto;
    }
}
