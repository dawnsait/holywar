package com.fasheng.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasheng.service.dao.CityDAO;
import com.fasheng.service.dao.DistrictDAO;
import com.fasheng.service.dto.CityDTO;
import com.fasheng.service.helper.LocationHelper;
import com.fasheng.service.model.CityDO;
import com.fasheng.service.service.interfaces.CityService;

@Service("cityService")
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDAO cityDAO;
	
	@Autowired
	private DistrictDAO districtDAO;

	@Override
	public List<CityDTO> getAllCities() {
		List<CityDO> cityDOList = this.cityDAO.selectAllCities();
		List<CityDTO> cityDTOList = new ArrayList<CityDTO>();
		CityDTO cityDTO = null;	
		for(CityDO cityDO : cityDOList) {
			cityDTO = LocationHelper.convert2CityDTO(cityDO);
			if(cityDTO != null) {
				cityDOList.add(cityDO);
			}
		}
		return cityDTOList;
	}

	@Override
	public CityDTO getCityDTO(Integer id) {
		CityDO cityDO = this.cityDAO.selectByPrimaryKey(id);
		CityDTO cityDTO = LocationHelper.convert2CityDTO(cityDO);
		return cityDTO;
	}

	@Override
	public List<Integer> getCityIdsByProvinceId(Integer provinceId) {
		return this.districtDAO.selectDistrictIdsByCityId(provinceId);
	}

}
