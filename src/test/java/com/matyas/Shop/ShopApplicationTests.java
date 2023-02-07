package com.matyas.Shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {

	@Test
	public void test(){
		int a = 5;
		int b = 6;
		Assertions.assertEquals(11,a+b);
	}

}
