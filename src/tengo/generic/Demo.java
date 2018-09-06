package tengo.generic;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Demo {
	public static void main(String[] args) {
		// JDK1.5֮ǰ������ֻ�ܷ�Object����Ҳ�͵����˳���Ĳ���ȫ�ԣ������е�ʱ��ű���
		/*
		 * List list=new ArrayList<>(); 
		 * list.add("abc"); 
		 * Integer integer=(Integer) list.get(0);
		 */

		List<String> list = new ArrayList<String>();
		list.add("sss");

		String string = list.get(0);
	}

	@Test
	public void test1() {

		List<String> list = new ArrayList<String>();
		list.add("sss");
		list.add("ddd");
		list.add("xxx");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Test
	public void test2() {
		// ע�⣬���ò���Ϊ�������ͣ���int�����Ҫ�õĻ�������Ҫд��Integer
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		map.put(3, "ccc");

		// ��ͳkeyset��entryset����,���߱Ƚϳ���
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			int key = entry.getKey();
			String val = entry.getValue();
			System.out.println("key:" + key + ",value:" + val);
		}

		// ����ʹ����ǿforѭ��
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			int key = entry.getKey();
			String val = entry.getValue();
			System.out.println("key:" + key + ",value:" + val);
		}
	}

	@Test
	public void test3() {
		// �÷���ʱ��������߶����˷��ͣ���ô���ߵķ��ͱ���һ�£�
		// List<String> list = new ArrayList<Object>();
		// List<Object> list = new ArrayList<String>();

		// �������һ����һ�߲��õĻ������ǿ��Եģ�����Ҫ��Ϊ����JDK5��5֮��Ĵ����ܹ��������
		// ����JDK5���˵��߼��汾��JDK������JDK�߼��汾����JDK5�����°汾
		List<String> list = new ArrayList();
		List list2 = new ArrayList<String>();

	}
}
