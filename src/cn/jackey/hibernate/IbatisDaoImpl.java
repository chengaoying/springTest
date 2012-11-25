package cn.jackey.hibernate;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.jackey.jdbc.User;

public class IbatisDaoImpl extends SqlMapClientDaoSupport{
	
	public void insert(User user){
		getSqlMapClientTemplate().insert("UserSQL-ibatis.insert", user);
	}

}
