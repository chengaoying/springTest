package cn.jackey.scope.singleton;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.Test;


public class SingletonTest {

/*	@Test
	public void testSingleton() throws Exception{
		//第一个单例
		ClassLoader classLoader = new SingletonClassLoader();
		Class clazz = classLoader.loadClass("cn.jackey.scope.singleton.Singleton");
		Method method = clazz.getDeclaredMethod("getInstance");
		Object object = method.invoke(clazz);
		Field field = clazz.getDeclaredField("counter");
		field.setAccessible(true);
		Integer counter = (Integer) field.get(object);
		field.set(object, counter+1);
		Assert.assertEquals(1, field.get(object));
		System.out.println(field.get(object));
		
		//第二个单例
		ClassLoader classLoader2 = new SingletonClassLoader();
		Class clazz2 = classLoader2.loadClass("cn.jackey.scope.singleton.Singleton");
		Method method2 = clazz2.getDeclaredMethod("getInstance");
		Object object2 = method2.invoke(clazz2);
		Field field2 = clazz2.getDeclaredField("counter");
		field2.setAccessible(true);
		Integer counter2 = (Integer) field2.get(object2);
		field2.set(object2,counter2+1);
		//Assert.assertEquals(2, field2.get(object2));
		System.out.println(field2.get(object2));
	}*/
	
	@Test
	public void testRegistry(){
		SingletonRegistryBean registry = new SingletonRegistryBean();
		registry.registerSingleton("singleton", new SingletonBean());
		SingletonBean bean = (SingletonBean) registry.getSingleton("singleton");
		bean.print();
		
		try {
			registry.registerSingleton("singleton", new SingletonBean());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
}
