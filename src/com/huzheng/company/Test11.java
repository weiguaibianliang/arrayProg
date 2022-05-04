package com.huzheng.company;
import java.util.Arrays;
//数组存储表格数据
public class Test11 {
    public static void main(String[] args) {
        Object[] a1 = {1001, "高小一", 18, "讲师", "2019-9-10"};
        Object[] a2 = {1002, "高小二", 19, "助教", "2019-9-11"};
        Object[] a3 = {1003, "高小三", 20, "班主任", "2019-9-12"};
        Object[][] emps = new Object[3][];
        emps[0] = a1;
        emps[1] = a2;
        emps[2] = a3;
        //用for循环来写
        /*
        for(int i = 0;i<emps.length;i++){
            System.out.println(Arrays.toString(emps[i]));
        }

         */
        //for的嵌套循环
        for(int i = 0;i<emps.length;i++){
            for(int j = 0;j<emps[i].length;j++){
                System.out.print(emps[i][j]+"\t");
            }
            System.out.println();
        }
        /*
        System.out.println(Arrays.toString(emps[0]));
        System.out.println(Arrays.toString(emps[1]));
        System.out.println(Arrays.toString(emps[2]));

         */
    }
}
