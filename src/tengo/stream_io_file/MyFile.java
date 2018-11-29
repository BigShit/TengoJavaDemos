package tengo.stream_io_file;

import java.io.*;

import org.junit.Test;

/*�ܽ�java������ļ���·����,�����ļ���Ӧ���ȳ�ʼ����һ��File����Ȼ��������Ӧ�Ĳ���*/
public class MyFile {

	/*
	 * ͨ�����������ķ�ʽд���ļ����������п��ܵ��������ǣ������ָ����ȡ�ı��룬��ô�������������п���������
	 */
	@Test
	public void write() throws IOException {
		// ����һ������������ڰ����ǵ�����д�뵽ָ�����ļ���,�ڶ���bool�����Ǵ����Ƿ��ƴ�����ı�����
		OutputStream f = new FileOutputStream("C:/1.txt");
		String str = "��ã�~~~�ܸ���������~~~";

		// ʹ��δ֪�ı���д�루�п����Ǳ���Ĭ�ϵı��룩
		f.write(str.getBytes());

		// ʹ��ָ���ı���д�룬���������һ����ͨ��ָ���ı��������
		f.write(str.getBytes("UTF-8"));
		f.close();
	}

	/*
	 * ͨ�����������ķ�ʽ��ȡ�ļ����������,�������п��ܵ��¶�����������������
	 */
	@Test
	public void read() throws IOException {
		InputStream in = new FileInputStream("C:/1.txt");
		String str = new String();

		// һ�����ַ��ض�
		int c = in.read();
		while (c > 0) {
			str += (char) c;// �Ѷ������ַ�ƴ�ӵ������
			c = in.read();// Ȼ���������һ��
		}
		in.close();
		System.out.println("���ı��ж���������Ϊ��" + str);
	}

	/*
	 * ͨ��OutputStreamWriter�ķ�ʽд���ı����ݵ��ļ�������������ָ��д��ı��롣 �䲽��Ϊ:1.�����ļ�����,2.���������,3.
	 * ����OutputStreamWriter��д���ı����ļ�
	 */
	@Test
	public void write2() throws IOException {
		File f = new File("C:/1.txt");
		OutputStream out = new FileOutputStream(f);
		OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
		writer.append("��ã�~~~�ܸ���������~~~");
		writer.close();
		out.close();
	}

	/*
	 * ͨ��InputStreamReader�ķ�ʽ��ȡ�ı����������, �����и��ô����ǿ����Լ�ָ����ȡ�ı���,
	 * �䲽��Ϊ:1.�����ļ�����,2.����������,3.����InputStreamReader����ȡ�ı�
	 */
	@Test
	public void read2() throws IOException {
		File f = new File("C:/1.txt");
		InputStream in = new FileInputStream(f);
		InputStreamReader reader = new InputStreamReader(in, "UTF-8");

		StringBuffer sb = new StringBuffer();

		// ��readerΪready��״̬��,˵����û����,���Լ�����,���inputStream�����е������
		while (reader.ready()) {
			// ת��char�ӵ�StringBuffer������
			sb.append((char) reader.read());
		}

		reader.close();
		in.close();
		System.out.println("���ı��ж���������Ϊ��" + sb);
	}

	/*
	 * �����ļ���
	 * mkdir()��������һ���ļ��У��ɹ��򷵻�true��ʧ���򷵻�false��ʧ�ܱ���File����ָ����·���Ѿ����ڣ�������������·���������ڣ�
	 * ���ļ��в��ܱ������� mkdirs()��������һ���ļ��к��������и��ļ��С�
	 */
	@Test
	public void createDir() {
		String dirname = "d:/tmp/java/";
		File file = new File(dirname);
		// ����Ŀ¼
		file.mkdirs();
	}

	/* �����ļ����µ������ļ��������ж���Ŀ¼�����е��ļ��ǲ����ļ��� */
	@Test
	public void dirList() {
		String dirname = "d:/";
		File file = new File(dirname);
		if (file.isDirectory()) {
			System.out.println("׼������Ŀ¼ " + dirname);
			// ��ȡ�ļ����������ļ��������б��õ����ļ����Ʋ���������·���������Ǳ��ļ����ƣ���ע�⣬��ȡ�Ľ������ļ���
			String s[] = file.list();
			for (int i = 0; i < s.length; i++) {
				File f = new File(dirname + "/" + s[i]);
				if (f.isDirectory()) {
					System.out.println(s[i] + " ��һ��Ŀ¼");
				} else {
					System.out.println(s[i] + " ��һ���ļ�");
				}
			}
		} else {
			System.out.println(dirname + " ����һ��Ŀ¼");
		}
	}

	@Test
	public void delDir() {
		File dir = new File("/tmp/java/");
		deleteFolder(dir);
	}

	/* �ݹ��������ɾ���ļ����Լ��ļ�������������ļ� */
	public static void deleteFolder(File dir) {
		// ��ȡ�ļ�������������ļ��б�ע�⣬���ص��б���һ����File�Ķ��󣬶���������
		File[] files = dir.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					// ������ļ��еĻ�����ô�͵ݹ���ñ�����ɾ���ļ����µ������ļ�
					deleteFolder(f);
				} else {
					// ������ļ��Ļ�����ô��ֱ��ɾ����
					f.delete();
				}
			}
		}
	}
}
