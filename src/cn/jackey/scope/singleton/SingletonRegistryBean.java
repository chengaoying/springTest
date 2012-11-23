package cn.jackey.scope.singleton;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

public class SingletonRegistryBean implements SingletonBeanRegistry{
	
	private final Map<String, Object> BEANS = new HashMap<String, Object>();

	@Override
	public boolean containsSingleton(String arg0) {
		return BEANS.containsKey(arg0);
	}

	@Override
	public Object getSingleton(String arg0) {
		return BEANS.get(arg0);
	}

	@Override
	public int getSingletonCount() {
		return BEANS.size();
	}

	@Override
	public String[] getSingletonNames() {
		return BEANS.keySet().toArray(new String[0]);
	}

	@Override
	public void registerSingleton(String arg0, Object arg1) {
		if(BEANS.containsKey(arg0)){
			throw new RuntimeException("bean==>"+arg0+"ÒÑ´æÔÚ");
		}
		BEANS.put(arg0, arg1);
	}

}
