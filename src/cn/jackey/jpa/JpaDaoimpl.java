package cn.jackey.jpa;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public class JpaDaoimpl extends JpaDaoSupport implements IUserDao{


	public void save(UserModel model) {
		getJpaTemplate().persist(model);
	}
}
