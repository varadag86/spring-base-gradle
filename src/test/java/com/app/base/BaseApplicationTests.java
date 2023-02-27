package com.app.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BaseApplication.class)
class BaseApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test()
	{
		BaseApplication.main(new String[]{
				"--spring.main.web-environment=false"
		});
	}

}
