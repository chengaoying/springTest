package cn.jackey.aop.schema;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchemaTest {

	@Test
	public void schemaBeforeTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans3.xml");
		Bean2 bean = ctx.getBean("bean",Bean2.class);
		//bean.runBefore("before");
		bean.runAfter();
	}
}
