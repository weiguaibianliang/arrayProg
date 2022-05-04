package com.huzheng.company;
import java.util.Arrays;
public class Test08 {
    /*
    //使用Arrays类输出数组中的元素
    public static void main(String[]args){
        int[] a = {1,2};
        System.out.println(a);
        System.out.println(Arrays.toString(a));
    }

     */
    /*
    //使用Arrays类对数组元素进行排序
    public static void main(String[]args){
        int[] a = {1,2,323,23,543,12,59};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

     */
    //使用Array类实现二分法查找法,理解二分法的含义
    public static void main(String[] args) {
        int[] a = {1,2,323,23,543,12,59};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("该元素的索引"+Arrays.binarySearch(a,12));
    }

}
