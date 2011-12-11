package com.fasheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasheng.dao.CityDAO;
import com.fasheng.dao.DistrictDAO;
import com.fasheng.model.CityDO;
import com.fasheng.service.interfaces.CityService;

public class CityServiceImpl implements CityService {
	@Autowired
	private CityDAO cityDAO;
	
	@Autowired
	private DistrictDAO districtDAO;

	@Override
	public List<CityDO> getAllCities() {
		return this.cityDAO.selectAllCities();
	}

	@Override
	public CityDO getCityDO(Integer id) {
		return this.cityDAO.selectByPrimaryKey(id);
	}

	@Override
	public List<Integer> getCityIdsByCityId(Integer provinceId) {
		return this.districtDAO.selectDistrictIdsByCityId(provinceId);
	}

}
