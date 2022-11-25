package BaseAlgorithm;

import java.util.Scanner;

/**
 * 题目：求 s = a + aa + aaa + aaaa + aaaaa......的值，
 * 其中a是一个数字，例如：2+22+222+2222+22222此时有5个数相加
 * 几个数相加有键盘控制。
 */
public class Test8 {
    public static void main(String[] args) {
        long a = 0;
        long b = 0;
        long sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数字a的值：");
        a = scanner.nextInt();
        System.out.println("输入相加的项数：");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            b = b + a;
            sum = sum + b;
            a = a * 10;
        }
        System.out.println(sum);
    }


}
