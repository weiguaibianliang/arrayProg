package BaseAlgorithm;

import java.util.Scanner;

/**
 * 给一个不多于5位的正整数，要求：
 * 一、求它是几位数，二、逆序打印各位数字。
 */
public class Test20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个不多于5位的正整数：");
        int a = scanner.nextInt();
        //把数字转为字符串的形式。
        String str = a + "";
        //表示需要格式化输出
        System.out.printf("它是%d位数\n",str.length());
        //StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        //将数字进行反转，就是逆序的意思。
        System.out.println("逆序：" + sb.reverse());
    }
}
