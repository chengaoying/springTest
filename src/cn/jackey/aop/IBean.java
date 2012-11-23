package cn.jackey.aop;

public interface IBean {
	public void print(String param);
	
	public void throwing();
	
	public void around(String str);
	
	public void after();
	
	public void before(String param);
	
	 public boolean sayAfterReturning();
}
