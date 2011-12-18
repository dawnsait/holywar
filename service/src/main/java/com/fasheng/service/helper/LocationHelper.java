package com.fasheng.service.helper;

import com.fasheng.service.dto.CityDTO;
import com.fasheng.service.dto.DistrictDTO;
import com.fasheng.service.dto.ProvinceDTO;
import com.fasheng.service.model.CityDO;
import com.fasheng.service.model.DistrictDO;
import com.fasheng.service.model.ProvinceDO;

public class LocationHelper {
	/**
	 * convert ProvinceDO to ProvinceDTO
	 * @param provinceDO
	 * @return
	 */
	public static ProvinceDTO convert2ProvinceDTO(ProvinceDO provinceDO) {
		if(provinceDO == null) {
			return null;
		}
		ProvinceDTO dto = new ProvinceDTO();
		dto.setId(provinceDO.getId());
		dto.setProvinceName(provinceDO.getProvinceName());
		return dto;
	}
	
	/**
	 * convert CityDO to CityDTO
	 * @param cityDO
	 * @return
	 */
	public static CityDTO convert2CityDTO(CityDO cityDO) {
		if(cityDO == null) {
			return null;
		}
		CityDTO dto = new CityDTO();
		dto.setId(cityDO.getId());
		dto.setCityName(cityDO.getCityName());
		dto.setProvinceId(cityDO.getProvinceId());
		dto.setZipCode(cityDO.getZipCode());
		return dto;
	}
	
	/**
	 * convert DistrictDO to DistrictDTO
	 * @param districtDO
	 * @return
	 */
	public static DistrictDTO convert2DistrictDTO(DistrictDO districtDO) {
		DistrictDTO dto = new DistrictDTO();
		dto.setId(districtDO.getId());
		dto.setDistrictName(districtDO.getDistrictName());
		dto.setCityId(districtDO.getCityId());
		return dto;
	}
	
	
}
