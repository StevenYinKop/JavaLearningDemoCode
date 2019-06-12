package week5._3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/**
 * 随机(1~30中间)生成7个随机数，注意不能重复
 */
public class RandomGenerator {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		Random rand = new Random();
		while(set.size() < 7) {
			set.add(rand.nextInt(30));
		}
		for (Integer integer : set) {
			System.out.print(integer + "  ");
		}
	}
}
