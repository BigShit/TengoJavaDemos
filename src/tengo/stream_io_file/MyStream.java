package tengo.stream_io_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class MyStream {

	/* ������ȡ����̨������ַ� */
	@Test
	public void test1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;

		System.out.println("�������ַ���.....");

		// ��ȡ�������ݵĵ�һ���ַ�
		i = br.read();

		// ���û�е��׵Ļ���һֱ�����Ҵ�ӡ
		while (i > 0) {// �������-1˵���Ѿ�������
			char c = (char) i;
			System.out.println(c);
			i = br.read();
		}
	}

	/* ��ȡ������� */
	@Test
	public void test2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("�������ַ�����.....");

		// ��ȡ�������ݵĵ�һ���ַ�
		String s = br.readLine();
		System.out.println("�������Ϊ��" + s);
	}

	/* ��һ���������������̨ */
	@Test
	public void test3() throws IOException {
		System.out.write('a');
		System.out.write('\n');
	}
}
