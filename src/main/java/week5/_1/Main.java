package week5._1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
	任务要求
	1.使用集合添加2只老鼠,：淘淘和杰瑞
	2.按照年龄升序排序；(比较器Comparable)
	3.再添加一只杰瑞老鼠，不允许此老鼠添加入集合，因为在老鼠王国不允许同名的老鼠，老鼠名相同了会被认为是同一只老鼠。（重写hashCode和equals）
	4.使用Iterator显示所有老鼠信息；
	5.删除老鼠杰瑞
	6.输出集合中有多少只老鼠
	7.输出第一只和最后一只老鼠。 （15分）
 */
public class Main {
	public static void main(String[] args) {
		Rat taotao = new Rat("taotao", "eating", 5);
		Rat jerry = new Rat("jerry", "tease tom", 3);
		Set<Rat> set = new TreeSet<>();
		// 1.
		set.add(taotao);
		set.add(jerry);
		// 3.
		set.add(jerry);
		// 4.
		Iterator<Rat> iterator = set.iterator();
		while (iterator.hasNext()) {
			Rat rat = (Rat) iterator.next();
			System.out.println("使用Iterator显示所有老鼠信息；" + rat);
		}
		// 5.
		set.remove(jerry);
		// 6.
		System.out.println("当前集合中一共有" + set.size()+"只老鼠");
		// 7.
		Rat[] array = set.toArray(new Rat[] {});
		System.out.println("第一只" + array[0]);
		System.out.println("最后一只" + array[array.length - 1]);
	}
}
