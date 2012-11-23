package cn.jackey.scope.singleton;

public class Singleton {
	
	//1.˽�л�������
    private Singleton() {}
    
    //2.���������ߣ����Գ�ʼ������һ��ʹ��ʱ��ʼ��
    private static class InstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    //3.�ṩȫ�ַ��ʵ�
    public static Singleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    //4.�ṩһ������������֤һ��ClassLoaderһ��ʵ��
    private int counter=0;
}
