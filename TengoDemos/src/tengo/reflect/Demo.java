package tengo.reflect;

import java.lang.reflect.Constructor;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//�����������Ƽ���һ����
			Class c= Class.forName("tengo.reflect.Person");
		    
			//ͨ��һ��ʵ������ȡ��ʵ������
			Class c2=new Person().getClass();
			
			//ͨ��������ȡ����
			Class c3= Person.class;
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
