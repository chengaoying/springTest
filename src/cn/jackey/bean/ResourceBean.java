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
	
	//ָ����ʼ������
	public void init(){
		System.out.println("ResourceBean ������Դ");
		try {
			this.fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//����
	public void destory(){
		System.out.println("resourceBean ����");
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
