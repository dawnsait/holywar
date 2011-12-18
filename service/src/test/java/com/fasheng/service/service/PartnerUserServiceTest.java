package com.fasheng.service.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.fasheng.service.dto.PartnerUserDTO;
import com.fasheng.service.service.interfaces.PartnerUserService;

@ContextConfiguration(locations = { "/application-context.xml"})
public class PartnerUserServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	public PartnerUserService partnerUserService;
	
	@Test
	public void testInsertPartnerUser() {
	    PartnerUserDTO dto = new PartnerUserDTO();
	    dto.setAccessToken("access token.......");
	    dto.setType("sina-weibo");
	    dto.setVersion("V2");
	    dto.setUserId("user_id...");
	    partnerUserService.insert(dto);
	}
}
