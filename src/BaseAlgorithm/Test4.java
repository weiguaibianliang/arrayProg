package BaseAlgorithm;

import java.util.Scanner;

/**
 * 将一个正整数分解质因数。例如：输入90，打印出90 = 2*3*3*5.
 */
public class Test4 {
    /**
     * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
     * （1）如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
     * （2）如果n<k,但n能被k整除，则打印出k的值，并用n除以k的商，作为新的正整数n，重新执行第一步。
     * （3）如果n不能被k整除，则用k+1作为k的值，重复执行第一步。
     */
    public static void main(String[] args) {
        System.out.println("请输入一个你要分解的正整数：");
        Scanner scanner = new Scanner(System.in);
        //获取输入的数字
        int n = scanner.nextInt();
        System.out.println();
        System.out.println(n+"=");
        for (int i = 2; i < n+1; i++){
            while(n%i == 0 && n != i){
                n = n/i;
                System.out.println(i+"*");
            }
            //上面的都不能整除，说明这是一个质数
            if(n == i){
                System.out.println(i);
                break;
            }
        }

    }
}
