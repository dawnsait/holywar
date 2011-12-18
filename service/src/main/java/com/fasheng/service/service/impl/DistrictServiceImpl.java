package com.fasheng.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasheng.service.dao.DistrictDAO;
import com.fasheng.service.dto.DistrictDTO;
import com.fasheng.service.helper.LocationHelper;
import com.fasheng.service.model.DistrictDO;
import com.fasheng.service.service.interfaces.DistrictService;

@Service("districtService")
public class DistrictServiceImpl implements DistrictService {
	@Autowired
	private DistrictDAO districtDAO;
	
	@Override
	public List<DistrictDTO> getAllDistricts() {
		List<DistrictDO> districtDOList = districtDAO.selectAllDistricts();
		List<DistrictDTO> districtDTOList = new ArrayList<DistrictDTO>();
		DistrictDTO districtDTO = null;
		for(DistrictDO districtDO : districtDOList) {
			districtDTO = LocationHelper.convert2DistrictDTO(districtDO);
			if(districtDTO != null) {
				districtDTOList.add(districtDTO);
			}
		}
		return districtDTOList;
	}

	@Override
	public List<Integer> getDistrictIdsByCityId(Integer cityId) {
		return districtDAO.selectDistrictIdsByCityId(cityId);
	}
	
	

}
