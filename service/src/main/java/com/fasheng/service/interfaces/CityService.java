package com.fasheng.service.interfaces;

import java.util.List;

import com.fasheng.model.CityDO;

public interface CityService {
	public CityDO getCityDO(Integer id);
	
	/**
	 * get all cities.
	 * @return
	 */
	public List<CityDO> getAllCities();
	
	public List<Integer> getCityIdsByCityId(Integer cityId);
}
