package com.fasheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasheng.dao.ProvinceDAO;
import com.fasheng.model.ProvinceDO;
import com.fasheng.service.interfaces.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceDAO provinceDAO;

	@Override
	public List<ProvinceDO> getAllProvinces() {
		return this.provinceDAO.selectAllProvinces();
	}

}
