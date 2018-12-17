package tengo.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/*
 * ���demo��Ҫ����spring ��ioc����,Ҳ���ǰ���������bean��������
 * ����Ҫʹ�õĶ��󶼿���ͨ��������ȡ,������Ҫ��Ϊ��new��
 * ����ǳ���Գ�Ѷ���Ŀ���Ȩת������ܣ������Ʒ�ת��Ȼ��Ϳ���ͨ��xml���ɵؿ��Ƽ�����Щ�ࡣ
 * ͨ�������õ�����֮�󣬾Ϳ�������ص��ö�����ӵ�еķ��� ��
 * */
public class Demo1 {

	/*
	 * 1.������ʾ����ͨ��xmd�ļ�������ĳ���̳���ָ���ӿڣ�ӵ���ض����������࣬Ȼ��ͨ���ӿ����������������ڵķ���,
	 * 2.ͨ���ӿڵ�Լ��������ͨ��xml����滻ʵ���࣬�������Ҫ�л�ʵ����Ļ����ͷǳ����ˣ��޸���� �� ��Ȼ����ʵ��Ӧ�ó�����
	 * getBean("helloWorld"); �е�bean����helloWorld�������Ƕ��ģ����Ǳ����xml�ļ���beanӳ���class��
	 * 3.�˴����������д���˼̳й�ϵ������ʵҲ����ͨ��xml������̳й�ϵ�ġ�
	 */
	@Test
	public void test1() {
		// ͨ������·������ȡbean�ļ���Ȼ������һ��bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		// ����bean�ļ��е�helloworld��,�����ýӿڽ��ոö���
		IHelloWorld helloWorld = (IHelloWorld) context.getBean("helloWorld");
		// �����������ʺõķ���
		helloWorld.getMessage();

		// ����bean�ļ��е�helloChinese��,�����ýӿڽ��ոö���
		IHelloWorld helloChinese = (IHelloWorld) context.getBean("helloChinese");
		// �������й����ʺõķ���
		helloChinese.getMessage();

		// ����bean�ļ��е�helloJapanse��,�����ýӿڽ��ոö���
		IHelloWorld helloJapanse = (IHelloWorld) context.getBean("helloJapanse");
		// �������ձ����ʺõķ���
		helloJapanse.getMessage();
	}

	/*
	 * ��һ�����ÿ���ṩ�� XmlBeanFactory() API ȥ���ɹ��� bean �Լ����� ClassPathResource() API
	 * ȥ������·�� CLASSPATH �¿��õ� bean �����ļ���XmlBeanFactory() API
	 * ���𴴽�����ʼ�����еĶ��󣬼��������ļ����ᵽ�� bean��
	 * 
	 * �ڶ������õ�һ�����ɵ� bean ��������� getBean() �����õ�����Ҫ�� bean�� �������ͨ�������ļ��е� bean ID
	 * ������һ�������Ķ��󣬸ö�������������ʵ�ʵĶ���һ���õ����������Ϳ���������������������κη����� Ȼ�죬���ַ�ʽ�����Ѿ��������ˣ�
	 */
	@Test
	public void test2() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		obj.getMessage();
	}

	/*
	 * ��һ�����ɹ������󡣼�����ָ��·���� bean �����ļ������ÿ���ṩ�� FileSystemXmlApplicationContext API
	 * ȥ���ɹ��� bean��FileSystemXmlApplicationContext �������ɺͳ�ʼ�����еĶ��󣬱��磬������ XML bean
	 * �����ļ��е� bean��
	 * 
	 * �ڶ������õ�һ�����ɵ��������е� getBean() �����õ�����Ҫ�� bean�� �������ͨ�������ļ��е� bean ID
	 * ������һ�������Ķ���һ���õ�������󣬾Ϳ���������������������κη�����
	 */
	@Test
	public void test3() {
		/*
		 * ͨ�����������·������������,��ȡһ��bean��������Ȼ,Ҳ����ͨ����������ȡʵ��·��,Ȼ�����������
		 * ��һ�и������ClassPathXmlApplicationContext�е�������������Ҫ���ļ��Ǳ�������Ŀ·�������;
		 * ����һ�в���Ҫ��ֻҪ��Ӧ����·������������ļ��Ϳ����ˡ�
		 */
		ApplicationContext context = new FileSystemXmlApplicationContext("d:\\Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}
}
