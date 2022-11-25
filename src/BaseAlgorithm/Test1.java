package BaseAlgorithm;

import java.util.Scanner;

/**
 * 有一对兔子，从出生后第三个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月
 * 的兔子对数为多少？程序分析：兔子的规律为数列：1,1,2,3,5,8,13,21.....
 */
//相当于一个斐波那契数列
public class Test1 {
     //面对这种题要分析一下题意，找出规律：f（0） = 0，f(1) = 1,f(n) = f(n-1) + f(n-2).
    //想知道某个月的兔子的个数
     public static void main(String[] args) {
         System.out.println("输入你想知道兔子个数的月份");
         Scanner scanner = new Scanner(System.in);
         int n = scanner.nextInt();

         int f1 = 1;
         int f2 = 1;
         //定义一个临时变量，
         int f = 0;
         for (int i = 3; i <= n; i++){
            f = f2;
            f2 = f1 + f2;
            f1 = f;
         }
         System.out.println("得到n月份兔子的个数"+ f2);

     }
}
