package com.fasheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasheng.dao.DistrictDAO;
import com.fasheng.model.DistrictDO;
import com.fasheng.service.interfaces.DistrictService;

public class DistrictServiceImpl implements DistrictService {
	@Autowired
	private DistrictDAO districtDAO;
	
	@Override
	public List<DistrictDO> getAllDistricts() {
		return districtDAO.selectAllDistricts();
	}

	@Override
	public List<Integer> getDistrictIdsByCityId(Integer cityId) {
		return districtDAO.selectDistrictIdsByCityId(cityId);
	}
	
	

}
