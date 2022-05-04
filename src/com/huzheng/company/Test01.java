package com.huzheng.company;

public class Test01 {
    public static void main(String[]args){
        int[]s = null;//声明数组的类型，不能用混合类型，这里是基本类型。
        s = new int[10];//给数组分配空间，然后进行构造对象
        for(int i = 0;i < 10;i++){
            s[i] = 2*i + 1;//给数组元素赋值；数组也是对象，数组中的元素就是对象的属性。
            System.out.println(s[i]);
        }
    }

}
