package com.fasheng.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.fasheng.model.CityDO;


@ContextConfiguration(locations = { "/application-context.xml"})
public class CityDAOTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	public CityDAO cityDAO;
	
	@Test
	public void testSelectAllCities(){
		List<CityDO> cities = cityDAO.selectAllCities();
		for(CityDO city : cities) {
			System.out.println(city.getCityName());
		}
	}
	
	@Test
	public void testSelectCitiesByProvinceId() {
		List<Integer> cities = cityDAO.selectCityIdsByProvinceId(11);
		for(Integer cityId : cities) {
			System.out.println(cityId);
		}
	}
}