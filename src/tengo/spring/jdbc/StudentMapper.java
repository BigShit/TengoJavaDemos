package tengo.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/* 
 * һ����������ݿ���֮���ӳ��ת����,���ڽ����ݿ�ԭ����ת���ɶ���Object
 * ��Ӧ�������ڻ�û���õ�����reflect��ʱ������������ģʽ��
 * �ȵ����˷���֮����ʵ�Ϳ���ֱ�Ӵ���һ�������Լ������ݣ�Ȼ��Ϳ����÷��������������ˣ��Ͳ���˵һ������һ��Mapper�ˣ�����������
 *  */
public class StudentMapper implements RowMapper<Student> {
	// һ����������ת���ɶ����ӳ�䷽��
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		return student;
	}
}
