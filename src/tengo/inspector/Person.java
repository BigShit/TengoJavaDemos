package tengo.inspector;

//������װ���ֶγ�Ϊ���Ե���ͳ�Ϊjavabean��һ��������װ����
//�ֶ�ֻ��������get��set����֮�����bean���������ԣ��ֶζ����ṩ��get����set֮������ֶβ��ܳ�֮Ϊ����
//Ȼ������]���ֶ���Ϊ֧�ţ�ֻҪ����get����set����Ҳ���Ƕ���һ������
//Ŀǰ������Ȼ��5�����ԣ���Ϊ�����඼�̳���Object����Object�����и�������getClass������Ҳ��һ��
public class Person {
	public Person() {

	}

	public String name = "aaa"; // �ֶ�
	private String password = "111111";
	private static int age = 1;

	//���û���ֶ�֧�ţ�����Ҳ����һ������
	public String getAb() {
		return null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getAge() {
		return age;
	}

	public static void setAge(int age2) {
		Person.age = age2;
	}

}
