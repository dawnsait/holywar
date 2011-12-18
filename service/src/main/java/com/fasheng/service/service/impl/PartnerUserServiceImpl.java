package com.fasheng.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasheng.service.dao.PartnerUserDAO;
import com.fasheng.service.dto.PartnerUserDTO;
import com.fasheng.service.helper.UserHelper;
import com.fasheng.service.model.PartnerUserDO;
import com.fasheng.service.service.interfaces.PartnerUserService;

@Service("partnerUserService")
public class PartnerUserServiceImpl implements PartnerUserService {
    @Autowired
    private PartnerUserDAO partnerUserDAO;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return partnerUserDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PartnerUserDTO record) {
        PartnerUserDO partnerUserDO = UserHelper.convert2PartnerUserDO(record);
        return partnerUserDAO.insert(partnerUserDO);
    }

    @Override
    public PartnerUserDTO getByPrimaryKey(Integer id) {
        PartnerUserDO partnerUserDO = partnerUserDAO.selectByPrimaryKey(id);
        PartnerUserDTO dto = UserHelper.convert2PartnerUserDTO(partnerUserDO);
        return dto;
    }

    @Override
    public int updateByPrimaryKey(PartnerUserDTO record) {
        PartnerUserDO partnerUserDO = UserHelper.convert2PartnerUserDO(record);
        return partnerUserDAO.updateByPrimaryKey(partnerUserDO);
    }

}
