package cn.jackey.bean;

import java.io.IOException;

public class DependentBean {
	private ResourceBean resourceBean;
	
	public ResourceBean getResourceBean() {
		return resourceBean;
	}

	public void setResourceBean(ResourceBean resourceBean) {
		this.resourceBean = resourceBean;
	}

	public void write(String ss) throws IOException{
		System.out.println("dependentBean写入资源");
		resourceBean.getFos().write(ss.getBytes());
	}
	
	public void init() throws IOException{
		System.out.println("dependentBean初始化");
		resourceBean.getFos().write("dependentBean".getBytes());
		
	}
	
	public void destory() throws IOException{
		System.out.println("dependentBean销毁");
		resourceBean.getFos().write("dependentBean".getBytes());
	}

}
