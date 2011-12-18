package com.fasheng.service.service.interfaces;

import com.fasheng.service.dto.PartnerUserDTO;

public interface PartnerUserService {

    int deleteByPrimaryKey(Integer id);

    int insert(PartnerUserDTO record);

    PartnerUserDTO getByPrimaryKey(Integer id);

    int updateByPrimaryKey(PartnerUserDTO record);
}
