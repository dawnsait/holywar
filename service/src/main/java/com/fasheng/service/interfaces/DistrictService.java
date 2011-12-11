package com.fasheng.service.interfaces;

import java.util.List;

import com.fasheng.model.DistrictDO;

public interface DistrictService {
	/**
	 * get all districts.
	 * @return
	 */
	public List<DistrictDO> getAllDistricts();
	
	public List<Integer> getDistrictIdsByCityId(Integer cityId);
}
