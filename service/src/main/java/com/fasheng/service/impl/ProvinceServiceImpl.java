package com.fasheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasheng.dao.ProvinceDAO;
import com.fasheng.dto.ProvinceDTO;
import com.fasheng.helper.DO2DTOHelper;
import com.fasheng.model.ProvinceDO;
import com.fasheng.service.interfaces.ProvinceService;

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
			provinceDTO = DO2DTOHelper.convert2ProvinceDTO(provinceDO);
			if(provinceDTO != null) {
				provinceDTOList.add(provinceDTO);
			}
		}
		return provinceDTOList;
	}

	@Override
	public ProvinceDTO getProvinceById(Integer id) {
		ProvinceDO provinceDO = this.provinceDAO.selectByPrimaryKey(id);
		return DO2DTOHelper.convert2ProvinceDTO(provinceDO);
	}

}
