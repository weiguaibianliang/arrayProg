package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode {
}
//求两数之和
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
class Soluton{
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Soluton s = new Soluton();
        s.TwoSum(nums,9);
    }
    public int[] TwoSum(int[] nums,int target){
        int[] res = new int[2];
        for(int i = 0;i<nums.length-1;i++){
            for (int j = i+1;i<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0] =i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
//求两数相加，需要好好看文档，看视频消化。
//给定一个字符串，请你找出其中不含重复字符的最长子串的长度。
class TestLongestString{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //请输入一行任意的字符串s
        System.out.println("请输入一行任意的字符串s");
        String s = scanner.nextLine();
        char[] chars =s.toCharArray();
        for (char achar: chars) {
        }
    }


}
//第一种解法，用暴力解法
class Solution{
    public int lengthOfLongestSubstring(String s){
        //把字符串s传入到一个字符串数组a中
        char[] a = s.toCharArray();
        //创建一个字符串list链表
        List<Character> list = new ArrayList<>();
        //如果字符串数组的长度为0，那么该字符串重复的字符没有
        if(a.length==0){
            return 0;
        }else {
            //如果字符串数组的长度不为0，那么统计重复的字符串
            int num = 1;
            for(int j = 0;j<a.length;j++){
                for(int i = j;i<a.length;i++){
                    //如果list链表数组中没有和字符串数组a重复的字符
                    if(list.contains(a[i])==false)
                        //那么无重复字符的最长子串就是它本身
                        list.add(a[i]);
                    else{
                        //如果返回链表元素的个数大于或等于num
                        if(list.size()>=num){
                            //那么就直接把返回链表的个数赋值给num
                            num=list.size();
                        }
                        //清空链表
                        list.clear();
                        //直接跳出当前循环
                        break;
                    }
                }
            }
            //返回num的大小，这个就是无重复字符的最长字符串
            return num;
        }
    }
}
class Test15{
    public static void main(String[] args) {
        for(int i =1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+ i*j+" ");
            }
            System.out.println();
        }
    }
}
class BreakDemo{
    public static void main(String[] args) {
        /*
        break:跳出
        当break语句单独存在时，下面不要定义其他语句，break直接跳出了当前的循环
        当break语句在嵌套循环中，break想要跳出指定的循环，可以通过标号完成。
         */
        for(int x =0;x<3;x++){
            if(x==2){
                break;
            }
            System.out.println("x="+x);
        }
        System.out.println("-----------");
        loop1:for (int x = 0;x<3;x++){
            loop2:for(int y=0;y<4;y++){
                System.out.println("x="+x);
                break loop1;
            }
        }
    }
}
class ContinueDemo{
    public static void main(String[] args) {
        /*
        continue:结束本次循环，继续下次循环
        如果continue单独存在时，下面不要有任何语句，不会执行
         */
        for(int x = 0;x<11;x++){
            if(x%2==0){
                continue;
            }
            System.out.println("x="+x);
        }
        System.out.println("------------");
        loop1:for(int x=0;x<3;x++){
            loop2:for(int y =0;y<4;y++){
                System.out.println("x="+x);
                continue loop1;
            }
        }
    }
}
//关于线程同步的问题
class NameList{
    //定义了一个list集合
    private  List names = new ArrayList();
    public synchronized  void add(String name){
        names.add(name);
    }
    public synchronized void  printAll(){
        for(int i =0;i<names.size();i++){
            System.out.println(names.get(i)+"");
        }
    }

    public static void main(String[] args) {
       //实例声明一个对象
       final NameList s1 = new NameList();
       for(int i =0;i<2;i++){
           //线程处于就绪状态，然后开始运行。
           new Thread(){
               public void run(){
                   s1.add("A");
                   s1.add("B");
                   s1.add("C");
                   s1.printAll();
               }
           }
           .start();
       }
    }
}

