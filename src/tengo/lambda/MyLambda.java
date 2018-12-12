package tengo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

	/*
	 * Ȼ�����ϲ���ּ��Ŀ�ϵͳ�ӿ�ʱ��: Predicate<T>ΪJAVA�Դ���һ������һ�� T->Boolean ���͵Ľӿڣ��ճ��п����õıȽ϶�
	 * ����C#������Ҳ������һЩ���õ�ί�����ͣ���Action<T>��Function<T,T>�ȵ��������أ�һ��
	 */
	@Test
	public void testPredicate() {
		Predicate<Integer> pre = p -> p > 10;
		System.out.println("100�Ƿ��10��" + pre.test(100));
		System.out.println("10�Ƿ��10��" + pre.test(10));
		System.out.println("5�Ƿ��10��" + pre.test(5));
	}

	/*
	 * ����Function<T, T> �������ϣ�Function<T,T>Ҳ��һ���ӿڣ�����������������뷵�ؽ����
	 * ������Ĭ�Ͼ��ǵ����������apply����������������պ�Ҳ������ͨ��lambda����ȥ��
	 */
	@Test
	public void testFunction() {
		// һ������ֵΪInteger������ֵΪBoolean�ķ������жϴ����ֵ�Ƿ��10С
		Function<Integer, Boolean> fun1 = p -> p < 10;

		// һ������ֵΪString������ֵΪBoolean�ķ������жϴ�����ַ��������Ƿ񳬹�10
		Function<String, Boolean> fun2 = p -> p.length() > 10;

		System.out.println("fun1 apply:" + fun1.apply(80));
		System.out.println("fun2 apply:" + fun2.apply("sasdhkdkashdkhashf"));
	}

	/*
	 * ����Consumer<T>�����൱��C#�����Action<T>������ֻ������û�������ί������ , ���ί�а����ķ�����accept(T t)
	 */
	@Test
	public void testAction() {
		// ����һ���������ΪString�ķ���
		Consumer<String> action = p -> System.out.println(p);

		// �������action�ں��ķ���
		action.accept("HELLO YOU!~~~~");
	}

	/* ������lambda�����鼯�Ͻ���ɸѡ�����Լ������ȵȲ��� */
	@Test
	public void lambdaForArrayAndCollections() {
		List<Integer> list = new ArrayList<>();
		list.add(15);
		list.add(13);
		list.add(44);
		list.add(23);
		list.add(1);

		// ʹ��filter ����Ҫת��stream()Ȼ��ſ��Ե��ù��˷���filter,Ȼ����Ҫ�ѹ��˺�����ת����list�����鷳
		List<Integer> list2 = list.stream().filter(p -> p > 20).collect(Collectors.toList());
		System.out.print("����20����Ϊ��");
		// forEach����ͦ����ģ�����ֱ��ʹ�ã�����Ҫת��
		list2.forEach(p -> System.out.print(p + "��"));

		List<String> strList = new ArrayList<>();
		strList.add("asdas");
		strList.add("sacdssssda");
		strList.add("ascdasasdd");
		strList.add("accccsgggdasd");
		strList.add("kkjjjjassdasd");

		List<String> strList2 = strList.stream().filter(p -> p.length() > 10).collect(Collectors.toList());
		System.out.print("\n�ַ������ȴ���10��Ԫ��Ϊ��");
		strList2.forEach(p -> System.out.print(p + "��"));

		// ���������������ҵ� ����ͳ�����л���
		List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
		// map�������ǽ�һ�������Ϊ����һ������reduceʵ�ֵ����ǽ�����ֵ�ϲ�Ϊһ����
		double allCost = cost.stream().map(x -> x + x * 0.05).reduce((sum, x) -> sum + x).get();
		System.out.println("\n�ܹ��Ļ���Ϊ��" + allCost);
	}
}
