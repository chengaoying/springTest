package cn.jackey.scope.singleton;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;

public class SingletonClassLoader extends ClassLoader{

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if(!name.startsWith("cn.jackey.scope.singleton")){
			return super.loadClass(name);
		}
		
		try {
			InputStream is = new ClassPathResource(name.replace(".", "/")+".class").getInputStream();
			int i = is.available();
			byte[] bytes = new byte[i];
			is.read(bytes, 0, i);
			return defineClass(name, bytes, 0, i);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return super.loadClass(name);
		}
	}

}
