package tengo.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;


//���䷽����ִ��
public class Demo4 {
	Class class1;

	public Demo4() throws Exception {
		class1 = Class.forName("tengo.reflect.Person");
	}

	// ȡ�� run()��������ִ��
	@Test
	public void test1() throws Exception {
		Person person = new Person();
		Method method = class1.getMethod("run", null);

		// ָ��һ������ִ�з���
		method.invoke(person, null);
	}

	// ȡ�� run(String name,int password)��������ִ��,�����ͬ
	@Test
	public void test2() throws Exception {
		Person person = new Person();
		Method method = class1.getMethod("run", String.class, int.class);

		// ָ��һ������ִ�з���
		method.invoke(person, "tengo", 1);
	}

	// ȡ�� run(String name,int[] password)��������ִ��,���ҵõ�ִ�к�Ĳ���
	@Test
	public void test3() throws Exception {
		Person person = new Person();
		Method method = class1.getMethod("run", String.class, int[].class);

		// ָ��һ������ִ�з���,���һ�ȡ�������صĲ���
		Object object = method.invoke(person, "tengo", new int[] { 1 });
		Class[] classes = (Class[]) object;
		System.out.println(classes[0]);
	}

	// ȡ�� private run(InputStream inputStream)��������ִ��,���ҵõ�ִ�к�Ĳ���
	@Test
	public void test4() throws Exception {
		Person person = new Person();
		Method method = class1.getMethod("run", InputStream.class);
		method.setAccessible(true);// �����ƽ�
		method.invoke(person, new FileInputStream("c:\\1.txt"));
	}

	// ȡ�� public static run(int num)��������ִ��
	@Test
	public void test5() throws Exception {
		Method method = class1.getMethod("run", int.class);
		// ��̬����ִ�в���Ҫ���󣬮�Ȼ�������һ��������ȥ��Ҳûɶ����
		method.invoke(null, 1);
	}

	// ȡ�� public static void main(String[] args)
	@Test
	public void test6() throws Exception {
		Method method = class1.getMethod("main", String[].class);

		/*
		 * ֱ��ȥ�����Ǹ�������������ֱ����� ԭ���ǿɱ�������⣡ jdk 1.4 �����������String[]{"aa","bb"}����ô��Ѱ��
		 * main(String a,String b){} jdk 1.5 �ɱ�����ĳ���main(String...
		 * a){}������ȻҪ����JDK1.4����˵����Ǵ���һ���ַ�������� ʱ�򣬳����ǻ�ȥ�� main(String a,String
		 * b){}����������]��ȥ������׌�����еķ�����������Ƿ���û���ҵ������������������ˣ��@��ԓ����JAVA��һ��BUG��
		 * 
		 */
		//method.invoke(null, new String[] { "1", "2" });

		/* ��ô���ȷ���Ҳ���е����������� */
		//��Ȼ����Ӳ����Ҿ͹����ٰ�һ�������
		method.invoke(null, new Object[] { new String[] { "1", "2" } });

		//�����Ұ�����ǿת�����ˣ���ʵ�ϻ�������
		method.invoke(null, (Object) new String[] { "1", "2" });
	}
}
