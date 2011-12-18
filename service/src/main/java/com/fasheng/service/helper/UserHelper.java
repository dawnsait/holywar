package com.fasheng.service.helper;

import com.fasheng.service.dto.PartnerUserDTO;
import com.fasheng.service.dto.UserDTO;
import com.fasheng.service.model.PartnerUserDO;
import com.fasheng.service.model.UserDO;

public class UserHelper {
    public static UserDO convert2UserDO(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setEmail(userDTO.getEmail());
        userDO.setUserId(userDTO.getUserId());
        userDO.setFirstName(userDTO.getFirstName());
        userDO.setPassword(userDTO.getPassword());
        return userDO;
    }
    
    public static UserDTO convert2UserDTO(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(userDO.getEmail());
        userDTO.setFirstName(userDO.getFirstName());
        userDTO.setPassword(userDO.getPassword());
        return userDTO;
    }
    
    /**
     * convert PartnerUserDO to PartnerUserDTO
     * @param partnerUserDO
     * @return
     */
    public static PartnerUserDTO convert2PartnerUserDTO(PartnerUserDO partnerUserDO) {
        PartnerUserDTO dto = new PartnerUserDTO();
        dto.setId(partnerUserDO.getId());
        dto.setAccessToken(partnerUserDO.getAccessToken());
        dto.setPartnerUserId(partnerUserDO.getPartnerUserId());
        dto.setRefreshToken(partnerUserDO.getRefreshToken());
        dto.setType(partnerUserDO.getType());
        dto.setUserId(partnerUserDO.getUserId());
        dto.setVersion(partnerUserDO.getVersion());
        return dto;
    }
    
    /**
     * convert PartnerUserDTO to PartnerUserDO
     * @param partnerUserDTO
     * @return
     */
    public static PartnerUserDO convert2PartnerUserDO(PartnerUserDTO partnerUserDTO) {
        PartnerUserDO partnerUserDO = new PartnerUserDO();
        partnerUserDO.setAccessToken(partnerUserDTO.getAccessToken());
        partnerUserDO.setPartnerUserId(partnerUserDTO.getPartnerUserId());
        partnerUserDO.setRefreshToken(partnerUserDTO.getRefreshToken());
        partnerUserDO.setType(partnerUserDTO.getType());
        partnerUserDO.setUserId(partnerUserDTO.getUserId());
        partnerUserDO.setVersion(partnerUserDTO.getVersion());
        return partnerUserDO;
    }
}
