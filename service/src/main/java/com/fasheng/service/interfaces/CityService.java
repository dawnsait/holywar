package com.fasheng.service.interfaces;

import java.util.List;

import com.fasheng.dto.CityDTO;


public interface CityService {
	public CityDTO getCityDTO(Integer id);
	
	/**
	 * get all cities.
	 * @return
	 */
	public List<CityDTO> getAllCities();
	
	public List<Integer> getCityIdsByProvinceId(Integer cityId);
}
