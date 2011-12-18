package com.fasheng.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasheng.service.dao.ProvinceDAO;
import com.fasheng.service.dto.ProvinceDTO;
import com.fasheng.service.helper.LocationHelper;
import com.fasheng.service.model.ProvinceDO;
import com.fasheng.service.service.interfaces.ProvinceService;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceDAO provinceDAO;

	@Override
	public List<ProvinceDTO> getAllProvinces() {
		List<ProvinceDO> provinceDOList = this.provinceDAO.selectAllProvinces();
		List<ProvinceDTO> provinceDTOList = new ArrayList<ProvinceDTO>();
		ProvinceDTO provinceDTO = null;
		for(ProvinceDO provinceDO : provinceDOList) {
			provinceDTO = LocationHelper.convert2ProvinceDTO(provinceDO);
			if(provinceDTO != null) {
				provinceDTOList.add(provinceDTO);
			}
		}
		return provinceDTOList;
	}

	@Override
	public ProvinceDTO getProvinceById(Integer id) {
		ProvinceDO provinceDO = this.provinceDAO.selectByPrimaryKey(id);
		return LocationHelper.convert2ProvinceDTO(provinceDO);
	}

}
