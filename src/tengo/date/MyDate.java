package tengo.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/*Date���͵����Ӧ��*/
public class MyDate {

	/* ʱ��ļ򵥸�ʽ�� */
	@Test
	public void test1() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS��\n y�ꡣ\n M�¡�\n d�ա�\n Hʱ��\n m�֡�\n s�롣\n S���롣\n����ʱ�Σ�a�� \n��ǰ���ڣ�E��\n�����е�D�졣\nʱ��z��\n�����е�W�ܡ�\n����ȵ�w�ܡ�\n");
		System.out.println("������:" + format.format(date));
	}

	/* ʱ��ıȽϣ�����0��ʾ�ȴ����ֵ��С��0��ʾ�ȴ����ֵС������0����ʱ����� */
	@Test
	public void test2() {
		System.out.println("�Ƚ�ʱ��С��: " + new Date(2018, 1, 1).compareTo(new Date(2019, 1, 1)));
		System.out.println("�Ƚ�ʱ�����: " + new Date(2019, 1, 1).compareTo(new Date(2019, 1, 1)));
		System.out.println("�Ƚ�ʱ�����: " + new Date(2020, 1, 1).compareTo(new Date(2019, 1, 1)));
	}

	/*
	 * ʹ��ʱ���������ʱ��,����1970��1��1�� ע�⣬������д����long���͵����֣���������ֺ�����˸�l
	 */
	@Test
	public void test3() {
		Date date = new Date(1542958839797l);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		System.out.println("ʱ�����Ӧ��ʱ��Ϊ:" + format.format(date));
	}

	/* ���ַ�������ʱ���ʽ��ת��ʱ�� */
	@Test
	public void test4() {
		String dateStr = "2018-11-23 16:22:33:236";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

		try {
			Date date = format.parse(dateStr);
			System.out.println("���ַ���ת���ɵ�ʱ��Ϊ:" + format.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/* ����ʱ������һ����ת���ɺ�������Ȼ��������ó� */
	@Test
	public void test5() {
		Date date1 = new Date(2018, 11, 26);
		Date date2 = new Date(2018, 11, 1);
		long diff = date1.getTime() - date2.getTime();
		System.out.println("����ʱ��Ĳ�ֵ(������)Ϊ:" + diff);
	}
	
	/*
	 * ���һ��ʱ����Ҫͬʱ������ָ�ʽ�Ļ��������SimpleDateFormat�Ļ����ͻ᲻�����ˣ���������
	 * SimpleDateFormat format1=xxx
	 * SimpleDateFormat format2=xxx
	 * SimpleDateFormat format3=xxx
	 * ...
	 * �ѵ�����Ҫ����N����ʽô��
	 * ��Ȼ���á���JAVA��������Ӧ�ĸ�ʽ���ķ�����
	 * ��String�ĸ�ʽ��
	 * ���� String.fomat��fomat,args��������������%t��ʾ��ʽ������һ��date���ͣ�
	 * F�����ʽ��ʱ���Ӧ�ĸ�ʽ
	 * ת  ��  ��                                         ˵    ��                                                               ʾ    ��
     * 	 c          ����ȫ�����ں�ʱ����Ϣ                               ������ ʮ�� 27 14:21:20 CST 2007
	 *   F          "��-��-��"��ʽ					  2007-10-27
	 *   D			"��/��/��"��ʽ					  10/27/07
	 *   r			"HH:MM:SS PM"��ʽ��12ʱ�ƣ�		  02:25:51 ����	
	 *   T			"HH:MM:SS"��ʽ��24ʱ�ƣ�		  14:28:16
	 *   R			"HH:MM"��ʽ��24ʱ�ƣ�			  14:28
	 * */
	@Test
	public void test6() {
		Date date = new Date();

		// �����һ����ʽ��
		System.out.println(String.format("��-��-�ո�ʽ��%tF", date));
		System.out.println(String.format("ʱ:��:���ʽ��%tT", date));

		/*
		 * ���Ҫ��������ʽ���Ļ�����ô��������һЩ��ͬ�ˡ�
		 * ��������һ����ʽ���ַ���ָ��Ҫ����ʽ���Ĳ�����������
		 * �������������%���棬���ұ�����$���������磺*/
		System.out.println(String.format("%1$s��%2$tF %2$tT", "the date is", date));
		System.out.println(String.format("%1$s��%2$tD %2$tr %2$tR", "the date is", date));
	}

}
