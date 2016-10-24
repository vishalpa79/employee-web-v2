package com.evoke.researchlabs.row.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evoke.researchlabs.row.Application;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SpringBootWebApplicationTests {

	@Test
	public void contextLoads() {
	}

}
