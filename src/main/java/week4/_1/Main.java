package week4._1;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”     
 * @author Cin
 *
 */
public class Main {
	public static String reverse(String original, int start, int end) {
		String subStr = original.substring(start, end);
		char[] subChar = subStr.toCharArray();
		char[] resultChar = new char[subChar.length];
		for(int i = 0; i < subChar.length; i ++) {
			resultChar[i] = subChar[subChar.length - 1 - i];
		}
		StringBuilder sb = new StringBuilder();
		sb.append(original.substring(0, start));
		sb.append(resultChar);
		sb.append(original.substring(end, original.length()));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("1234567890", 0, 10));
	} 
}
