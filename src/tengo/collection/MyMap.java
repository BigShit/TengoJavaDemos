package tengo.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class MyMap {

	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("3", "value3");

		// ��һ�֣��ձ�ʹ�ã�����ȡֵ ͨ��Map.keySet����key��value
		System.out.println("------ͨ��Map.keySet����key��value��");
		for (String key : map.keySet()) {
			System.out.println("key= " + key + " and value= " + map.get(key));
		}

		// �ڶ��� ͨ��Map.entrySetʹ��iterator����key��value
		System.out.println("\n------ͨ��Map.entrySetʹ��iterator����key��value��");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}

		// �����֣��Ƽ���������������ʱ ͨ��Map.entrySet����key��value
		System.out.println("\n------ͨ��Map.entrySet����key��value");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}

		// ������ ͨ��Map.values()�������е�value�������ܱ���key
		System.out.println("\n------ͨ��Map.values()�������е�value�������ܱ���key");
		for (String v : map.values()) {
			System.out.println("value= " + v);
		}
		
	}
}
