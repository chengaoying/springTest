package cn.jackey.autowire;

public class AutoWireBean {

	private HelloImpl helloImpl;
	
	public HelloImpl getHelloImpl() {
		return helloImpl;
	}

	public void setHelloImpl(HelloImpl helloImpl) {
		this.helloImpl = helloImpl;
	}

	public void print(){
		helloImpl.printHello();
		System.out.println("autowire");
	}
}
