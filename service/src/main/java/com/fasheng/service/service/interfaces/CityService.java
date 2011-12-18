package com.fasheng.service.service.interfaces;

import java.util.List;

import com.fasheng.service.dto.CityDTO;


public interface CityService {
	public CityDTO getCityDTO(Integer id);
	
	/**
	 * get all cities.
	 * @return
	 */
	public List<CityDTO> getAllCities();
	
	public List<Integer> getCityIdsByProvinceId(Integer cityId);
}
