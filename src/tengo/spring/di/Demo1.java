package tengo.spring.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
	@Test
	public void test1() {
		// ��ʼ��ioc����
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		// ��������������ͨ�����캯��ע�빹����
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();

		// ��������������ͨ��setter����ע��������ɵģ��ڴ�������ĵ��÷�ʽû���κβ�ͬ��ֻ��xml�Լ���Ķ����Ǳ���Щ��ͬ����
		TextEditor2 textEditor2 = (TextEditor2) context.getBean("textEditor2");
		textEditor2.spellCheck();

		// ͨ���ڲ�bean����ע�빹�����ɣ������Ҳûʲô����
		TextEditor2 textEditor3 = (TextEditor2) context.getBean("textEditor3");
		textEditor3.spellCheck();
	}

	@Test
	public void test2() {
		// ��ʼ��ioc����
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		DataBean dataBean = (DataBean) context.getBean("javaCollection");
		System.out.println(dataBean.getAddressList());
		System.out.println(dataBean.getAddressSet());
		System.out.println(dataBean.getAddressMap());
		System.out.println(dataBean.getAddressProp());
	}
}
