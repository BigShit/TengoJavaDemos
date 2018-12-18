package tengo.spring.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	@Test
	public void testRequired() {
		// ��ʼ��ioc����
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans2.xml");

		// ��ȡӵ��@Requiredע���������÷�����bean��
		Student student = (Student) context.getBean("student");

		// �����ڲ��������Զ�װ��ע��@Autowired��bean
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();

		// ���Թ��캯�����Զ�װ��ע��@Autowired��bean
		TextEditor2 textEditor2 = (TextEditor2) context.getBean("textEditor2");
		textEditor2.spellCheck();

		// ����ָ���Զ�װ���bean
		SomeOne someOne = (SomeOne) context.getBean("someOne");
		System.out.println("name:" + someOne.getStudent().getName());
		System.out.println("age:" + someOne.getStudent().getAge());
	}
}
