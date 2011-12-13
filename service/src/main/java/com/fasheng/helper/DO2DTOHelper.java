package com.fasheng.helper;

import com.fasheng.dto.CityDTO;
import com.fasheng.dto.DistrictDTO;
import com.fasheng.dto.ProvinceDTO;
import com.fasheng.model.CityDO;
import com.fasheng.model.DistrictDO;
import com.fasheng.model.ProvinceDO;

public class DO2DTOHelper {
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
