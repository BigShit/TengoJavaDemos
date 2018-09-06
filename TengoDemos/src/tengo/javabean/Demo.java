package tengo.javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo {

	/* �õ�Bean���������� */
	@Test
	public void test() throws Exception {
		// ����һ��JavaBean�����һ�ȡ���Bean����Ϣ,�ڶ�������Ϊȥ���̳���Object���������
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

		// ��ȡ���Լ���
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

		for (PropertyDescriptor item : pds) {
			System.out.println(item.getName());

		}
	}

	/* ����bean������ �� д */
	@Test
	public void test2() throws Exception {
		// ����һ��JavaBean�����һ�ȡ���Bean����Ϣ,�ڶ�������Ϊȥ���̳���Object���������
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

		Person person = new Person();

		/*
		 * ��ȡage���ԣ���ʵ��Ҳ����������ָ��get����set���ĸ������� ������Щ��������get��set(����getName����Ϊgettname)
		 * ���»�ȡ������д�ķ���
		 */
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		// ��ȡage��set����
		Method setter = pd.getWriteMethod();

		// ����set��������age���и�ֵ
		setter.invoke(person, 15);
		System.out.println(person.getAge());

		// ��ȡget����
		Method getter = pd.getReadMethod();

		System.out.println(getter.invoke(person, null));
	}

	/* ��ȡҪ���������Ե����� */
	@Test
	public void test3() throws Exception {
		// ����һ��JavaBean�����һ�ȡ���Bean����Ϣ,�ڶ�������Ϊȥ���̳���Object���������
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

		Person person = new Person();

		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);

		// ��ȡ���Ե�����
		Class type = pd.getPropertyType();

		System.out.println(type);

	}
}
