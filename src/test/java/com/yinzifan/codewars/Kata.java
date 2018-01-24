package com.yinzifan.codewars;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

import org.junit.Test;

import com.yinzifan.utils.MorseCode;

/**
 * @author Cin
 * @time 2018/01/13 20:39:56
 */
public class Kata {
    /*
     * Write a function that takes an (unsigned) integer as input, and returns
     * the number of bits that are equal to one in the binary representation of
     * that number. Example: The binary representation of 1234 is 10011010010,
     * so the function should return 5 in this case
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
     * You might know some pretty large perfect squares. But what about the NEXT
     * one? Complete the findNextSquare method that finds the next integral
     * perfect square after the one passed as a parameter. Recall that an
     * integral perfect square is an integer n such that sqrt(n) is also an
     * integer. If the parameter is itself not a perfect square, than -1 should
     * be returned. You may assume the parameter is positive. Examples:
     * findNextSquare(121) --> returns 144 findNextSquare(625) --> returns 676
     * findNextSquare(114) --> returns -1 since 114 is not a perfect
     */
    public static long findNextSquare(long sq) {
        return (long) ((Math.pow(Math.floor(Math.sqrt(sq)), 2) == sq) ? Math.pow(Math.floor(Math.sqrt(sq)) + 1, 2) : -1);
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
     * Enough is enough! Alice and Bob were on a holiday. Both of them took many
     * pictures of the places they've been, and now they want to show Charlie
     * their entire collection. However, Charlie doesn't like this sessions,
     * since the motive usually repeats. He isn't fond of seeing the Eiffel
     * tower 40 times. He tells them that he will only sit during the session if
     * they show the same motive at most N times. Luckily, Alice and Bob are
     * able to encode the motive as a number. Can you help them to remove
     * numbers such that their list contains each number only up to N times,
     * without changing the order?
     * 
     * Task Given a list lst and a number N, create a new list that contains
     * each number of lst at most N times without reordering. For example if N =
     * 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the
     * next [1,2] since this would lead to 1 and 2 being in the result 3 times,
     * and then take 3, which leads to [1,2,3,1,2,3].
     * 
     * Example EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return
     * [20,37,21] EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) //
     * return [1, 1, 3, 3, 7, 2, 2, 2]
     * 
     */
    public static int[] deleteNth(int[] elements, int maxOcurrences) {
        if (elements.length == 0) {
            return elements;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> blackList = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            if (blackList.contains(elements[i])) {
                continue;
            }
            int count = 0;
            for (Integer integer : list) {
                if (elements[i] == integer) {
                    count++;
                }
            }
            if (count < maxOcurrences) {
                list.add(elements[i]);
            } else {
                blackList.add(elements[i]);
            }
        }
        int[] result = new int[list.size()];
        return Arrays.stream(result).toArray();
    }
    
