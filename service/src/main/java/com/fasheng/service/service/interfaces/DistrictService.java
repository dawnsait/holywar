package com.fasheng.service.service.interfaces;

import java.util.List;

import com.fasheng.service.dto.DistrictDTO;

public interface DistrictService {
	/**
	 * get all districts.
	 * @return
	 */
	public List<DistrictDTO> getAllDistricts();
	
	public List<Integer> getDistrictIdsByCityId(Integer cityId);
}
