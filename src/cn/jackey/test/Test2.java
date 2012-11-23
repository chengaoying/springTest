package cn.jackey.test;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jackey.autowire.AutoWireBean;
import cn.jackey.bean.DependentBean;
import cn.jackey.method.HelloApi;
import cn.jackey.method.Printer;
import cn.jackey.service.ForumService;


public class Test2 {

	/*@Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndPrototype() throws Throwable {
        try {
        	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    		//System.out.println(ctx.getBean("forumService"));
    		ForumService forumService = ctx.getBean("forumService", ForumService.class);
    		forumService.addForum();
        }
       catch (Exception e) {
           // 因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            System.out.println(e);
        }
    }*/
	
	//depends-on
	/*@Test
	public void dependsOnTest() throws IOException{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();
		DependentBean bean = ctx.getBean("dependentBean",DependentBean.class);
		bean.write("helloWorld, 你好");
	}*/
	
	/*@Test
	public void autowireTest(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AutoWireBean autowire = ctx.getBean("autowire", AutoWireBean.class);
		autowire.print();
	}*/
	
	//方法查找方式实现方法注入
	/*@Test
	public void testLookup(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("singletonPrint");
		HelloApi ha = ctx.getBean("helloApi",HelloApi.class);
		ha.sayHello();
		ha = ctx.getBean("helloApi",HelloApi.class);
		ha.sayHello();
		System.out.println("prototypePrint");
		HelloApi ha2 = ctx.getBean("helloApi2",HelloApi.class);
		ha2.sayHello();
		ha2 = ctx.getBean("helloApi2",HelloApi.class);
		ha2.sayHello();
	}*/
	
	//方法替换方式实现方法注入
	@Test
	public void testMethodReplacer(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Printer printer = ctx.getBean("printer",Printer.class);
		printer.print("已被替换");
	}
}
