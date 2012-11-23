package cn.jackey.aop.schema;

public class Bean2 {
	
	public void runBefore(String param){
		System.out.println("run before method"+param);
	}
	
	public void runAfter(){
		System.out.println("run after method");
	}

}
