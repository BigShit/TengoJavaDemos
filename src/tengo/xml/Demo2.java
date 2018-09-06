package tengo.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Demo2 {
	Document document;

	@Test
	public void test() throws Exception, IOException {
		// 1.��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 2.�õ�DOM������
		DocumentBuilder builder = factory.newDocumentBuilder();

		// 3.����xml�ĵ����õ������ĵ���Document
		document = builder.parse("src/tengo/xml/book.xml");

	}

	/* ȡ���ĵ������ĳһЩ�ڵ� */
	@Test
	public void read1() throws Exception {
		// �ȵ���������������document
		test();

		// ��ȡxml�������б�ǩ��Ϊ���������Ľڵ㼯��,ͨ���ڵ���������ȡ����Ԫ�أ���Ȼ��Ҳ���б�ķ�ʽ������ͨ��id��
		NodeList list = document.getElementsByTagName("����");

		// �鿴�ĵ������Կ�����item�����������ȡ���������Ԫ��
		Node node = list.item(1);
		// Ȼ���ȡ�ڵ�������ı�ֵ
		String name = node.getTextContent();
		System.out.println(name);

	}

	// ����DOM�ĵ������нڵ�
	@Test
	public void read2() throws Exception {
		// �ȵ���������������document
		test();

		// ���ȵõ����ڵ�
		Node root = document.getElementsByTagName("���").item(0);
		list(root);
	}

	// �ݹ�����ڵ�
	private void list(Node node) {
		// �жϽڵ��ǲ��ǽڵ㣬��Ϊ����ǿո�Ļ���Ҳ�ᱻ������һ���ڵ㣬Ȼ������#text
		if (node instanceof Element) {
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			list(list.item(i));
		}
	}

	// �õ�xml�ĵ��б�ǩ���Ե�ֵ�� <���� name="xxx">ASP.NET MVC�߼����</����>
	@Test
	public void read3() throws Exception {
		// �ȵ���������������document
		test();

		// �õ������б�������ô���Ļ���������Ҫͨ���±���ȡ�����ԣ��ǳ��鷳
		// Node bookname = document.getElementsByTagName("����").item(0);
		// NamedNodeMap map = bookname.getAttributes();

		// ���ǣ�������֪������ڵ�ȷʵ��һ����ǩ��ʱ�����ǿ��԰�����ڵ�ǿת��Element,Ȼ����element��ֱ��ȡ����
		Element bookname = (Element) document.getElementsByTagName("����").item(0);
		String value = bookname.getAttribute("name");
		System.out.println(value);
	}

}
