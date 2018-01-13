package com.yinzifan.codewars;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
* @author Cin
* @time 2018/01/13 20:39:56
*/
public class Kata {
	/*
	* Write a function that takes an (unsigned) integer as input, and returns the number of bits that are equal to one in the binary representation of that number.
	* Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
	*/
	public static int countBits3(int n) {
		char[] charArray = Integer.toBinaryString(n).toCharArray();
		int count = 0;
		for (char c : charArray) {
			if (c == '1') {
				count++;
			}
		}
		return count;
	}

	public static int countBits2(int n) {
		return Integer.bitCount(n);
	}

	public static int countBits(int n) {
		String binaryString = Integer.toBinaryString(n);
		return binaryString.replace("0", "").length();
	}

	@Test
	public void testGame() {
		assertEquals(5, Kata.countBits(1234));
		assertEquals(1, Kata.countBits(4));
		assertEquals(3, Kata.countBits(7));
		assertEquals(2, Kata.countBits(9));
		assertEquals(2, Kata.countBits(10));
	}

	/*
	 * -----------------------------------------------------------------------
	 */
	/*
	 * find the shortest word in a sentence
	 */
	public static int findShort(String s) {
		String[] arr = s.split(" ");
		int min = arr[0].length();
		for (String string : arr) {
			if (string.length() < min) {
				min = string.length();
			}
		}
		return min;
	}

	public static int findShort2(String s) {
		return Stream.of(s.split(" ")).mapToInt(String::length).min().getAsInt();
	}

	@Test
	public void findShort() throws Exception {
		assertEquals(3, Kata.findShort("bitcoin take over the world maybe who knows perhaps"));
		assertEquals(3, Kata.findShort("turns out random test cases are easier than writing out basic ones"));
	}

	/*
	 * -----------------------------------------------------------------------
	 */
	/*
	*You might know some pretty large perfect squares. But what about the NEXT one?
	*Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
	*If the parameter is itself not a perfect square, than -1 should be returned. You may assume the parameter is positive.
	*Examples:
	*findNextSquare(121) --> returns 144
	*findNextSquare(625) --> returns 676
	*findNextSquare(114) --> returns -1 since 114 is not a perfect
	 */
	public static long findNextSquare(long sq) {
		return (long) ((Math.pow(Math.floor(Math.sqrt(sq)), 2) == sq) ? Math.pow(Math.floor(Math.sqrt(sq)) + 1, 2)
				: -1);
	}

	public static long findNextSquare2(long sq) {
		long root = (long) Math.sqrt(sq);
		return root * root == sq ? (root + 1) * (root + 1) : -1;
	}

	@Test
	public void test1() throws Exception {
		assertEquals(144, Kata.findNextSquare(121));
		assertEquals(676, Kata.findNextSquare(625));
		assertEquals(-1, Kata.findNextSquare(114));
		assertEquals(676, Kata.findNextSquare(625));
	}

