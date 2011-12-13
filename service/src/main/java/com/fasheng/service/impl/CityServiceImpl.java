package com.fasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasheng.dao.CityDAO;
import com.fasheng.dao.DistrictDAO;
import com.fasheng.dto.CityDTO;
import com.fasheng.helper.DO2DTOHelper;
import com.fasheng.model.CityDO;
import com.fasheng.service.interfaces.CityService;

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
			cityDTO = DO2DTOHelper.convert2CityDTO(cityDO);
			if(cityDTO != null) {
				cityDOList.add(cityDO);
			}
		}
		return cityDTOList;
	}

	@Override
	public CityDTO getCityDTO(Integer id) {
		CityDO cityDO = this.cityDAO.selectByPrimaryKey(id);
		CityDTO cityDTO = DO2DTOHelper.convert2CityDTO(cityDO);
		return cityDTO;
	}

	@Override
	public List<Integer> getCityIdsByProvinceId(Integer provinceId) {
		return this.districtDAO.selectDistrictIdsByCityId(provinceId);
	}

}
