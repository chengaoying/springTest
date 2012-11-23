package cn.jackey.test;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jackey.service.ForumService;
import cn.jackey.service.UserService;

public class Test {
	
	//public static void main(String[] args) throws Throwable{
		//1不指定id
		/*BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = factory.getBean(UserService.class);
		userService.addUser();*/
		
		//2指定id
		/*BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = factory.getBean("userService", UserService.class);
		userService.addUser();*/
		
		//3指定name
		/*BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = factory.getBean("bean", UserService.class);
		userService.addUser();*/
		
		//4
		/*BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		ForumService forumService = factory.getBean("forumService", ForumService.class);
		forumService.getUserService().getOrderService().save();
		forumService.getUserService().getList().get(0).save();*/
		
		//5循环依赖注入
		/*try {
        	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    		System.out.println(ctx.getBean("forumService"));
        }
        catch (Exception e) {
            //因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }*/
	//}
	
	//@Test(expected = BeanCurrentlyInCreationException.class)
    public void circleBySetterAndPrototypeTest() throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter3/circleInjectBySetterAndPrototype.xml");
            System.out.println(ctx.getBean("circleA"));
        }
       catch (Exception e) {
           // 因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }
    	
}
