package practice;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class FirstPractice04 {
}
class Test0041{
    /*
    合并两个有序数组
     */
    public static void main(String[] args) {
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        nums1[3] = 0;
        nums1[4] = 0;
        nums1[5] = 0;
        int[] nums2 = new int[3];
        nums2[0] = 2;
        nums2[1] = 5;
        nums2[2] = 6;
        int temp;
        /*
        for(int i = 0;i<nums1.length;i++){
            System.out.println(Arrays.toString(nums1[i]));
        }
         */
        for (int i = 0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                //int temp =0;
                //temp=nums2[j];
                //nums2[j] = nums1[nums1.length-nums2.length+j];
                //nums1[nums1.length-nums2.length+j]=temp;
                //nums1[nums1.length-nums2.length+j] = nums2[j];
                 nums1[nums1.length-nums2.length+j] = nums2[j];

                //System.out.print(nums1);
                //for(int i = 0;i<nums1.length;i++){
                }
            System.out.print(nums1[i]);
            }
            //Arrays.sort(nums1);
        }

    }
class Test041{
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        Scanner scanner = new Scanner(System.in);
        //读入一个整数n
        System.out.println("读入一个整数n");
        int n = scanner.nextInt();
        for(int i =0;i<arr.length;i++){
            if(n==arr[i]){
                System.out.println(i);
            }
            if(n!=arr[i]){
                System.out.println("输出是-1");
            }
        }
    }
}
//编程题第二题
class Test042{
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6}};
        //创建一个新的数组来调用一个转置方法。
        int[][] newNums = transposition(nums);
        //为了把转置后的数组打印出来
        for(int i =0;i<newNums.length;i++){
            System.out.println(Arrays.toString(newNums[i]));
        }
    }
    static int[][] transposition(int[][] nums){
        int m = nums.length;
        int n = nums[1].length;
        int[][] newNums = new int[n][m];
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                newNums[j][i] = nums[i][j];
            }
        }
        return newNums;
    }
}
//编程题3
class Test043{
    /*
    给定一个数组，将这个数组的所有元素的顺序进行颠倒
     */
    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5,6,7,8,9,0};
        int min = 0;
        int max = nums.length-1;
        int temp = 0;
        for(int i =0;i<nums.length;i++){
            if(min<max){
                temp = nums[min];
                nums[min] = nums[max];
                nums[max] = temp;
                min++;
                max--;
            }
        }
        for(int num:nums){
            System.out.print(num+"\t");
        }

    }
}
//编程题4
class Test044{
    //输出杨辉三角
    //第一种方法，先创建一个矩形数组，然后赋值成一个像杨辉三角的数组。
    /*
    public static void main(String[] args) {
        //先定义一个五行五列的数组矩阵
        int[][] nums = new int[5][5];
        for(int i =0;i<nums.length;i++){
            for(int j =0;j<=i;j++){
                //System.out.print(nums[i][j]+"\t");
                if(j==0||j==i){
                    nums[i][j]=1;
                }
                else {
                    nums[i][j] = nums[i-1][j-1]+nums[i-1][j];
                }
                System.out.print(nums[i][j]+"\t");
            }
            System.out.println();
        }
    }

     */
    //使用第二种方法，先创建一个像杨辉三角的数组，然后再根据关系进行赋值。
    public static void main(String[] args) {
        int[][] nums = new int[10][];
        for(int i =0;i<nums.length;i++){
            //
            nums[i] = new int[i+1];
        }
        for(int i=0;i<nums.length;i++){
            for(int j = 0;j<nums[i].length;j++){
                if(j==0||j==i){
                    nums[i][j]=1;
                }
                else {
                    nums[i][j] = nums[i-1][j-1]+nums[i-1][j];
                }
            }
        }
        /*
        for(int i = 0;i<nums.length;i++){
            for(int j =0;j<nums[i].length;j++){
                System.out.print(nums[i][j]+"\t");
            }
            System.out.println();
        }

         */
        for(int i = 0;i<nums.length;i++){
            int num = (nums.length-i)/2;
            for(int k =0;k<=num;k++){
                System.out.print("\t");
            }
            for(int j = 0;j<nums[i].length;j++){
                System.out.print(nums[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
//编程题5
class Test045{
    /*
    15个猴子围成一圈选大王，依次1-7循环报数，报到7的猴子被淘汰，直到最后一只猴子成为大王。
    问:哪只猴子会成为大王？
     */
    /*
    思路：
    1、定义一个长度为15的数组，元素值代表了15只猴子的编号
    2、
     */
    public static void main(String[] args) {
        //功能：定义数组并向每个下标赋值
        int[] arr = new int[15];
        for(int i =0;i<arr.length;i++){
            arr[i] = i;
        }
        //调用example方法，并由arr接收返回值
        //
    }
    public static int[] example(int[] arr) {
        int counter = 0;
        return arr;
    }
}
class Test051 {
    public static void main(String[] args) {
        /*
        这个是建立构造函数
        System.out.println(sum(3,5));
    }
    public static int sum(int a,int b){
        int sum1 = a+b;
        return sum1;
    }

         */
        Test051 t = new Test051();
        t.sum(3,5);

    }
    void sum(int a,int b){
        int sum1 = a+b;
        System.out.println(sum1);
    }
}
class Test052{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //随便输入一个整数
        System.out.println("随便输入一个整数n");
        int n = scanner.nextInt();
        Test052 t = new Test052();
        t.printAll(n);
    }
    void printAll(int n){
        for(int i =1;i<=n;i++){
            if(n%i==0){
                System.out.println(i);
            }
        }
    }
}
class Test053{
    public static void main(String[] args) {
        Test053 t = new Test053();
        t.addAll(100);
    }
    public void addAll(int n){
        int sum = 0;
        for(int i =1;i<=n;i++){
            sum = sum+i;
        }
        System.out.println(sum);
    }
}
class Ex2{
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        expand(a);
        changeArray(a);
        printArray(a);
    }
    public static void expand(int[] a){
        int[] newArray = new int[a.length*2];
        //把原来的数组赋值给新的数组
        System.arraycopy(a,0,newArray,0,a.length);
        for(int i =0;i<newArray.length;i++){
            System.out.println(newArray[i]+"\t");
        }
        //两个的内存地址不一样，不能让两个数组完全相等。
        a=newArray;
    }
    public static void changeArray(int[] a){
        a[0] = 10;
    }
    public static void printArray(int[] a){
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }
}
class Test054{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正数");
        int n = scanner.nextInt();
        getNum(n);

    }
    public static void getNum(int n){
        int count = 1;
        while(n>=10){
            count++;
            n=n/10;
        }
        System.out.println("该正数是一个"+count+"位数");
    }
}
class Test055 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = scanner.nextInt();
        //zhiShu(n);
        if (judge(n)) {
            System.out.println("它是一个质数！");
        } else {
            System.out.println("它不是一个质数！");
        }
    }
    //没有void方法时，需要自己添加return返回值。
    public static boolean judge(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                //System.out.println("这个数是一个质数");
                return false;
            }
        }
            //System.out.println("这个数不是一个质数！");
            return true;
    }
}
    /*
    public static void zhiShu(int n){
        for(int i =1;i<=n;i++){
            if((n/i==0)&&(i==1)&&(i==n)){
                System.out.println("这个数是一个质数");
            }
            else {
                System.out.println("这个数不是一个质数！");
            }
        }
    }

     */

