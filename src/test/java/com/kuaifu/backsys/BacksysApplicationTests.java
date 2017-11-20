package com.kuaifu.backsys;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kuaifu.backsys.user.controller.UserSignupMngController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BacksysApplication.class, webEnvironment=WebEnvironment.DEFINED_PORT)
public class BacksysApplicationTests {

	private MockMvc mvc;
	
	@Before
	public void setUp(){
		mvc = MockMvcBuilders.standaloneSetup(UserSignupMngController.class).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/searchUser").param("userName", "steve"));
		ra.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
