package practice;

import java.util.Scanner;

//关于方法的编程题
public class FirstPractice03 {
}
class Test01{
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};
        expand(a);
        changeArray(a);
        printArray(a);
    }
    //把数组a进行扩展。
    public static void expand(int[] a){
        //将一个数组的值拷贝到一个新数组，不是简单的引用，这时候要使用Arrays类的copyOf方法。
        int[] newArray = new int[a.length*2];
        //进行数组的复制，把元素赋给一个新的数组。
        System.arraycopy(a,0,newArray,0,a.length);
        a=newArray;
    }
    //改变数组的元素值
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
class Test02{
    /*
    写一个函数add，接收两个整数作为参数，返回这两个整数的和。
     */
    public static void main(String[] args) {
        System.out.println(add(3,5));
    }
    public static int add(int n1,int n2){
        int sum = n1+n2;
        return sum;
    }
}
class Test03{
    /*
    写一个函数接收一个整数，打印这个整数的所有因子，打印所有的因子的意思就是
    要求能够被整数整除的因子。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //在控制台写入一个整数
        System.out.println("在控制台写入一个整数");
        long a = scanner.nextLong();
        getFactor(a);
    }
    public static void getFactor(long a){
        //遍历出能够被整除的因子
        for(int i=1;i<=a;i++){
            if(a%i==0){
                System.out.println(i);
            }
        }
    }
}
class Test04{
    /*
    写入一个函数，接收一个整数n，输出1+2+3+.....n的和。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //在控制台写入一个整数
        System.out.println("在控制台写入一个整数");
        long n = scanner.nextLong();
        getFactor(n);
    }
    public static void getFactor(long n){
        int sum = 0;
        for(int i =1;i<=n;i++){
            sum = sum +i;
            //System.out.println(sum);
        }
        System.out.println(sum);
    }
}
