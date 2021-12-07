package cc.stevenyin.itlaoqi.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<Integer, String> cacheMap = new HashMap<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            //10: 1121231234
            //20: 1234512345
            //30: 6123456712
            //40: 3456781234
            //50: 5678912345
            //60: 7891012345
            //70: 6789101112
            //80: 3456789101
            //90: 112
//                int param = in.nextInt() - 1;
            core(in.nextInt() - 1);
        }
    }

    private static void core(Integer param) {
        int startNumber = 1;
        if (param <= 0) {
            System.out.println(getNumByIndex(param, 1));
        } else {
            while (param >= 0) {
                param -= startNumber;
                if (param < 0) {
                    param += startNumber;

                    String resultString = getNumByIndex(param, startNumber);
                    System.out.println(resultString);
                    break;
                }
                startNumber += calculateLength(startNumber + 1);
            }
        }
    }

    public static Integer calculateLength(Integer number) {
        return number.toString().length();
    }

    public static String getNumByIndex(Integer index, Integer lastNumber) {
        Integer number = 1;
        while (index > 0) {
            Integer length = calculateLength(number);
            index -= length;
            if (index < 0) {
                index += length;
                return number.toString().charAt(index) + "";
            } else if (index == 0) {
                return number.toString().charAt(length - 1) + "";
            }
        }
        return "1";
    }
}
