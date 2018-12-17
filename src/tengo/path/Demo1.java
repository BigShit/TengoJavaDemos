package tengo.path;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Demo1 {

	/*
	 * ��ȡclassִ������Ŀ¼��·���������windows�������binĿ¼��������Ӧ������·����
	 * 
	 * ���ǲ�֪��Ϊɶ����ȡ����·��ǰ�����һ����/��
	 */
	@Test
	public void test1() throws IOException {
		String path = this.getClass().getResource("").getPath();
		System.out.println(path);
	}

	/* ��ȡ��ǰ��Ŀ����·���ĸ�Ŀ¼ */
	@Test
	public void test2() throws IOException {
		// ��newһ���ļ��У�����ļ��е�·����д����ô��ӳ�䵽����Ŀ�ĸ�Ŀ¼��
		File directory = new File("");
		// Ȼ���ٻ�ȡ���ɶ��û�е��ļ��У���ʵ���Ǹ�·����������·������
		String courseFile = directory.getCanonicalPath();
		System.out.println(courseFile);

	}

	/* ���ַ�ʽ��ȡ����·��ǰ��ͬ��Ҳ����һ����/�� */
	@Test
	public void test3() throws IOException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		System.out.println(path);
	}
}
