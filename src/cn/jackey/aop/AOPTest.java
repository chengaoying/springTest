package cn.jackey.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
	
	//@Test
	public void aspectTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans2.xml");
		Bean bean = ctx.getBean("bean",Bean.class);
		bean.print("hello");
	}
	
	//@Test
	public void aftertest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans2.xml");
		Bean bean = (Bean) ctx.getBean("bean");
		bean.around("around");
	}

	//@Test
	public void testAfterReturning(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans2.xml");
		Bean bean = (Bean) ctx.getBean("bean");
		bean.sayAfterReturning();
	}
	
	@Test
	public void testAnnotation(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans2.xml");
		TestInterface testInterface = ctx.getBean("bean",TestInterface.class);
		testInterface.print();
	}
}
