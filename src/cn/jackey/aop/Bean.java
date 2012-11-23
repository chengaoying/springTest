package cn.jackey.aop;

public class Bean implements IBean{

	public void print(String param){
		System.out.println(param);
	}
	
	public void throwing(){
		System.out.println("============before throwing");
        throw new RuntimeException();
	}
	
	public void around(String str){
		System.out.println("this is around advice="+str);
	}
	
	public void after(){
		System.out.println("this is after");
	}
	
	public void before(String param){
		System.out.println(param);
	}
	
	 public boolean sayAfterReturning() {
	        System.out.println("============after returning");
	        return true;
	    }
}
