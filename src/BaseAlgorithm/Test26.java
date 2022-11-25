package BaseAlgorithm;

import java.awt.*;

/**
 * 创造两只完全相同的宠物
 */
//测试类
public class Test26 {
    public static void main(String[] args) {
        //创建猫咪1号
        Cat cat1 = new Cat("java",12,21,Color.black);
        //创建猫咪2号
        Cat cat2 = new Cat("C++",12,21,Color.WHITE);
        //创建猫咪3号
        Cat cat3 = new Cat("Java",12,21,Color.black);
        //输出猫咪1号
        System.out.println("猫咪1号：" + cat1);
        //输出猫咪2号
        System.out.println("猫咪2号：" + cat2);
        //输出猫咪3号
        System.out.println("猫咪3号：" + cat3);
        System.out.println("猫咪1号是否与猫咪2号相同：" + cat1.equals(cat2));
        System.out.println("猫咪1号是否与猫咪3号相同：" + cat1.equals(cat3));
    }
}
class Cat{
    //表示猫咪的名字
    private String name;
    //表示猫咪的年龄
    private int age;
    //表示猫咪的重量
    private double weight;
    //表示猫咪的颜色
    private Color color;
    //初始化猫咪的属性
    public Cat(String name,int age,double weight,Color color){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    //利用属性来判断猫咪是否相同
    @Override
    public boolean equals(Object obj){
        //如果两个猫咪是同一个对象则相同
        if(this == obj){
            return true;
        }
        //如果两个猫咪有一个为null则不同
        if(obj == null){
            return false;
        }
        //如果两个猫咪的类型不同则不同
        if(getClass() != obj.getClass()){
            return false;
        }
        Cat cat = (Cat) obj;
        //比较猫咪的属性
        return name.equals(cat.name) && (age == cat.age) && (weight == cat.weight) && (color.equals(cat.color));
    }
    //重写toString方法
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("名字：" + name + "\n");
        sb.append("年龄：" + age + "\n");
        sb.append("重量：" + weight + "\n");
        sb.append("颜色：" + color + "\n");
        return sb.toString();
    }
}
