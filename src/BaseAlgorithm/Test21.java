package BaseAlgorithm;

import java.util.Scanner;

/**
 * 一个五位数，判断它是不是回文数。
 * 即12321是回文数，个位与万位相同，十位与千位相同。
 */
public class Test21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个五位数");
        int a = scanner.nextInt();
        //把数字变为字符串的形式
        String str = a + "";
        //把字符串变为数组的形式
        char[] chars = str.toCharArray();
        if((chars[0]==chars[4]) && (chars[1]==chars[3])){
            System.out.println("这个数是一个回文数");
        }
        else {
            System.out.println("这个数不是一个回文数");
        }
    }
}
