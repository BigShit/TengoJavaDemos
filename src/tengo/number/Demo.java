package tengo.number;

import org.junit.Test;

/* ������,���������һ�㶫��,����java����ıȽ�,==�ǱȽϵ�ַ,��equals�ǱȽ�ֵ������ */
public class Demo {
	@Test
	public void test1() {
		int i = 100;
		int j = 100;

		// ��==���űȽϵ��Ƕ���ĵ�ַ�Ƿ����,�������߶���ֵ���ͣ���˱Ƚ�����ȵ�
		System.out.println(i == j);

		/*
		 * Java ��� -128 ~ 127 ���������л��棬���Ե���������������ʼ��ֵλ�� -128 ~ 127 ֮��ʱ����������ʹ����ͬһ��ַ
		 */
		Integer a = 100;
		Integer b = 100;
		// ��==���űȽϵ��Ƕ���ĵ�ַ�Ƿ����
		System.out.println(a == b);
		// equals�Ƚϵ��Ƕ���������Ƿ����
		System.out.println(a.equals(b));

		/*
		 * ������ Integer ��������ֵ���� -128 ~ 127 ��Χʱ, ����ʹ���˲�ͬ�أ��Ϸ������ ��������ͷһ�μ��������趨
		 */
		a = 1200;
		b = 1200;
		// ��==���űȽϵ��Ƕ���ĵ�ַ�Ƿ����
		System.out.println(a == b);
		// equals�Ƚϵ��Ƕ���������Ƿ����
		System.out.println(a.equals(b));
	}

	@Test
	public void test2() {
		/**
		 * Integer i1 = 128; // װ�䣬�൱�� Integer.valueOf(128); int t = i1; //�൱��
		 * i1.intValue() ���� System.out.println(t);
		 */

		/**
		 * ���ڨC128��127��Ĭ����127��֮���ֵ,��װ��󣬻ᱻ�����ڴ���������� ����������������ֵ,ϵͳ������new һ������
		 */
		Integer i1 = 200;
		Integer i2 = 200;

		/**
		 * ע�� == �� equals������ == ���Ƚϵ��Ƕ���ĵ�ַ equals �Ƚϵ��Ƕ��������
		 */
		if (i1 == i2) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}
}
