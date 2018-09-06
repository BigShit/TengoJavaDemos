package tengo.enums;

import org.junit.Test;

public class Demo {
	@Test
	public void test() {
		print(Grade.A);
		print(Grade.B);
		print(Grade.C);
		print(Grade.D);
	}

	// ���봫Grade�������ֲ����Լ�new Grade������ֻ�ܴ��涨�õ�ABCD
	public void print(Grade grade) { // ��Ҫ�涨�������ֻ�ܴ���A��B��C��D
		System.out.println(grade.getValue());
	}

	@Test
	public void test2() {
		System.out.println(Grade.C.name());
		System.out.println(Grade.C.ordinal());

		// ���Ӹ���ת��Ϊö�٣�һ����ǰ̨�ύ���ݵ���̨��ʱ����ܻ��õ�
		// ������ǹ涨���ַ����Ļ�����ô�ᱨ��
		String str = "B";
		// Grade grade=Grade.valueOf(Grade.class,str);
		Grade grade = Grade.valueOf(str);
		System.out.println(grade);

		//����ö�����������ֵ
		for (Grade g1 : Grade.values()) {
			System.out.println(g1);
		}
	}
}

/*
 * ���µķ�ʽֱ��ʹ��ö�ټ��ɣ� ��ʵö��Ҳ��һ���࣡ ö��Ҳ���Զ��幹�췽�����ֶΣ��Ӷ���װ�������Ϣ
 */
enum Grade { //
	// A, B, C, D;//Object

	A("90-100"), B("80-89"), C("60-79"), D("60����");

	// ����涨90-100ΪA��80-89ΪB��60-79ΪC��60����ΪD
	private String value;// ��װÿ�������Ӧ�ķ���

	// ö�ٵĹ��캯��������˽�еģ������public�Ļ�����ô���˾Ϳ������new�������ˣ�����ö�ٵķ�Χ�޶��Ծ������ˣ�
	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

/*
 * JAVA5֮ǰ �ϵķ����Ƕ���һ��Grade�࣬Ȼ�����ع��췽����ʹ�����߲������ʵ����������� ��ֻ�ܵ������������Ķ�̬���ԣ� �Ӷ�ʵ������ֵ���޶�
 */
/*
 * class Grade { // �Ȱ� private Grade() { }
 * 
 * public static final Grade A = new Grade(); public static final Grade B = new
 * Grade(); public static final Grade C = new Grade(); public static final Grade
 * D = new Grade();
 * 
 * }
 */