package tengo.enumsabs;

import org.junit.Test;

public class Demo {
	@Test
	public void test() {
		System.out.println(Grade.A.localValue());
	}
}

/*�����󷽷���ö��*/
enum Grade { 
	A("90-100"){
		public String localValue() {
			return "��";
		}
	}, 
	B("80-89"){
		public String localValue() {
			return "��";
		}
	},
	C("60-79"){
		public String localValue() {
			return "һ��";
		}
	}, 
	D("60����"){
		public String localValue() {
			return "������";
		}
	};

	// ����涨90-100ΪA��80-89ΪB��60-79ΪC��60����ΪD
	private String value;// ��װÿ�������Ӧ�ķ���

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	/*
	 * ��������������ô����ABCD��ûʲô����ģ�����������й��Ļ������ܱ�ʾ������Χ�ķ�ʽ�Ͳ�һ����
	 * ���й����ܻ�������һ�����������ʾ�ȼ�����ô�Ͳ����������getValue������
	 * ��Ҫ��ö��ֵ������ʱ��ͬʱ����ʾ�����ķ���Ҳͬʱ�涨��
	 * ���������90-100�ֵĻ�����ô�����Ҫ���ظ����š�
	 */
	public abstract String localValue();
}