    public static int[] deleteNth2(int[] elements, int maxOcurrences) {
        List<Integer> args = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : elements) {
            if (map.containsKey(i)) {
                int temp = map.get(i);
                if (temp < maxOcurrences) {
                    args.add(i);
                    map.put(i, map.get(i) + 1);
                }
            } else {
                map.put(i, 1);
                args.add(i);
            }
        }
        int[] array = new int[args.size()];
        int n = 0;
        for (Integer i : args) {
            array[n] = i;
            n++;
        }
        return array;
    }
    
    @Test
    public void deleteNth() throws Exception {
        assertArrayEquals(new int[] { 20, 37, 21 }, Kata.deleteNth(new int[] { 20, 37, 20, 21 }, 1));
        assertArrayEquals(new int[] { 1, 1, 3, 3, 7, 2, 2, 2 }, Kata.deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3)
        
        );
        assertArrayEquals(new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
                Kata.deleteNth(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3));
        assertArrayEquals(new int[] { 1, 1, 1, 1, 1 }, Kata.deleteNth(new int[] { 1, 1, 1, 1, 1 }, 5));
        assertArrayEquals(new int[] {}, Kata.deleteNth(new int[] {}, 5));
    }
    
    /*
     * -----------------------------------------------------------------------
     */
    /*
     * Write a function that accepts an array of 10 integers (between 0 and 9),
     * that returns a string of those numbers in the form of a phone number.
     * Example: Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
     * // => returns "(123) 456-7890" The returned format must be correct in
     * order to complete this challenge. Don't forget the space after the
     * closing parenthesis!
     */
    public static String createPhoneNumber(int[] numbers) {
        return "(" + numbers[0] + numbers[1] + numbers[2] + ") " + numbers[3] + numbers[4] + numbers[5] + "-" + numbers[6] + numbers[7] + numbers[8]
                + numbers[9];
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
    /*
     * Given an array of integers your solution should find the smallest
     * integer. For example: Given [34, 15, 88, 2] your solution will return 2
     * Given [34, -345, -1, 100] your solution will return -345 You can assume,
     * for the purpose of this kata, that the supplied array will not be empty.
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
     * There is a queue for the self-checkout tills at the supermarket. Your
     * task is write a function to calculate the total time required for all the
     * customers to check out! The function has two input variables: customers:
     * an array (list in python) of positive integers representing the queue.
     * Each integer represents a customer, and its value is the amount of time
     * they require to check out. n: a positive integer, the number of checkout
     * tills. The function should return an integer, the total time required.
     * EDIT: A lot of people have been confused in the comments. To try to
     * prevent any more confusion: There is only ONE queue, and The order of the
     * queue NEVER changes, and Assume that the front person in the queue (i.e.
     * the first element in the array/list) proceeds to a till as soon as it
     * becomes free. The diagram on the wiki page I linked to at the bottom of
     * the description may be useful. So, for example: queueTime([5,3,4], 1) //
     * should return 12 // because when n=1, the total time is just the sum of
     * the times queueTime([10,2,3,3], 2) // should return 10 // because here
     * n=2 and the 2nd, 3rd, and 4th people in the // queue finish before the
     * 1st person has finished. queueTime([2,3,10], 2) // should return 12 N.B.
     * You should assume that all the test input will be valid, as specified
     * above. P.S. The situation in this kata can be likened to the
     * more-computer-science-related idea of a thread pool, with relation to
     * running multiple processes at the same time:
     * https://en.wikipedia.org/wiki/Thread_pool
     * 
     */
    public static int solveSuperMarketQueue(int[] customers, int n) {
        int sum = 0;
        if (n == 1) {
            for (int i : customers) {
                sum += i;
            }
            return sum;
        }
        int[] checkouts = new int[n];
        for (int i : customers) {
            checkouts[0] += i;
            Arrays.sort(checkouts);
        }
        return checkouts[checkouts.length - 1];
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
    
    /*
     * -----------------------------------------------------------------------
     */
    /*
     * Don't give me five! In this kata you get the start number and the end
     * number of a region and should return the count of all numbers except
     * numbers with a 5 in it. The start and the end number are both inclusive!
     * 
     * Examples:
     * 
     * 1,9 -> 1,2,3,4,6,7,8,9 -> Result 8 4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17
     * -> Result 12 The result may contain fives. ;-) The start number will
     * always be smaller than the end number. Both numbers can be also negative!
     * 
     * I'm very curious for your solutions and the way you solve it. Maybe
     * someone of you will find an easy pure mathematics solution.
     * 
     * Have fun coding it and please don't forget to vote and rank this kata!
     * :-)
     * 
     * I have also created other katas. Take a look if you enjoyed this kata!
     */
    // Wrong !!
    // public static int dontGiveMeFive(int start, int end) {
    // if (start == end) {
    // if ((start+5) %10 ==0) {
    // return 0;
    // } else {
    // return 1;
    // }
    // }
    // int offset = end - start + 1;
    // int result = 0;
    // if ((end) % 10 > 5) {
    // result++;
    // }
    // if ((start) % 10 < 5) {
    // result++;
    // }
    // result += offset/10 - 1;
    // offset = offset - result;
    // return offset;
    // }
    
    public static int dontGiveMeFive2(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (String.valueOf(i).indexOf("5") == -1) {
                count++;
            }
        }
        return count;
    }
    
    @Test
    public void testDontGiveMeFive() {
        assertEquals(12, Kata.dontGiveMeFive2(4, 17));
        assertEquals(8, Kata.dontGiveMeFive2(1, 9));
        System.out.println(Kata.dontGiveMeFive2(381, 21179));
    }
    
    /*
     * -----------------------------------------------------------------------
     */
    /*
     * You are going to be given an array of integers. Your job is to take that
     * array and find an index N where the sum of the integers to the left of N
     * is equal to the sum of the integers to the right of N. If there is no
     * index that would make this happen, return -1. For example: Let's say you
     * are given the array {1,2,3,4,3,2,1}: Your function will return the index
     * 3, because at the 3rd position of the array, the sum of left side of the
     * index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both
     * equal 6. Let's look at another one. You are given the array
     * {1,100,50,-51,1,1}: Your function will return the index 1, because at the
     * 1st position of the array, the sum of left side of the index ({1}) and
     * the sum of the right side of the index ({50,-51,1,1}) both equal 1. Last
     * one: You are given the array {20,10,-80,10,10,15,35} At index 0 the left
     * side is {} The right side is {10,-80,10,10,15,35} They both are equal to
     * 0 when added. (Empty arrays are equal to 0 in this problem) Index 0 is
     * the place where the left side and right side are equal. Note: Please
     * remember that in most programming/scripting languages the index of an
     * array starts at 0. Input: An integer array of length 0 < arr < 1000. The
     * numbers in the array can be any integer positive or negative. Output: The
     * lowest index N where the side to the left of N is equal to the side to
     * the right of N. If you do not find an index that fits these rules, then
     * you will return -1. Note: If you are given an array with multiple
     * answers, return the lowest correct index. An empty array should be
     * treated like a 0 in this problem.
     */
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int bef = 0;
            int aft = 0;
            for (int j = 0; j < i; j++) {
                bef += arr[j];
            }
            for (int k = i + 1; k < arr.length; k++) {
                aft += arr[k];
            }
            if (bef == aft) {
                return i;
            }
        }
        return -1;
    }
    
    @Test
    public void testFindEvenIndex() {
        assertEquals(3, Kata.findEvenIndex(new int[] { 1, 2, 3, 4, 3, 2, 1 }));
        assertEquals(1, Kata.findEvenIndex(new int[] { 1, 100, 50, -51, 1, 1 }));
        assertEquals(-1, Kata.findEvenIndex(new int[] { 1, 2, 3, 4, 5, 6 }));
        assertEquals(3, Kata.findEvenIndex(new int[] { 20, 10, 30, 10, 10, 15, 35 }));
        assertEquals(-1, Kata.findEvenIndex(new int[] { -8505, -5130, 1926, -9026 }));
        assertEquals(1, Kata.findEvenIndex(new int[] { 2824, 1774, -1490, -9084, -9696, 23094 }));
        assertEquals(6, Kata.findEvenIndex(new int[] { 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4 }));
    }
    
    /*
     * -----------------------------------------------------------------------
     */
    /*
     * In a small town the population is p0 = 1000 at the beginning of a year.
     * The population regularly increases by 2 percent per year and moreover 50
     * new inhabitants per year come to live in the town. How many years does
     * the town need to see its population greater or equal to p = 1200
     * inhabitants? At the end of the first year there will be: 1000 + 1000 *
     * 0.02 + 50 => 1070 inhabitants At the end of the 2nd year there will be:
     * 1070 + 1070 * 0.02 + 50 => 1141 inhabitants (number of inhabitants is an
     * integer) At the end of the 3rd year there will be: 1141 + 1141 * 0.02 +
     * 50 => 1213 It will need 3 entire years. More generally given parameters:
     * p0, percent, aug (inhabitants coming or leaving each year), p (population
     * to surpass) the function nb_year should return n number of entire years
     * needed to get a population greater or equal to p. aug is an integer,
     * percent a positive or null number, p0 and p are positive integers (> 0)
     * Examples: nb_year(1500, 5, 100, 5000) -> 15 nb_year(1500000, 2.5, 10000,
     * 2000000) -> 10 Note: Don't forget to convert the percent parameter as a
     * percentage in the body of your function: if the parameter percent is 2
     * you have to convert it to 0.02.
     */
    
    public static int nbYear(int p0, double percent, int aug, int p) {
        double per = percent / 100;
        int pop = p0;
        int years = 0;
        while (pop < p) {
            pop = (int) (pop + pop * per + aug);
            years++;
        }
        // your code
        return years;
    }
    
    @Test
    public void testNbYear() {
        assertEquals(Kata.nbYear(1500, 5, 100, 5000), 15);
        assertEquals(Kata.nbYear(1500000, 2.5, 10000, 2000000), 10);
        assertEquals(Kata.nbYear(1500000, 0.25, 1000, 2000000), 94);
    }
    
    /*
     * -----------------------------------------------------------------------
     */
    /*
     * The new "Avengers" movie has just been released! There are a lot of
     * people at the cinema box office standing in a huge line. Each of them has
     * a single 100, 50 or 25 dollars bill. An "Avengers" ticket costs 25
     * dollars. Vasya is currently working as a clerk. He wants to sell a ticket
     * to every single person in this line. Can Vasya sell a ticket to each
     * person and give the change if he initially has no money and sells the
     * tickets strictly in the order people follow in the line? Return YES, if
     * Vasya can sell a ticket to each person and give the change with the bills
     * he has at hand at that moment. Otherwise return NO. ###Examples: // ***
     * Java *** Line.Tickets(new int[] {25, 25, 50}) // => YES Line.Tickets(new
     * int []{25, 100}) // => NO. Vasya will not have enough money to give
     * change to 100 dollars
     */
    public static String tickets(int[] peopleInLine) {
        int count25 = 0;
        int count50 = 0;
        
        for (int i : peopleInLine) {
            if (i == 25) {
                count25++;
            }
            if (i == 50) {
                count50++;
                if (count25 < 1) {
                    return "NO";
                }
                count25--;
            }
            if (i == 100) {
                if ((count25 < 3 && count50 == 0) || (count25 == 0 && count50 <= 1)) {
                    return "NO";
                } else if (count50 >= 1 && count25 > 0) {
                    count25--;
                    count50--;
                } else if (count25 >= 3) {
                    count25 -= 3;
                }
            }
        }
        // Your code is here...
        return "YES";
    }
    
    public static String tickets2(int[] peopleInLine) {
        int i, sum=0, change = 0;
        String a = "";
        for(i=0; i<peopleInLine.length; i++) {
            
            sum += 25;
            change = (peopleInLine[i] - 25);
            sum -= change;
            
            if(sum < change) {
              a = "NO";
            }
            else a = "YES";
        }
        return a;
    }
    
    
    
    @Test
    public void testTickets() {
//        assertEquals("YES", Kata.tickets(new int[] { 25, 25, 50 }));
//        assertEquals("NO", Kata.tickets(new int[] { 25, 100, 25, 50, 25, 100 }));
        assertEquals("YES", Kata.tickets2(new int[] { 25, 25, 25, 25, 50, 100, 50}));
    }
    /*
     * -----------------------------------------------------------------------
     */
    /*
     * You are given an array (which will have a length of at least 3, but could be very large) containing integers. 
     * The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. 
     * Write a method that takes the array as an argument and returns this "outlier" N.
        Examples
        [2, 4, 0, 100, 4, 11, 2602, 36]
        Should return: 11 (the only odd number)
        [160, 3, 1719, 19, 11, 13, -21]
        Should return: 160 (the only even number)
     */
    static int find(int[] integers){
        Integer even = null;
        Integer odd = null;
        for(int i = 0; i < integers.length - 1; i++) {
            if(integers[i] % 2 == 0) {
                // even
                if (even != null) {
                    if(odd != null) {
                        return odd;
                    } else {
                        continue;
                    }
                } else {
                    even = integers[i];
                }
            } else {
                if (odd != null) {
                    if(even != null) {
                        return even;
                    } else {
                        continue;
                    }
                } else {
                    odd = integers[i];
                }
            }
        }
        Integer lastEle = integers[integers.length-1];
        if (even == null || odd == null) {
            return lastEle;
        } else {
            return lastEle % 2 == 0 ? odd : even;
        }
    }
    
    public static int find2(int[] integers) {
        // Since we are warned the array may be very large, we should avoid counting values any more than we need to.

        // We only need the first 3 integers to determine whether we are chasing odds or evens.
        // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
        // It will be 0 for even numbers and 1 for odd numbers.
        // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
        int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
        int mod = (sum == 0 || sum == 1) ? 1 : 0;

        return Arrays.stream(integers).parallel() // call parallel to get as much bang for the buck on a "large" array
                .filter(n -> Math.abs(n) % 2 == mod).findFirst().getAsInt();
    }
    
    @Test
    public void testFind() {
        int[] exampleTest1 = {2,6,8,-10,3}; 
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781}; 
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(3, find(exampleTest1));
        assertEquals(206847684, find(exampleTest2));
        assertEquals(0, find(exampleTest3));
    }
    
    /*
     * -----------------------------------------------------------------------
     */
    /*
     * Write a program that will calculate the number of trailing zeros in a factorial of a given number.
        N! = 1 * 2 * 3 * ... * N
        Be careful 1000! has 2568 digits...
        For more info, see: http://mathworld.wolfram.com/Factorial.html
        Examples
        zeros(6) = 1
        # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero
        zeros(12) = 2
        # 12! = 479001600 --> 2 trailing zeros
        Hint: You're not meant to calculate the factorial. Find another way to find the number of zeros.
     */
    public static int zeros(int n) {
        /*
         * 1! = 1 0
         * 2! = 2 0
         * 3! = 6 0
         * 4! = 24 0
         * 5! = 120 1
         * 6! = 720 1
         * 7! = 5040 1
         * 8! = 40320 1
         * 9! = 362880 1
         * 10! = 3628800 2
         */
        int count = 0;
//        for(int i = 5; i <= n; i = i+5) {
//            count++;
//            for(int j = 2 ; Math.pow(5, j) <= i  ;j++) {
//                if(i%Math.pow(5, j)==0) {
//                    count ++;
//                } 
//            }
//        }
//        return count;
        for(int j = 1 ; Math.pow(5, j) <= n  ;j++) {
            for(int i = (int)Math.pow(5, j); i <= n; i = i+(int)Math.pow(5, j)) {
                count++;
            }
        }
        return count;
        
    }
    
    @Test
    public void testZeros() throws Exception {
        assertThat(Kata.zeros(0), is(0)); 
        assertThat(Kata.zeros(6), is(1)); 
        assertThat(Kata.zeros(14), is(2));
        assertThat(Kata.zeros(25), is(6));
        assertThat(Kata.zeros(1266), is(315));
//        zeros(100);
      }
    
    /*
     * -----------------------------------------------------------------------
     */
    /*
     * Once upon a time, on a way through the old wild west,…
        … a man was given directions to go from one point to another. 
        The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, 
        "WEST" and "EAST" too. Going to one direction and coming back the opposite direction is a needless effort. 
        Since this is the wild west, with dreadfull weather and not much water, 
        it's important to save yourself some energy, otherwise you might die of thirst!
        How I crossed the desert the smart way.
        The directions given to the man are, for example, the following:
        
        ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
        or
        { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
        or (haskell)
        
        [North, South, South, East, West, North, West]
        You can immediatly see that going "NORTH" and then "SOUTH" is not reasonable, better stay to the same place! So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
        
        ["WEST"]
        or
        { "WEST" }
        or (haskell)
        
        [West]
        or (rust)
        [WEST];
        Other examples:
        In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away. What a waste of time! Better to do nothing.
        The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).
        In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
        Task
        Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).
        The Haskell version takes a list of directions with data Direction = North | East | West | South. The Clojure version returns nil when the path is reduced to nothing. The Rust version takes a slice of enum Direction {NORTH, SOUTH, EAST, WEST}.
        
        Examples
        dirReduc(@[@"NORTH", @"SOUTH", @"SOUTH", @"EAST", @"WEST", @"NORTH", @"WEST"]); // => @[@"WEST"]
        dirReduc(@[@"NORTH", @"SOUTH", @"SOUTH", @"EAST", @"WEST", @"NORTH"]); // => @[]
        See more examples in "Example Tests"
        Note
        Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
     */
    public static String[] dirReduc(String[] arr) {
        if (arr.length <= 1) return arr;
        LinkedList<String> list = new LinkedList<>();
        Arrays.stream(arr).forEach(list::add);
        for(int i = 0; i< list.size()-1; i++) {
            if(list.get(i).equals("NORTH")&&list.get(i+1).equals("SOUTH") 
                    || list.get(i).equals("SOUTH")&&list.get(i+1).equals("NORTH") 
                    || list.get(i).equals("WEST")&&list.get(i+1).equals("EAST") 
                    || list.get(i).equals("EAST")&&list.get(i+1).equals("WEST") ) { //"NORTHSOUTH,SOUTHNORTH,EASTWEST,WESTEAST".contains(dirs.get(i) + dirs.get(i + 1))
                list.remove(i+1);
                list.remove(i);
                return dirReduc(list.toArray(new String[list.size()]));
            }
        }
        return arr;
    }
    public static String[] dirReduc2(String[] arr) {
        final Stack<String> stack = new Stack<>();
        for (final String direction : arr) {
            final String lastElement = stack.size() > 0 ? stack.lastElement() : null;
            switch(direction) {
                case "NORTH": if ("SOUTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "SOUTH": if ("NORTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "EAST":  if ("WEST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "WEST":  if ("EAST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
            }
        }
        return stack.stream().toArray(String[]::new);
    }
    @Test
    @SuppressWarnings("deprecation")
    public void testSimpleDirReduc() throws Exception {
      assertEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
          new String[]{"WEST"},
          Kata.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));

      assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
          new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
          Kata.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }
    
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        String[] words = morseCode.split("   ");
        StringBuffer sb = new StringBuffer();
        for(String word : words) {
            String[] letters = word.trim().split(" ");
            for(String letter : letters) {
                sb.append(MorseCode.decode(letter));
            }
            sb.append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }
    @Test
    public void testExampleFromDescription() {
      assertThat(Kata.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
    }
    
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";
    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
      int length = ALPHABET.length();
      String[] result = new String[lines.length];
      for(int i = 0; i < lines.length; i++) {
          int[] rotor = rotors[i];
          StringBuffer sb = new StringBuffer();
          sb.append(ALPHABET.charAt(rotor[0]+ALPHABET.indexOf(lines[i])));
          for(int j = 1; j < rotor.length;j++) {
              rotor[j] += rotor[j-1];
              String letter = String.valueOf(lines[i].charAt(j));
              rotor[j] += ALPHABET.indexOf(letter);
              rotor[j] %= length;
              sb.append(ALPHABET.charAt(rotor[j]));
          }
          result[i] = sb.toString();
      }
      return result;
    }

      @Test
      public void example() {
        // CAT => DOG
        String[] before = new String[]{"CAT"};
        int[][] rotors = new int[][]{{1,13,27}};
        String[] after = Kata.flapDisplay(before,rotors);
        String[] expected = new String[]{"DOG"};
        assertArrayEquals(expected, after);
      }

      @Test
      public void basic() {
          // HELLO => WORLD!
          String[] before = new String[]{"HELLO "};
          int[][] rotors = new int[][]{{15,49,50,48,43,13}};
          String[] after = Kata.flapDisplay(before,rotors);
          String[] expected = new String[]{"WORLD!"};
          assertArrayEquals(expected, after);
          
          // CODE => WARS
          String[] before2 = new String[]{"CODE"};
          int[][] rotors2 = new int[][]{{20,20,28,0}};
          String[] after2 = Kata.flapDisplay(before2,rotors2);
          String[] expected2 = new String[]{"WARS"};
          assertArrayEquals(expected2, after2);
      }

}
