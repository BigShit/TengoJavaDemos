package tengo.javabean;

/*
 * ��������һ��JavaBean
 * ���Bean������3���ֶ�id��name��age;
 * ��4������ id��name��age��Ab
 * ���Բ����ֶξ�����������Get��Set���⿪����ֵ������
 * Ab��Ȼû���ֶ�֧�ţ�����������get����Set����������Ҳ����һ������
 * */
public class Person {
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAb() {
		return "";
	}

}
