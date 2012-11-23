package cn.jackey.method;

public class Printer {
	
	private int counter=0;
	
	public void print(String type){
		System.out.println(type+" print:"+counter++);
	}

}
