package tengo.varargs;

import java.util.List;

import org.junit.Test;

import java.util.Arrays;



public class Demo1 {

	public void sum(int... nums) {
		// �ɱ�����Ͱ�����������
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		System.out.println(sum);
	}

	@Test
	public void testSum() {
		// ֱ�Ӵ�N������
		sum(1, 5, 6, 8, 9, 7, 9, 7, 5);

		// ��������Ҳ����
		sum(new int[] { 1, 2, 3, 5, 4, 8, 9 });
	}

	// �ɱ������Ҫע������⣡
	// public void sum2(int ...nums, int x) {
	// }

	// ����ѿɱ����������󣬾�û������
	public void sum3(int x, int... nums) {
	}

	@Test
	public void bb() {
		List list = Arrays.asList("1", "2", "3");
		System.out.println(list);

		String arr[] = { "1", "2", "3" };
		list = Arrays.asList(arr);
		System.out.println(list);

		
		int nums[] = { 1, 2, 3, 5 };
		/*�����ӡ������������ĵ�ַ��
		 * ������Ϊ�ɱ����һ�㴫�ݵĶ��Ƕ������ͣ���int���Ͳ��Ƕ�������asList�����ͻ�ȡ�������������
		 * */
		list = Arrays.asList(nums);
		System.out.println(list);
		
		//�ĳ�ʹ��integer�༴�ɣ�
		Integer nums2[] = { 1, 2, 3, 5 };
		list = Arrays.asList(nums2);
		System.out.println(list);
	}
}
