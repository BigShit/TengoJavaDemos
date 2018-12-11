package tengo.lambda;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class MyLambda implements MsgInterface {

	/*
	 * ����һ���ӿڣ����ҽӿ������������һ����������൱����ί���ˡ� ������峬��1�������Ļ����ᱨ��
	 * �ⲻ�������ҵ�һ�㷴˼����ǰ��android��ʱ�򣬾����ῴ�����������������ر�����ӵ����������ʱ��
	 * ��ʱ������һ����̳�ĳ��Lisnter��Ľӿڣ�Ȼ��ӿ��������һ���������ķ�����Ȼ�����Ǹ���������д���������߼�
	 */
	interface DelegateSum {
		int sum(int a, int b);
	}

	@Test
	public void test1() {
		// ����һ��ί�е�ʵ������Lambda���ʽ�󶨵��ӿ�����ķ���ȥ
		DelegateSum delegate1 = (a, b) -> {
			return a + b;
		};
		System.out.println(delegate1.sum(1, 2));

	}

	/* ����һ���Զ���ıȽ��� ,����Ƚ����̳�Comparator�ӿڣ�����ɶ��ûд���Աȵ��߼��ڵ��õ�ʱ��̬���� */
	interface MyCompare extends Comparator<Integer> {
	}

	@Test
	public void test2() {
		/*
		 * ͨ��lambda���ʽע��һ���Աȵķ��������ڲ����ͷ���ֵ���ӿ������compare����һ�£���˻��Զ�ע��
		 */
		MyCompare delegate2 = (a, b) -> {
			// ������ѱȽ����ԱȵĴ��뷴����д�ˣ���˺�������֮����Ӧ����������Ļ�����������
			return b - a;
		};

		List<Integer> data = new ArrayList<Integer>();
		data.add(10);
		data.add(6);
		data.add(77);
		data.add(55);
		data.add(3);
		data.add(87);

		// Ȼ��ʹ���Զ���ıȽ������бȽ�
		data.sort(delegate2);

		// ��ȻҲ������ôд
		data.sort((a, b) -> {
			// ������ѱȽ����ԱȵĴ��뷴����д�ˣ���˺�������֮����Ӧ����������Ļ�����������
			return b - a;
		});

		for (Integer integer : data) {
			System.err.print(integer + " ");
		}

		// ����ͨ����ѯ�����ֻ�������д������ʵ����������д���ǲ���
		Collections.sort(data, (a, b) -> {
			// ������ѱȽ����ԱȵĴ��뷴����д�ˣ���˺�������֮����Ӧ����������Ļ�����������
			return b - a;
		});
	}

	/* ʵ�ֽӿڵķ��� */
	@Override
	public void showMsg() {
		// TODO Auto-generated method stub
		System.out.println("��ͳ��ʽ��ʾ����Ϣ�ķ���������Ϣ��~~~~~");
	}

	/*
	 * ��������ҽ�����Լ������ľ��飬�Ա���Lambda���ʽע�빹��������������ǰ��ʽ�Ĳ�� ���������ͨ������ǰ�� Android
	 * ��ʱ��ó����ľ����Լ�Ŀǰѧ�������ݽ�϶��ɵ�
	 */
	@Test
	public void test3() {
		/*
		 * ���ʹ����ǰ���׽ӿ��Լ�ʵ����ķ�����һ����˵������������ĳ��ʵ����Class(Ϊ��͵��������ʹ���˵�ǰ�������)
		 * ʵ��ĳ���ӿ�Interface�� Ȼ�����Ǹ���Classʵ�ֽӿ���Ҫ�ķ����� Ȼ�����ʵ���˸ýӿ�Interface�Ķ����ĳ������
		 */
		MsgInterface msgHelper = this;
		// ���÷���Ϣ�ķ���
		this.showMsg();

		/* ʹ��lambda�Ļ��������ƹ�ʵ���ֱ࣬�ӽ���ʵ�ֵķ���ע�뵽һ��ʵ���˽ӿڵ����������棬Ȼ���ٵ������ʵ���˽ӿڵ�����������ķ��� */
		MsgInterface msgHelperDel = () -> {
			System.out.println("ʹ��lambdaע��ķ���Ϣ���������µ���Ϣ��~~~~~");
		};
		// ��ͳ��ʽ���÷���Ϣ�ķ���
		msgHelperDel.showMsg();

		// �������Ա�����ʵ���������

		// ���ȴ�ӡ��ǰ������ͣ�����֮��:
		// class tengo.lambda.MyLambda
		System.out.println(this.getClass());
		// Ȼ���ٴ�ӡһ����������������:
		// class tengo.lambda.MyLambda$$Lambda$1/1490180672����ͬ�����������᲻ͬ��
		// �������MsgInterface�ӿ�ʵ����Ķ��������ͨ��ע�뷽�����ɵ�һ��������Ķ�����˿��Կ�������������������һ��Ī��������ַ�
		System.out.println(msgHelperDel.getClass());

		// �ٶ���һ�������ಢע�뷽��
		MsgInterface msgHelperDel2 = () -> {
			System.out.println("ʹ��lambdaע��ķ���Ϣ����222�����µ���Ϣ��222~~~~~");
		};
		msgHelperDel2.showMsg();

		// Ȼ���ٴ�ӡһ����������������:
		// class
		// tengo.lambda.MyLambda$$Lambda$2/1143839598����ͬ�����������᲻ͬ�����������������������϶��ǲ�һ���ģ�
		// �������������ʵ���˽ӿ�MsgInterface��������Ķ����ɴ˿��Կ�����ϵͳ�ָ�����������һ��Ī�����������
		System.out.println(msgHelperDel2.getClass());
	}
}
