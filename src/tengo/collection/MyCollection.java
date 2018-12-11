package tengo.collection;

import java.util.*;

import org.junit.Test;

public class MyCollection {

	@Test
	public void testArrayList() {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		list.add("HAHAHAHA");

		// ��һ�ֱ�������ʹ��foreach����List
		for (String str : list) { // Ҳ���Ը�дfor(int i=0;i<list.size();i++)������ʽ
			System.out.println(str);
		}

		// �ڶ��ֱ������������Ϊ������ص����ݽ��б���
		String[] strArray = new String[list.size()];
		list.toArray(strArray);
		// ����Ҳ���Ը�дΪ foreach(String str:strArray)������ʽ
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}

		// �����ֱ��� ʹ�õ�����������ر���
		// ��ȡһ��ָ�򱾼��ϵĵ�����
		Iterator<String> ite = list.iterator();
		// �ж���һ��Ԫ��֮����ֵ
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
}
