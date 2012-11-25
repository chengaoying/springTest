package cn.jackey.jpa;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jackey.dao.UserDao;

public class JPATest {

	@Test
	public void test(){
		String[] resource = new String[]{"applicationContext-resources.xml","applicationContext-jpa.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		IUserDao userDao = ctx.getBean(IUserDao.class);
		UserModel model = new UserModel();
		model.setName("jpatest");
		userDao.save(model);
	}
}
