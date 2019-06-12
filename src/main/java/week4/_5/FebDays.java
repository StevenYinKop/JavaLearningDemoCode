package week4._5;

import java.util.Calendar;
import java.util.Scanner;

public class FebDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1);
        c.add(Calendar.DATE, -1);
        System.out.println("该年2月的天数为："+c.get(Calendar.DATE)+"天");

    }
}
