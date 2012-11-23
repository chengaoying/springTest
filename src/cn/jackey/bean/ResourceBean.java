package cn.jackey.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResourceBean {

	private FileOutputStream fos;
	private File file;
	public FileOutputStream getFos() {
		return fos;
	}
	public void setFos(FileOutputStream fos) {
		this.fos = fos;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	//指定初始化方法
	public void init(){
		System.out.println("ResourceBean 加载资源");
		try {
			this.fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//销毁
	public void destory(){
		System.out.println("resourceBean 销毁");
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
