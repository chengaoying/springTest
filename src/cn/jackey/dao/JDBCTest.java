package cn.jackey.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jackey.jdbc.User;

public class JDBCTest {

	@Test
	public void jdbcTest(){
        String[] configLocations = new String[] {
                "classpath:applicationContext-resources.xml",
                "classpath:applicationContext-jdbc.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		UserDao userDao = ctx.getBean("userDao", UserDao.class);
		User user = new User();
		user.setName("jackey101");
		userDao.save(user);
	}
}