	/*
	 * -----------------------------------------------------------------------
	 */
	/*
	 * Enough is enough!
	Alice and Bob were on a holiday. 
	Both of them took many pictures of the places they've been, 
	and now they want to show Charlie their entire collection. 
	However, Charlie doesn't like this sessions, 
	since the motive usually repeats. He isn't fond of seeing the Eiffel tower 40 times. 
	He tells them that he will only sit during the session if they show the same motive at most N times. 
	Luckily, Alice and Bob are able to encode the motive as a number. 
	Can you help them to remove numbers such that their list contains each number only up to N times, 
	without changing the order?
	
	Task
	Given a list lst and a number N, 
	create a new list that contains each number of lst at most N times without reordering.
	For example if N = 2, and the input is [1,2,3,1,2,1,2,3], 
	you take [1,2,3,1,2], 
	drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, 
	and then take 3, which leads to [1,2,3,1,2,3].
	
	Example
	EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
	EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]
	 * 
	 */
	public static int[] deleteNth(int[] elements, int maxOcurrences) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < elements.length; i++) {
			int count = 0;
			for (Integer integer : list) {
				if (elements[i] == integer) {
					count++;
				}
			}
			if (count < maxOcurrences) {
				list.add(elements[i]);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	@Test
	public void deleteNth() throws Exception {
		assertArrayEquals(new int[] { 20, 37, 21 }, Kata.deleteNth(new int[] { 20, 37, 20, 21 }, 1));
		assertArrayEquals(new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
				Kata.deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3)

		);
		assertArrayEquals(new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
				Kata.deleteNth(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3));
		assertArrayEquals(new int[] { 1, 1, 1, 1, 1 }, Kata.deleteNth(new int[] { 1, 1, 1, 1, 1 }, 5));
		assertArrayEquals(new int[] {}, Kata.deleteNth(new int[] {}, 5));
	}

	/*
	 * -----------------------------------------------------------------------
	 */
	/*Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
		Example:
		Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
		The returned format must be correct in order to complete this challenge. 
		Don't forget the space after the closing parenthesis!
	 */
	public static String createPhoneNumber(int[] numbers) {
		return "(" + numbers[0] + numbers[1] + numbers[2] + ") " + numbers[3] + numbers[4] + numbers[5] + "-"
				+ numbers[6] + numbers[7] + numbers[8] + numbers[9];
	}

	public static String createPhoneNumber2(int[] numbers) {
		return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
	}

	public static String createPhoneNumber3(int[] numbers) {
		String phoneNumber = new String("(xxx) xxx-xxxx");

		for (int i : numbers) {
			phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
		}

		return phoneNumber;
	}

	@Test
	public void testCreatePhoneNumber() {
		assertEquals("(123) 456-7890", Kata.createPhoneNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
	}

	/*
	 * -----------------------------------------------------------------------
	 */
	/*Given an array of integers your solution should find the smallest integer.
		For example:
		Given [34, 15, 88, 2] your solution will return 2
		Given [34, -345, -1, 100] your solution will return -345
		You can assume, for the purpose of this kata, that the supplied array will not be empty.
	 */
	public static int findSmallestInt(int[] args) {
		int min = Integer.MAX_VALUE;
		for (int i : args) {
			min = i < min ? i : min;
		}
		return min;
	}

	public static int findSmallestInt2(int[] args) {
		Arrays.sort(args);
		return args[0];
	}

	@Test
	public void testFindSmallestInt() {
		int expected = 11;
		int actual = Kata.findSmallestInt(new int[] { 78, 56, 232, 12, 11, 43 });
		assertEquals(expected, actual);
	}

	/*
	 * -----------------------------------------------------------------------
	 */
	/*
	 * There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate the total time required for all the customers to check out!
	The function has two input variables:
	customers: an array (list in python) of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
	n: a positive integer, the number of checkout tills.
	The function should return an integer, the total time required.
	EDIT: A lot of people have been confused in the comments. To try to prevent any more confusion:
	There is only ONE queue, and
	The order of the queue NEVER changes, and
	Assume that the front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
	The diagram on the wiki page I linked to at the bottom of the description may be useful.
	So, for example:
	queueTime([5,3,4], 1)
	// should return 12
	// because when n=1, the total time is just the sum of the times
	queueTime([10,2,3,3], 2)
	// should return 10
	// because here n=2 and the 2nd, 3rd, and 4th people in the 
	// queue finish before the 1st person has finished.
	queueTime([2,3,10], 2)
	// should return 12
	N.B. You should assume that all the test input will be valid, as specified above.
	P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool, with relation to running multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_pool
	 * 
	 */
	public static int solveSuperMarketQueue(int[] customers, int n) {
		return 0;
	}

	@Test
	public void testNormalCondition() {
		assertEquals(9, Kata.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
	}

	@Test
	public void testEmptyArray() {
		assertEquals(0, Kata.solveSuperMarketQueue(new int[] {}, 1));
	}

	@Test
	public void testSingleTillManyCustomers() {
		assertEquals(15, Kata.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
	}
}
