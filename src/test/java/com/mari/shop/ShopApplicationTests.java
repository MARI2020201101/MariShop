package com.mari.shop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class ShopApplicationTests {

	@Test
	void contextLoads() {
		int totalCnt = 501;
		int criCnt = 10;
		double n = totalCnt/(criCnt*1.0);
		System.out.println(n);//5.01
		System.out.println(Math.ceil(n));
		int currPage = 2;
		//start =1 , end = 10
		double endPage = Math.ceil(currPage/10.0)*10;
		System.out.println("--------");
		System.out.println(endPage);
		
		
	}

}
