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
	 * 定义一个接口，并且接口里面仅仅包含一方法，这就相当于是委托了。 如果定义超过1个方法的话，会报错。
	 * 这不禁引起我的一点反思。以前做android的时候，经常会看到各种匿名方法，特别是添加点击监听器的时候。
	 * 当时是先让一个类继承某个Lisnter类的接口，然后接口里面会有一个处理点击的方法，然后在那个方法里面写点击处理的逻辑
	 */
	interface DelegateSum {
		int sum(int a, int b);
	}

	@Test
	public void test1() {
		// 创建一个委托的实例，将Lambda表达式绑定到接口里面的方法去
		DelegateSum delegate1 = (a, b) -> {
			return a + b;
		};
		System.out.println(delegate1.sum(1, 2));

	}

	/* 定义一个自定义的比较器 ,这个比较器继承Comparator接口，并且啥都没写，对比的逻辑在调用的时候动态传入 */
	interface MyCompare extends Comparator<Integer> {
	}

	@Test
	public void test2() {
		/*
		 * 通过lambda表达式注入一个对比的方法，由于参数和返回值跟接口里面的compare方法一致，因此会自动注入
		 */
		MyCompare delegate2 = (a, b) -> {
			// 我这里把比较器对比的代码反过来写了，因此后面排序之后本来应该正向排序的会变成逆向排序
			return b - a;
		};

		List<Integer> data = new ArrayList<Integer>();
		data.add(10);
		data.add(6);
		data.add(77);
		data.add(55);
		data.add(3);
		data.add(87);

		// 然后使用自定义的比较器进行比较
		data.sort(delegate2);

		// 当然也可以这么写
		data.sort((a, b) -> {
			// 我这里把比较器对比的代码反过来写了，因此后面排序之后本来应该正向排序的会变成逆向排序
			return b - a;
		});

		for (Integer integer : data) {
			System.err.print(integer + " ");
		}

		// 后面通过查询，发现还有这种写法，其实这跟我上面的写法是差不多的
		Collections.sort(data, (a, b) -> {
			// 我这里把比较器对比的代码反过来写了，因此后面排序之后本来应该正向排序的会变成逆向排序
			return b - a;
		});
	}

	/* 实现接口的方法 */
	@Override
	public void showMsg() {
		// TODO Auto-generated method stub
		System.out.println("传统方式提示有消息的方法：有消息啦~~~~~");
	}

	/*
	 * 这个例子我结合我自己以往的经验，对比了Lambda表达式注入构建匿名对象与以前方式的差别， 这个例子是通过我以前做 Android
	 * 的时候得出来的经验以及目前学到的内容结合而成的
	 */
	@Test
	public void test3() {
		/*
		 * 如果使用以前那套接口以及实现类的方法，一般来说是这样：先让某个实体类Class(为了偷懒，这里使用了当前的这个类)
		 * 实现某个接口Interface， 然后在那个类Class实现接口需要的方法， 然后调用实现了该接口Interface的对象的某个方法
		 */
		MsgInterface msgHelper = this;
		// 调用发消息的方法
		this.showMsg();

		/* 使用lambda的话，可以绕过实现类，直接将待实现的方法注入到一个实现了接口的匿名类里面，然后再调用这个实现了接口的匿名类下面的方法 */
		MsgInterface msgHelperDel = () -> {
			System.out.println("使用lambda注入的发消息方法：有新的消息啦~~~~~");
		};
		// 传统方式调用发消息的方法
		msgHelperDel.showMsg();

		// 接下来对比两个实现类的类型

		// 首先打印当前类的类型，意料之中:
		// class tengo.lambda.MyLambda
		System.out.println(this.getClass());
		// 然后再打印一下这个匿名类的类型:
		// class tengo.lambda.MyLambda$$Lambda$1/1490180672（不同机器结果或许会不同）
		// 由于这个MsgInterface接口实现类的对象仅仅是通过注入方法生成的一个匿名类的对象，因此可以看到，这个对象的类名是一串莫名其妙的字符
		System.out.println(msgHelperDel.getClass());

		// 再定义一个匿名类并注入方法
		MsgInterface msgHelperDel2 = () -> {
			System.out.println("使用lambda注入的发消息方法222：有新的消息啦222~~~~~");
		};
		msgHelperDel2.showMsg();

		// 然后再打印一下这个匿名类的类型:
		// class
		// tengo.lambda.MyLambda$$Lambda$2/1143839598（不同机器结果或许会不同，但这个类名跟上面的类名肯定是不一样的）
		// 由于这个对象还是实现了接口MsgInterface的匿名类的对象，由此可以看到，系统又给我们生成了一个莫名其妙的类名
		System.out.println(msgHelperDel2.getClass());

	}

	/*
	 * 然后就是喜闻乐见的看系统接口时间: Predicate<T>为JAVA自带的一个包含一个 T->Boolean 类型的接口，日常中可能用的比较多
	 * 就像C#给我们也定义了一些常用的委托类型（如Action<T>、Function<T,T>等等其它重载）一样
	 */
	@Test
	public void testPredicate() {
		Predicate<Integer> pre = p -> p > 10;
		System.out.println("100是否比10大？" + pre.test(100));
		System.out.println("10是否比10大？" + pre.test(10));
		System.out.println("5是否比10大？" + pre.test(5));
	}

	/*
	 * 测试Function<T, T> 不出所料，Function<T,T>也是一个接口，包含单个输入参数与返回结果。
	 * 接收者默认就是调用匿名类的apply方法，而这个方法刚好也是我们通过lambda传进去的
	 */
	@Test
	public void testFunction() {
		// 一个传入值为Integer，返回值为Boolean的方法，判断传入的值是否比10小
		Function<Integer, Boolean> fun1 = p -> p < 10;

		// 一个传入值为String，返回值为Boolean的方法，判断传入的字符串长度是否超过10
		Function<String, Boolean> fun2 = p -> p.length() > 10;

		System.out.println("fun1 apply:" + fun1.apply(80));
		System.out.println("fun2 apply:" + fun2.apply("sasdhkdkashdkhashf"));
	}

	/*
	 * 测试Consumer<T>（即相当于C#里面的Action<T>），即只有输入没有输出的委托类型 , 这个委托包含的方法是accept(T t)
	 */
	@Test
	public void testAction() {
		// 传入一个传入参数为String的方法
		Consumer<String> action = p -> System.out.println(p);

		// 调用这个action内含的方法
		action.accept("HELLO YOU!~~~~");
	}

	/* 测试用lambda对数组集合进行筛选过滤以及遍历等等操作 */
	@Test
	public void lambdaForArrayAndCollections() {
		List<Integer> list = new ArrayList<>();
		list.add(15);
		list.add(13);
		list.add(44);
		list.add(23);
		list.add(1);

		// 使用filter 首先要转成stream()然后才可以调用过滤方法filter,然后还需要把过滤后的书记转化成list，贼麻烦
		List<Integer> list2 = list.stream().filter(p -> p > 20).collect(Collectors.toList());
		System.out.print("大于20的数为：");
		// forEach倒是挺方便的，可以直接使用，不需要转化
		list2.forEach(p -> System.out.print(p + "，"));

		List<String> strList = new ArrayList<>();
		strList.add("asdas");
		strList.add("sacdssssda");
		strList.add("ascdasasdd");
		strList.add("accccsgggdasd");
		strList.add("kkjjjjassdasd");

		List<String> strList2 = strList.stream().filter(p -> p.length() > 10).collect(Collectors.toList());
		System.out.print("\n字符串长度大于10的元素为：");
		strList2.forEach(p -> System.out.print(p + "，"));

		// 以下例子是网上找的 用于统计所有花费
		List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);

		// map的作用是将一个对象变为另外一个，此处对集合内所有花费都 +0.05
		List<Double> cost1 = cost.stream().map(x -> x + x * 0.05).collect(Collectors.toList());
		System.out.println("\n调用map后：");
		cost1.forEach(p -> System.out.print(p + "，"));

		// 而reduce实现的则是将所有值合并为一个，计算总值
		double allCost = cost1.stream().reduce((sum, x) -> sum + x).get();

		System.out.println("\n总共的花费为：" + allCost);
	}
}
