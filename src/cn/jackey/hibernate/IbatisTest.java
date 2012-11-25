package cn.jackey.hibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jackey.jdbc.User;

public class IbatisTest {

	@Test
	public void test(){
		String[] resources = new String[]{"applicationContext-ibatis.xml","applicationContext-resources.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resources);
		IbatisDaoImpl dao = ctx.getBean("userDao",IbatisDaoImpl.class);
		User user = new User();
		user.setName("ibatisTest");
		dao.insert(user);
	}
}
