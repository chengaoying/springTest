package cn.jackey.resource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class ResourceTest {
	
	//字节数组资源
	//@Test
	public void testByteArrayResource(){
		 Resource resource = new ByteArrayResource("Hello World!".getBytes());
		 if(resource.exists()){
			 dumpStream(resource);
		 }
		 Assert.assertEquals(false, resource.isOpen());
	}
	
	//
	//@Test
	public void testInputStreamResource(){
		ByteArrayInputStream bis = new ByteArrayInputStream("hello world".getBytes());
		Resource resource = new InputStreamResource(bis);
		if(resource.exists()){
			dumpStream(resource);
		}
		 Assert.assertEquals(true, resource.isOpen());
		
	}
	
	//@Test
	public void testFileResource(){
		File file = new File("e:/test.txt");
		Resource resource = new FileSystemResource(file);
		if(resource.exists()){
			dumpStream(resource);
		}
		Assert.assertEquals(false, resource.isOpen());
	}
	
	
	private void dumpStream(Resource resource){
		InputStream is = null;
		try {
			//打开资源
			is = resource.getInputStream();
			//读取资源
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			System.out.println(new String(bytes));
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
                //3.关闭资源
                is.close();
            } catch (IOException e) {
            }
		}
	}

	//@Test
	public void testResourceLoad(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ResourceBean bean = ctx.getBean("bean",ResourceBean.class);
		ResourceBean bean2 = ctx.getBean("bean2", ResourceBean.class);
		System.out.println(bean.getResource());
		Assert.assertTrue(bean.getResource() instanceof ClassPathResource);
		Assert.assertTrue(bean2.getResource() instanceof ClassPathResource);
	}
	
	@Test
	public void testClassPathLoad() throws Exception{
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath*:META-INF/*.LIST");
		System.out.println(resources.length);
		Assert.assertEquals(1, resources.length);
	}
}
