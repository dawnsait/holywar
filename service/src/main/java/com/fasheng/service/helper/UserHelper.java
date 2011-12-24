package com.fasheng.service.helper;

import com.fasheng.common.utils.BeanUtils;
import com.fasheng.service.dto.PartnerUserDTO;
import com.fasheng.service.dto.UserDTO;
import com.fasheng.service.model.PartnerUserDO;
import com.fasheng.service.model.UserDO;

public class UserHelper {
    public static UserDO convert2UserDO(UserDTO userDTO) {
        return (UserDO) BeanUtils.copyProperties(userDTO, UserDO.class);
    }
    
    public static UserDTO convert2UserDTO(UserDO userDO) {
        return (UserDTO) BeanUtils.copyProperties(userDO, UserDTO.class);
    }
    
    /**
     * convert PartnerUserDO to PartnerUserDTO
     * @param partnerUserDO
     * @return
     */
    public static PartnerUserDTO convert2PartnerUserDTO(PartnerUserDO partnerUserDO) {
        return (PartnerUserDTO) BeanUtils.copyProperties(partnerUserDO, PartnerUserDTO.class);
    }
    
    /**
     * convert PartnerUserDTO to PartnerUserDO
     * @param partnerUserDTO
     * @return
     */
    public static PartnerUserDO convert2PartnerUserDO(PartnerUserDTO partnerUserDTO) {
        return (PartnerUserDO) BeanUtils.copyProperties(partnerUserDTO, PartnerUserDO.class);
    }
}
