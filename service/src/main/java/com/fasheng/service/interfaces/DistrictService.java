package com.fasheng.service.interfaces;

import java.util.List;

import com.fasheng.dto.DistrictDTO;

public interface DistrictService {
	/**
	 * get all districts.
	 * @return
	 */
	public List<DistrictDTO> getAllDistricts();
	
	public List<Integer> getDistrictIdsByCityId(Integer cityId);
}
