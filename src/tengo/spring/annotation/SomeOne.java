package tengo.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SomeOne {

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	// ���������Զ�װ�䣬������xml�ļ�����Ͳ���Ҫдproperty�����ӵ������ˣ���ܻ��Զ�����������bean����Ӧ��bean�����
	@Autowired
	//�����кܶ������ΪStudent��bean���˴�����װ��student1
	@Qualifier("student1")
	private Student student;

	public SomeOne() {
	}
}
