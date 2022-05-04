package com.huzheng.company;

public class Test09 {
    //public void main(String[] args) {
    int[][] a1 = {{1, 2, 3}, {3, 4}, {3, 5, 6, 7}};
    // System.out.println(a[2][3]);


    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] = new int[2];
        a[1] = new int[3];
        a[2] = new int[4];
        System.out.println(a[2][1]);
        Test09 t = new Test09();
        System.out.println(t.a1[2][3]);
    }
}

