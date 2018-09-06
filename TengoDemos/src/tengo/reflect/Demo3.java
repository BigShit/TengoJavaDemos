package tengo.reflect;

import java.lang.reflect.Field;

import org.junit.Test;


//�����ֶ�
public class Demo3 {

	Class class1;

	public Demo3() throws Exception {
		class1 = Class.forName("tengo.reflect.Person");
	}

	// �����ֶΣ�public
	@Test
	public void test1() throws Exception {
		Person person = new Person();
		Field field = class1.getField("name");
		// ��ȡ�ֶε�ֵ
		Object name = field.get(person);

		// ��ȡ�ֶε�����
		Class type = field.getType();

		if (type.equals("String")) {
			// ��ȡ�ֶε�ֵ
			String value = (String) field.get(person);
			System.out.println(value);

			// ���ֶ�����ֵ
			field.set(person, "new name");

			System.out.println(person.name);
		}

	}

	// �����ֶΣ�private
	@Test
	public void test2() throws Exception {
		Person person = new Person();
		Field field = class1.getDeclaredField("password");

		// �����ƽ�,�Ա��޳ܵػ�ȡ����
		field.setAccessible(true);

		System.out.println(field.get(person));
	}

	// �����ֶΣ�static private
	@Test
	public void test3() throws Exception {
		Person person = new Person();
		Field field = class1.getDeclaredField("age2");

		// �����ƽ�,�Ա��޳ܵػ�ȡ����
		field.setAccessible(true);

		// �����Ǿ�̬�ģ���Ҫ���������ȥ��������......
		System.out.println(field.get(person));
	}
}
