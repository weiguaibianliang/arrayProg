package EasyAlgorithm;

import org.junit.Test;

import java.util.Scanner;

/**
 * 斐波那契数列（黄金分割数列）
 * 概述：有一对兔子，从出生后第三个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * f(0)=0,f(1)=1,f(n)=f(n-1)+f(n-2)
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("测试简单的20个算法题目");
    }

    @Test
    public void TestFibonacci() {
        //假设规定15个月时间，看兔子最后的总数
        int month = 15;
        long f1 = 1l, f2 = 1l;
        long f;
        for (int i = 3; i <= month; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println("第" + i + "个月的兔子对数：" + f2);
        }
    }

    @Test
/**
 *判断101-200之间有多少个素数，并输出所有素数。
 * 判断方法：用一个数去除2，如果能整除，则表明次数不是素数，反之是素数。
 * 这个复杂度可能会低一点。
 */
    public void TestSushu() {
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            //默认次数就是素数
            boolean b = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    //次数不是素数
                    b = false;
                    break;
                }
            }
            if (b) {
                count++;
                System.out.println(i + "");
            }
        }
        System.out.println("\n素数的个数：" + count);

    }
    @Test
    /**
     * 打印出所有的水仙花数，所谓水仙花数是指一个三位数，其各位数字立方等于该数本身。
     * 例如：153是一个水仙花数。
     */
    public void test_narcissus(){
        for(int i = 100; i < 1000; i++){
            int a = i/100;
            int b = i%100/10;
            int c = i%100%10;
            if(a*a*a + b*b*b + c*c*c == i){
                System.out.println(i);
            }
        }
    }

    @Test
    /**
     * 将一个正整数分解质因数。例如：输入90，打印出90=2*3*3*5
     * 逻辑：
     * （1）先找到最小的一个质数k，如果这个质数k的值等于n，那么分解质因数结束，直接打印n.
     * （2）如果n>k，但n能被k整除，则打印出k的值，并用n除以k的商，作为新的正整数n,重复执行第一步。
     * （3）如果n不能被k整除，则用k+1作为k的值，重复执行第一步。
     */
    public void test_ZhiYinShu(){
        /*
        Scanner scanner =  new Scanner(System.in);
        //请输入一个正整数
        System.out.println("输入一个正整数：");
        int n = scanner.nextInt();

         */
        int n = 81;
        int k = 2;
        System.out.print(n+"=");
        while (k<=n){
            if(k==n){
                System.out.println(n);
                break;
            }
            else if(n%k==0){
                System.out.print(k+"*");
                n=n/k;
            }
            else if(n%k!=0){
                k++;
            }
        }


    }
    @Test
    /**
     * 打印出杨辉三角
     * 逻辑（杨辉三角的性质）：每行数字左右对称，由1开始逐渐变大，然后变小，回到1.第n行的数字个数为n个。
     * 第n行数字和为2^（n-1）。每个数字等于上一行的左右两个数字之和。可用此性质写出整个杨辉三角形。第n行的第一个数为1，
     * 第二个数为1*（n-1）,第三个数为1*（n-1）*(n-2)/2,第四个数为1*（n-1）*（n-2）/2*(n-3)/3,以此类推。
     */
    public void test_YangHuiSanJiao(){
        //定义一个十行的杨辉三角
        int[][] a = new int[10][10];
        //表示每一行的第一个数和最后一个数都是1
        for(int i = 0;i<10;i++){
            a[i][i] = 1;
            a[i][0] = 1;
        }
        //表示中间的数字等于上一行的左右两个数字之和。
        for(int i =2;i<10;i++){
            for(int j = 1;j<i;j++){
                a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }
        for(int i =0;i<10;i++){
            //加上这个条件的目的是选择什么类型的杨辉三角类型（直角型、等边三角形型）
            for(int k =0;k<2*(10-i)-1;k++){
                System.out.print(" ");
            }
            for(int j =0;j<=i;j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
    }

    @Test
    /**
     * 去两个正整数m和n，求其最大公约数和最小公倍数
     * 逻辑：在循环中，只要除数不为零，用较大的数除以较小的数，将小的数作为下一轮循环的大数，
     * 取得的余数作为下一轮循环的较小的数，如此循环直到较小的数的值为0，返回较大的数，此数即为最小公约数，最小公倍数为
     * 两数之积除以最大公约数。
     *
     * 求最小公倍数的方法：
     * （1）分解质因数的方法
     * （2）公式法
     */
    public void test_Prime(){
        int a = 10;
        int b = 24;
        int m = division(a,b);
        int n = a * b / m;
        System.out.println("最大公约数："+m);
        System.out.println("最小公倍数："+n);
    }
    public int division(int x ,int y){
        int t;
        //判断用较大数除以较小数的条件。
        if(x<y){
            t = x;
            x = y;
            y = t;
        }
        //判断最大公约数的条件。
        while (y!=0){
            if(x==y){
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
    @Test
    /**
     * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
     * 逻辑：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后的结果满足如下条件，即是结果。
     */
    public void test_PerfectSquare(){
        for(long i = 1l;i < 10000;i++){
            if(Math.sqrt(i+100)%1 == 0){
                if(Math.sqrt(i + 268)%1 == 0){
                    System.out.println(i + "加100是一个完全平方数，再加168又是一个完全平方数");
                }
            }
        }
    }

    @Test
    /**
     * 题目：求一个3*3矩阵对角线元素之和
     * 逻辑：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。
     */
    public void test_Sum(){
        int[][] a = new int[3][3];
        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 3;
        a[1][0] = 4;
        a[1][1] = 5;
        a[1][2] = 6;
        a[2][0] = 7;
        a[2][1] = 8;
        a[2][2] = 9;
        System.out.println("输入的3*3矩阵是：");
        for(int i = 0;i < 3;i++){
            for(int j = 0; j < 3;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                if(i==j){
                    sum += a[i][j];
                }
            }
        }
        System.out.println("对角线和是：" + sum);


    }
    @Test
    /**
     * 题目：一个数如果恰好等于它的因子之和，这个数就称为完数。例如 6=1+2+3，编程找出1000以内的所有完数
     * 逻辑：如果p是质数，且2^(p-1)也是质数，那么(2^(p-1))*2^(p-1)便是一个完全数。
     */
    public void test_solution(){
        System.out.println("1到1000的完数有：");
        for(int i =1; i < 1000; i++){
            //每一次循坏开始，t都是重新计算的。
            int t = 0;
            //进行满足条件的累加，然后进行求和。
            for(int j  = 1; j <= i/2; j++){
                if(i % j == 0){
                    t = t + j;
                }
            }
            //判断和是否相等
            if(t == i){
                System.out.println(i + " ");
            }
        }

    }

    @Test
    /**
     * 题目:求s=a+aa+aaa+aaaa+aaaa...aa的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加由键盘控制。
     * 逻辑:定义一个变量b，赋初值为0；定义一变量sum，赋初值为0，进入循环后，将a+b的值赋给b，将sum+b的值赋给sum;同时，将a增加十倍，++i;
     * 继续循环；循环结束后，输出sum的值。
     */
    public void test_asum(){
        long a = 2, b = 0;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0;
        long sum = 0;
        while (i < n){
            b = b + a;
            sum = sum + b;
            a = a * 10;
            ++i;
        }
        System.out.println("input number:" + n);
        System.out.println(sum);
    }

    @Test
    /**
     * 题目：有1、2、3、4,4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     * 逻辑：可填在百位、十位、个位的数字都是1、2、3、4.组成所有的排列后再去掉不满足条件的排列。
     */
    public void test_AC(){
        int count = 0;
        for(int x = 1; x < 5;x++){
            for(int y = 1;y < 5; y++){
                for(int z = 1; z <5; z++){
                    //判断没有重复数字的条件。
                    if(x!=y&&x!=z&&y!=z){
                        count++;
                        System.out.print(x*100 + y*10 + z +" ");
                        //这个是为了让结果更加明显，更加规范。
                        if(count%6==0){
                            System.out.println();
                        }
                    }
                }
            }
        }
        System.out.println("共有" + count + "个三位数");
    }

}

