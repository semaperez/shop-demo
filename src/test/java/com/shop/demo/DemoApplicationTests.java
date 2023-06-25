package com.shop.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void verifyBeanCreation() {
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach( b -> {
			Object bean = applicationContext.getBean(b);
			assertNotNull(bean, "Failed to create bean: " + b);
		});
	}
}
