package com.mari.shop.config;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@Log
public class DataSourceTests {
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testConnection() {
		try(Connection con = ds.getConnection()){
			log.info("con: " + con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	
	
}
