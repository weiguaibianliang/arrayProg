package com.huzheng.company;

import java.util.Arrays;

public class Test10 {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] = new int[]{1,2};
        a[1] = new int[]{2,2};
        a[2] = new int[]{2,2,3,4};
        System.out.println(a[2][3]);
        //System.out.println(a[0]);这里调用的是object里面的地址，前面要加上Arrays.toString
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
    }
}
