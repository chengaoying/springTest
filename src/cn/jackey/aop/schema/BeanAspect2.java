package cn.jackey.aop.schema;

public class BeanAspect2 {

	public void beforeAdvice(String param){
		System.out.println("===before advice "+param);
	}
	
	public void afterAdvice(){
		System.out.println("===after advice");
	}
}
