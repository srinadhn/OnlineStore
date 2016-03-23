package com.tradeleaves;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tradeleaves.store.StoreApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StoreApplication.class)
@WebAppConfiguration
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
