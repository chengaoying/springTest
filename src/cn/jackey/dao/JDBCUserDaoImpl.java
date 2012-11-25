package cn.jackey.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import cn.jackey.jdbc.User;

public class JDBCUserDaoImpl extends SimpleJdbcDaoSupport implements UserDao{

	@Override
	public void save(User user) {
		getSimpleJdbcTemplate().update("insert into test(name) values(:name)", new BeanPropertySqlParameterSource(user));
	}

}
