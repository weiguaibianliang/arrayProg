package BaseAlgorithm;

import java.util.Scanner;

/**
 * 输入两个正整数m和n，求其最大公约数和最小公倍数
 */
public class Test6 {
    /**
     * 程序分析：在循环中，只要除数不等于0，用较大数除以最小的数，将小的一个数作为下一轮循环的大数，
     * 取得的余数作为下一轮循环的较小的数，如此循环直到较小的数的值为0，返回较大的数，此数即为最大公约数，
     * 最小公倍数为两数之积除以最大公约数。
     */
    public static void main(String[] args) {
        System.out.println("输入两个正整数m和n");
        Scanner scanner = new Scanner(System.in);
        //输入的整数m
        int m = scanner.nextInt();
        //输入的整数n
        int n = scanner.nextInt();
        //创建一个方法来判断最大公约数
        int a = division(m,n);
        //最小公倍数是由最大公约数的关系可得。
        int b = m*n/a;
        System.out.println("最大公约数："+ a);
        System.out.println("最大公倍数："+ b);
    }

    private static int division(int x, int y) {
        int t;
        if(x < y){
            t = x;
            x = y;
            y = t;
        }
        while (y != 0){
            if(x == y){
                return 1;
            }
            else {
                int k = x % y;
                x = y;
                y = k;
            }
        }
        return x;
    }

}
