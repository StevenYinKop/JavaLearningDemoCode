package week4._4;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Set<VIP> set = new TreeSet<>();
		set.add(new VIP(1, "zhangsan1", 1));
		set.add(new VIP(3, "zhangsan2", 23));
		set.add(new VIP(5, "zhangsan3", 22));
		set.add(new VIP(7, "zhangsan4", 69));
		set.add(new VIP(2, "zhangsan5", 83));
		set.add(new VIP(4, "zhangsan6", 47));
		set.add(new VIP(6, "zhangsan7", 44));
		System.out.println("内部比较器，按照编号进行升序排序");
		for (VIP vip : set) {
			System.out.println(vip.getId());	
		}

		Set<VIP> set2 = new TreeSet<>(new Comparator<VIP>() {
			@Override
			public int compare(VIP o1, VIP o2) {
				return o2.getScore() - o1.getScore();
			}
		});
		set2.add(new VIP(1, "zhangsan1", 1));
		set2.add(new VIP(3, "zhangsan2", 23));
		set2.add(new VIP(5, "zhangsan3", 22));
		set2.add(new VIP(7, "zhangsan4", 69));
		set2.add(new VIP(2, "zhangsan5", 83));
		set2.add(new VIP(4, "zhangsan6", 47));
		set2.add(new VIP(6, "zhangsan7", 44));
		System.out.println("外部比较器，实现按积分降序排序");
		for (VIP vip : set2) {
			System.out.println(vip.getScore());	
		}
		
	}
}
