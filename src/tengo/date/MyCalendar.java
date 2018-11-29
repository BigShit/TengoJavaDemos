package tengo.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class MyCalendar {

	/*
	 * ʵ������������ʱ��
	 */
	@Test
	public void test1() {
		// ����ʵ����Ĭ���ǵ�ǰ����
		Calendar c = Calendar.getInstance();

		System.out.println();
		// ��������������
		c.set(2009, 6 - 1, 12);

		// ����������ʱ��,ע�⣬�·ݵķ�Χ��0-11,������õ�ֵ����11����ô�ͻ��11���࣬�������������·�
		c.set(2009, 6 - 1, 12, 12, 31);

		// ����������ʱ����
		c.set(2009, 6 - 1, 12, 12, 31, 59);

		// Ҳ�������õ����ֶ�
		c.set(Calendar.YEAR, 2018);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 28);
		// ...

		c = Calendar.getInstance();
		System.out.println("Now is��" + String.format("%1$d-%2$d-%3$d %4$d:%5$d:%6$d:%7$d", // format
				c.get(Calendar.YEAR), // ���
				c.get(Calendar.MONTH) + 1, // ע�⣬�·ݵķ�Χ��0-11,��������ʱ��Ҫ��ȡ�������·�+1
				c.get(Calendar.DATE), // ����
				c.get(Calendar.HOUR_OF_DAY), // 24Сʱ�Ƶ�Сʱ
				c.get(Calendar.MINUTE), // ����
				c.get(Calendar.SECOND), // ��
				c.get(Calendar.MILLISECOND)));// ����
		System.out.println("ʱ��12Сʱ�ƣ���" + c.get(Calendar.HOUR));
		// ������ڼ���ע�⣬1=���գ�2=��һ��3=�ܶ�...
		// ����ǰ�������˵�ϰ�����趨�ģ�����һ������յ�����һ�ܵĵ�һ��
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
	}

	/*
	 * Calendarʱ��ļӼ�
	 */
	@Test
	public void test2() {
		Calendar c = Calendar.getInstance();

		System.out.println("��ǰʱ�䣺" + printCalendar(c));
		c.add(Calendar.YEAR, 10);// ����ݼ�10
		System.out.println("����֮��" + printCalendar(c));

		c = Calendar.getInstance();
		System.out.println("��ǰ���ڣ�" + printCalendar(c));
		c.add(Calendar.DATE, 10);// �����ڼ�10
		System.out.println("�Ӻ����ڣ�" + printCalendar(c));
	}

	// ��ӡCalendar
	public String printCalendar(Calendar c) {
		return String.format("%1$d-%2$d-%3$d %4$d:%5$d:%6$d:%7$d", // format
				c.get(Calendar.YEAR), // ���
				c.get(Calendar.MONTH) + 1, // ע�⣬�·ݵķ�Χ��0-11,��������ʱ��Ҫ��ȡ�������·�+1
				c.get(Calendar.DATE), // ����
				c.get(Calendar.HOUR_OF_DAY), // 24Сʱ�Ƶ�Сʱ
				c.get(Calendar.MINUTE), // ����
				c.get(Calendar.SECOND), // ��
				c.get(Calendar.MILLISECOND));// ����
	}

	/*
	 * �˴�����һ��Calendar������ľ���ʵ���� ����෵��һ��calendar��ʵ������һЩ���Լ�����ķ���
	 */
	@Test
	public void test3() {
		GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
		System.out.println("2018 �Ƿ������꣺" + calendar.isLeapYear(2018));
		System.out.println("2020 �Ƿ������꣺" + calendar.isLeapYear(2020));
	}
}
