package tengo.reflect;

import java.awt.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;


//���乹�캯��
public class Demo2 {

	// ͨ����ľ���·����ȡ��
	Class class1;

	public Demo2() throws Exception {
		class1 = Class.forName("tengo.reflect.Person");
	}

	@Test
	public void test1() throws Exception {

		// ��ȡ����Ҫ��������Ĺ��췽���������Ҫ��Ĺ��캯�����ʹ�����Ҫ�����͵Ĳ��������ͼ���...
		Constructor constructor = class1.getConstructor(null);

		/*
		 * ���������ø���Ĺ��췽������ȡһ����Ķ��������ȡ����һ������ �����Ժ�ʵ���õ���ʱ����ǻ�ȡһ��ʵ���˳�����Ķ����ˣ�
		 * ��������Ĳ���null��ָ��ͨ�����ù������Ϊnull�Ĺ��캯��������ʵ�� 2018��2��27��20:28:03
		 */
		Person person = (Person) constructor.newInstance(null);

		// �������Ƿ񴴽���ɹ���
		System.out.println(person.name);

	}

	@Test
	public void test2() throws Exception, SecurityException {

		Constructor constructor = class1.getConstructor(String.class);

		/* ��ȡ��Ҫ����String���͵Ĺ������ */
		Person person = (Person) constructor.newInstance("xxxx");

		System.out.println(person.name);
	}

	@Test
	public void test3() throws Exception, SecurityException {

		Constructor constructor = class1.getConstructor(String.class, int.class);

		Person person = (Person) constructor.newInstance("xxxx", 22);

		System.out.println(person.name);
		System.out.println(person.age);
	}

	@Test
	public void test4() throws Exception, SecurityException {

		/* ��ȡ˽�����͵Ĺ��캯�� */
		Constructor constructor4 = class1.getDeclaredConstructor(List.class);

		/* �������䣬�����������֮��Ͳ��ᱨ��,�������Ȼ�ܹ��ƻ���ķ���ԣ� */
		constructor4.setAccessible(true);

		// ������ֱ����ˣ�ԭ�����˽�з������ⲿ���ܷ��ʣ�
		Person person4 = (Person) constructor4.newInstance(new List() {
		});

		System.out.println(person4.name);
		System.out.println(person4.age);
	}

	@Test
	public void test5() throws Exception {
		/* Ҳ����ͨ������ֱ��ʵ�������󣬵���ֻ�������޲ι��캯����������Ķ��� */
		Person person5 = (Person) class1.newInstance();
		System.out.println(person5.name);
		System.out.println(person5.age);
	}
}
