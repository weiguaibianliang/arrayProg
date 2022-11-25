package EasyAlgorithm;

import java.util.Random;
import java.util.Scanner;

public class Test6 {
}

/**
 * 打印水仙花数： 是指一个三位数，其各位数字立方和等于该数字本身。
 * 例如：153就是一个水仙花数，因为 153 = 1^3 + 5^3 + 3^3.
 */

class GetNum{
    public static void main(String[] args) {
        /*
        for(int i = 100; i < 1000; i++){
            int x = i/100;
            int y = i/10%10;
            int z = i%10;
            if(i == x*x*x + y*y*y + z*z*z){
                System.out.println(i);
            }
        }

         */
        //1、遍历所有的三位数
        for (int i = 100; i < 1000; i++){
            //2、调用自定义的方法判断是不是水仙花数
            if(isAim(i)){
                //3、如果是水仙花数，就打印。
                System.out.println(i);
            }
        }

    }
    //自己定义一个判断水仙花数的方法
    public static boolean isAim(int a){
        int x = a/100;
        int y = a/10%10;
        int z = a%10;
        if(a == x*x*x + y*y*y +z*z*z){
            return true;
        }
        return false;
    }
}

/**
 * 面向对象 封装百分制分数
 * 需求：封装百分制分数，和它对应的五档分制分数
 */
class Score{
    //成员变量
    int score;
    char level;
    //构造方法
    public Score(int score){
        this.score = score;
        //计算五档分数，保存到成员变量level
        this.level = setLevel(score);
    }
    private char setLevel(int s){
        char r = 0;
        //s/10表示分数存在的一个范围。
        switch (s/10){
            case 10:
            case 9:
                r = 'A';
                break;
            case 8:
            case 7:
                r = 'B';
                break;
            case 6:
                r = 'C';
                break;
            case 5:
            case 4:
            case 3:
            case 2:
                r = 'D';
                break;
            case 1:
            case 0:
                r = 'E';
                break;
        }
        return r;
    }
    //java类根据需要重写toString方法才能使返回值更有意义，如果不去重写这个方法，那么返回值就会是： 类名+符号@+对象的哈希码值。
    public String toString(){
        return score+ "," + level;
    }
}
//测试百分制分数类
class TestScore{
    public static void main(String[] args) {
        Score s = new Score(54);
        System.out.println(s.toString());
    }
}

//面向对象，打印图形
//需求：设计一个可以随机打印形状的代码
class Shape{
    public void draw(){
        //无意义代码
        //在子类中要重写draw()方法
        System.out.println("图形形状");
    }
    public void clear(){
        System.out.println("\n\n\n");
    }
}
class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("打印一个圆形O");
    }
}
class Square extends Shape{
    @Override
    public void draw() {
        System.out.println("打印一个方形 口");
    }
}
class Line extends Shape{
    @Override
    public void draw() {
        System.out.println("打印一条直线——————");
    }
    public void length(){
        System.out.println("一米多。。。。");
    }
}
//测试类，随机生成图形
class TestShape{
    public static void main(String[] args) {
        System.out.println("按回车键继续进行下去");
        while(true){
            int r = new Random().nextInt(4);
            switch (r){
                case 0:
                    f(new Shape());
                    break;
                case 1:
                    f(new Line());
                    break;
                case 2:
                    f(new Square());
                    break;
                case 3:
                    f(new Circle());
                    break;
            }
        }
    }
    //定义随机生成图形的静态方法
    static void f(Shape s){
        System.out.println("-------------");
        new Scanner(System.in).nextLine();
        s.draw();
        //向上转型后，只能调用父类定义的通用成员
        //子类特有成员不能调用
        //s.length();
        //s对象的真实类型是line类型
        if(s instanceof Line){
            //向下转型成line类型，才能调用它特有的方法
            Line line = (Line) s;
            line.length();
        }
        new Scanner(System.in).nextLine();
        s.clear();
    }
}

//面向对象 设计士兵类
//需求：设计士兵与武器AK47类，并完成前进、进攻、发射子弹、装载子弹的功能。
/*
封装：
    士兵相关的属性数据、逻辑运算方法，
    封装成一个士兵类组件
 */
class Soldier{
    //成员变量，属性变量
    int id;//默认值0
    int blood = 100;
    AK47 a;//默认null值
    //成员方法
    public void go(){
        //this是一个特殊引用
        //引用“当前对象”的地址
        //当前对象：谁调用就是谁
        //可以省略，缺省存在
        System.out.println(this.id+"号士兵前进");
    }
    public void attack(){
        if(blood == 0){
            System.out.println("这是"+id+"号士兵的尸体");
            return;//方法结束
        }
        System.out.println(id+"号士兵进攻");
        if(a != null){
            a.fire();//调用枪发射子弹
        }
        //模拟进攻掉血
        //随机的减血量
        int d = new Random().nextInt(10);
        blood -= d;
        if(blood < 0){
            //不允许负数血量
            blood = 0;
        }
        System.out.println("血量："+ blood);
        //血量是0
        if(blood == 0){
            System.out.println(id + "号士兵阵亡");
        }
    }

}
/**
 * 封装：
 * AK47武器相关的属性数据、运算代码，
 * 封装成一个“类”组件
 */
class AK47{
    int bullets = 100;
    public void fire(){
        if(bullets == 0){
            System.out.println("没有子弹");
            return;
        }
        //随机产生发射子弹数量
        int r = new Random().nextInt(10);
        //要发射的数量，比现有子弹多
        if(r > bullets){
            //有多少发多少
            r = bullets;
        }
        bullets -= r;
        for (int i = 0; i < r; i++){
            System.out.println("突");
        }
        System.out.println("~");
        if(bullets == 0){
            System.out.println("弹夹空了");
        }
    }
    public void load(){
        bullets = 100;
        System.out.println("弹夹已装满");
    }
}
//测试类1
class TestSolider{
    public static void main(String[] args) {
        //新增Soldier士兵对象
        //内存地址，保存到变量s1
        Soldier s1 = new Soldier();
        Soldier s2 = new Soldier();
        //用s1引用第一个士兵对象
        //为它的id赋值
        s1.id = 9527;
        s2.id = 9528;
        //用s1找到第一个士兵对象
        //让第一个士兵执行go()方法代码
        s1.go();
        s2.go();
        //新建AK47对象，保存到s1.a
        s1.a = new AK47();
        s2.a = new AK47();
        s2.attack();
        s2.attack();
        s2.attack();
        s2.attack();
    }
}
//测试类2
class TestSolider2{
    public static void main(String[] args) {
        //新建AK47对象，地址存到变量a
        AK47 a = new AK47();
        System.out.println("按回车射击，输入load装载子弹");
        while (true){
            String s = new Scanner(System.in).nextLine();
            if(s.equals("load")){
                a.load();
                continue;
            }
            a.fire();
        }
    }
}