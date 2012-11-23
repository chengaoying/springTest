package cn.jackey.method;

public abstract class HelloApiImpl implements HelloApi {
	
	private Printer printer;

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void sayHello() {
		printer.print("setter");
		createPrototypePrinter().print("prototype");
		createSingletonPrinter().print("singleton");
		
	}
	
	public abstract Printer createPrototypePrinter();
	public Printer createSingletonPrinter(){
		System.out.println("此方法不会被执行");
		return new Printer();
	}

}