class Test056{
    public static void main(String[] args) {
        //求两个任意点之间的距离。
        int a = 3, b =4;
        int x1 = 6,x2=8;

        int[] nums1 = new int[2];
        nums1[0] = a;
        nums1[1] = b;
        int[] nums2 = new int[2];
        nums2[0] = x1;
        nums2[1] = x2;
        getDistance(a,b,x1,x2);
    }
    public static void getDistance(int a,int b,int x1,int x2){
        double distance = Math.sqrt(Math.pow(a,x1)+Math.pow(b,x2));
        //用字符串格式化实现四舍五入。
        String result = String.format("%.2f",distance);
        System.out.println(result);
    }
}

class Test057{
    /*
    问题：已知两个完全平方三位数abc和xyz，其中a.b.c.x.y.z未必是不同的，而ax.by.cz是三个完全平方数，求abc和xyz。
    1、首先要知道判断完全平方数满足的条件。
    2、怎样去调用函数来判断是完全平方数。
     */
    public static void main(String[] args) {
        int a,b,c;
        int x,y,z;
        for(int i =100;i<1000;i++){
            for(int j =100;j<1000;j++){
                a = i/100;
                b = i/10%10;
                c = i%100%10;
                x = j/100;
                y = j/10%10;
                z = j%100%10;
                //相当于调用了下面的一个方法
                if(isSqure(i)&&isSqure(j)&&isSqure(a*10+x)&&isSqure(b*10+y)&&isSqure(c*10+z)){
                    System.out.println(i+" "+j);
                }
            }
        }
    }
    //判断是完全平方数的条件
    public static boolean isSqure(int n){
        //先定义一个初始条件
        boolean flag = false;
        if(n<0){
            flag = false;
        }
        else if(n==0||n==1){
            flag = true;
        }
        else {
            for(int i =1;i<=n;i++){
             if(i*i==n){
             flag = true;
             }
            }

        }
        return flag;
    }
}
//用递归方法求阶乘
class Test0510{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数n");
        int n = scanner.nextInt();
        int result = factorial(n);
        System.out.println("阶乘的结果为："+result);
    }
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        else {
            //一个特殊求阶乘的方法
            return n*factorial(n-1);
        }
    }
}
class Test0508{
    /*
    验证各的巴赫猜想
    1、任何大于2的偶数都可以表示2个素数之和。
    2、任何大于5的奇数都可以表示为3个素数之和。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //创建一个对象来调用方法
        Test0508 ge = new Test0508();
        System.out.println("请输入一个整数n");
        int n = scanner.nextInt();
        if(n<=3||n==5){
            System.out.println("请重新输入一个整数n");
        }
        else{
            //判断是不是偶数
            if(n%2==0){
                for(int a =2;a<n;a++){
                    for(int b =2;b<n;b++){
                        if(ge.isPrime(a)&& ge.isPrime(b)&&(n==a+b)){
                            System.out.println(n+"="+a+"+ "+b);
                        }
                    }
                }
            }
            //这是奇数的形式
            else {
                for(int a=2;a<n;a++){
                    for(int b =2;b<n;b++){
                        for(int c = 2;c<n;c++){
                            if(ge.isPrime(a)&& ge.isPrime(b)&& ge.isPrime(c)&&(n==a+b+c)){
                                System.out.println(n+"="+a+"+"+b+"+"+c);
                            }
                        }
                    }
                }
            }
        }

    }
    public  boolean isPrime(int a){
        //给flag一个初始值
        boolean flag = true;
        if(a<2){
            flag =false;
        }
        else{
            for(int i =2;i<a;i++){
                if(a%i==0){
                    flag = false;
                    //如果a不是素数,那么直接跳出循环。
                    break;
                }
            }

        }
        return flag;


    }
}