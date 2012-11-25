package cn.jackey.hibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jackey.jdbc.User;

public class HibernateTest {

	@Test
	public void test(){
		String[] resources = new String[]{"applicationContext-resources.xml","applicationContext-hibernate.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resources);
		IHibernateDao dao = ctx.getBean("userDao",IHibernateDao.class);
		User user = new User();
		user.setName("hibernateTest");
		dao.save(user);
	}
}
