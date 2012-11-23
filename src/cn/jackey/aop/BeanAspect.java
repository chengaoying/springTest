package cn.jackey.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeanAspect {
	
	@Pointcut(value="execution(* cn.jackey..*.print(java.lang.String)) && args(param)", argNames = "param")
	public void beforePointCut(String param){}
	
	@Before(value="beforePointCut(param)",argNames="param")
	public void beforeAdvice(String param){
		System.out.println("===before advice param:"+param);
	}
	
	@AfterThrowing(
			value="execution(* cn.jackey..*.throwing(..))",
			argNames="exception",throwing="exception" )
	public void AfterThrowingAdvice(Exception exception){
		System.out.println("==after advice Exception=="+exception);
	}
	
	
	@Around(value="execution(* cn.jackey..*.around(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("==before around advice:");
		Object object = pjp.proceed(new Object[]{"replace"});
		System.out.println("==after around advice:");
		return object;
	}
	
	@After(value="execution(* cn.jackey..*.after(..))")
	public void afterAdvice(){
		System.out.println("==after advice");
	}
	
	@AfterReturning(
			value="execution(* cn.jackey..*.before(..))",
			pointcut="execution(* cn.jackey..*.sayAfterReturning(..))",
			argNames="object", returning="object")
	public void afterReturning(Object object){
		System.out.println("==after returning object:"+object);
	}
	
	@SuppressWarnings("unused")
	@DeclareParents(value="cn.jackey.aop.IBean+",defaultImpl=cn.jackey.aop.DefaultInterfaceImpl.class)
	private TestInterface testInterface;
}
