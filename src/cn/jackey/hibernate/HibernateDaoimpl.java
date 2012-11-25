package cn.jackey.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jackey.jdbc.User;

public class HibernateDaoimpl extends HibernateDaoSupport implements IHibernateDao {

	@Override
	public void save(User user) {
		getHibernateTemplate().save(user);
	}
	
	public void test(int id){
		SessionFactory sessionFactory = getSessionFactory();
		//Session session = sessionFactory.getCurrentSession();
		sessionFactory.openSession().createQuery("select * from test where id="+id).executeUpdate();
	}

}
