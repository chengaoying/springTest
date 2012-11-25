package cn.jackey.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTest {
	
	 private static JdbcTemplate jdbcTemplate;
	    
	    @BeforeClass
	    public static void setUpClass() {
	        String url = "jdbc:mysql://localhost:3306/spring?characterEncoding=GBK";
	        String username = "root";
	        String password = "root";
	        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	    @AfterClass
	    public static void tearDownClass() {
	        jdbcTemplate = null;
	        System.out.println("jdbcTemplate:"+jdbcTemplate);
	    }
	    
	    @Before
	    public void testBefore(){
	    	System.out.println("before");
	    }
	    
	    @After
	    public void testAfter(){
	    	System.out.println("after");
	    }
	    
	    @Test
	    public void test(){
	    	 //id自增主键从0开始
	        /*String createTableSql = "create table test" +
	        "(id int not null auto_increment, " +
	        "name varchar(100),primary key(id))engine=InnoDB auto_increment=10000";
	        jdbcTemplate.update(createTableSql);
	    	
	    	String  insertSql = "insert into test(name) values(?)";
	    	for(int i=0;i<10;i++){
	    		jdbcTemplate.update(insertSql,"jackey"+i);
	    	}*/
	    	
	    	String querySql = "select * from test";
	    	/*jdbcTemplate.query(querySql, new RowCallbackHandler() {
		            @Override
		            public void processRow(ResultSet rs) throws SQLException {
		                //2.处理结果集
		            	int id = rs.getInt("id");
		                String value = rs.getString("name");
		                System.out.println("id:" + id);
		                System.out.println("name:" + value);
		            }
	    	});*/
	    	
	    	/*List result = jdbcTemplate.query(querySql, new RowMapper<Map>(){

				@Override
				public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map row = new HashMap();
					row.put(rs.getInt("id"), rs.getString("name"));
					return row;
				}
	    		
	    	});
	    	
	    	for(int i=0;i<result.size();i++){
	    		System.out.println("id:"+result.get(i));
	    	}*/
	    }
	    
	   //@Test
	    public void testPreparedStatement(){
	    	String sql = "insert into test(name) values(?)";
	    	int count = jdbcTemplate.update(sql, new PreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setObject(1, "xiaochen");
				}
	    	});
	    	
	    	jdbcTemplate.update(sql, "xiaochen2");
	    }

}
