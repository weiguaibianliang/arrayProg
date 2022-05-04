package practice;

import java.util.Arrays;

public class FirstPractice07 {
}
//Day07面向对象的特征、继承、封装、多态、super关键字、修饰符
class Animal71{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Dog71 extends Animal71{
    Dog71(String name){
        this.getName();
        this.setName( name);
    }

}
class Cat71 extends Animal71{
    Cat71(String name){
        this.getName();
        this.setName(name);
    }
}
//getAllDog方法从一个Animal数组中挑选出所有的Dog对象，并把这些对象放在一个Dog数组中返回。
class TestAnimal71{
    public static void main(String[] args) {
        Animal71[] as = new Animal71[4];
        as[0] = new Dog71("pluto");
        as[1] = new Cat71("Tom");
        as[2] = new Dog71("Snoopy");
        as[3] = new Cat71("Garfield");
        //定义一个数组调用下面的方法
        Dog71[] dogs = getAllDog(as);
        //打印动物中所有包含狗的名字
        for(int i =0;i<dogs.length;i++){
            System.out.println(dogs[i].getName());
        }
    }
    public static Dog71[] getAllDog(Animal71[] as){
        Dog71[] dog = new Dog71[as.length];
        int count = 0;
        for(int i =0;i<as.length;i++){
            //判断左边是不是右边的子类
            if(as[i] instanceof Dog71){
                //把得到的动物类型转为狗的类型
                dog[count++] = (Dog71) as[i];
            }
        }
        //Arrays.copyOf()是传回新的数组对象，改变传回数组的元素值，不会影响原来的数组。
        //第二个自变量指定要建立的新数组的长度，如果新数组的长度超过原数组的长度，则保留数组默认值。
        dog = Arrays.copyOf(dog,count);
        return dog;

    }
}

class Test72{
/*
1、把Student的属性都作为私有，并提供get/set方法以及适当的构造方法
2、添加一个getPostAddreaa方法，要求返回Student对象的地址和邮编。
 */
}
class Student72{
    private String name;
    private int age;
    private String address;
    private String zipCode;
    private String mobile;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public  String getPostAddress(){
        return zipCode+address;
    }
}
class TestStudent72 {
    public static void main(String[] args) {
        Student72 st = new Student72();
        st.setName("liHua");
        st.setAge(12);
        st.setAddress("HongKong");
        st.setZipCode("hz.163.com");
        st.setMobile("436211");
        System.out.println(st.getPostAddress());

    }
}

//创建三个类，组成一个继承树，表示游戏中的角色。
 abstract class Role{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    abstract public int attack();
}
class Magicer extends Role {
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level>1&&level<10){
            this.level = level;
        }
        else {
            System.out.println("魔法师的等级超过上限");
        }

    }
    public int attack(){
        return level*5;
    }
}
class Soldier extends Role{
    private int hurt;

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }
    public int attack(){
        return hurt;
    }
}
class Team{
    static int i = 0;
    static Role[] roles = new Role[6];
    public void addMember(Role role){
        roles[i++] = role;
    }
    public int attackSum(){
        int sum = 0;
        for(int j = 0;j<i;j++){
            sum += roles[j].attack();
        }
        return sum;
    }


}
class TestRole{
    public static void main(String[] args) {
        Magicer m = new Magicer();
        m.setName("liHua");
        m.setLevel(5);
        System.out.println("Magicer的名字是"+m.getName()+"攻击伤害为："+m.attack());
        Soldier s = new Soldier();
        s.setName("zhangSan");
        s.setHurt(100);
        System.out.println("Solider的名字是"+s.getName()+"攻击伤害为："+s.attack());
        Team t = new Team();
        t.addMember(m);
        t.addMember(s);
        t.attackSum();
        System.out.println("所有队员的伤害为："+t.attackSum());

    }
}


class Test74{

}
class Account1{
    private long id;
    private double balance;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
class SavingAccount{
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if(interestRate>0&&interestRate<10){
        this.interestRate = interestRate;
        }
    }
}
class CreditAccount{
    private double creditLine;

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }
}

class Test75{

}
 class Shape{
    public double area(){
        return 0;
    }
    public double grith(){
        return 0;
    }
}
class Circle extends Shape{
    private int r;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
    public Circle(int r){
        super();
        this.r = r;
    }
    public double area(){
        return 3.14*r*r;
    }
    public double grith(){
        return 2*3.14*r;
    }
}
class Rect extends Shape{
    private int a ;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    //子类调用父类需要一个无参的构造方法。
    public Rect(){}
    public Rect(int a,int b){
        super();
        this.a = a;
        this.b = b;
    }
    public double area(){
        return a*b;
    }
    public double grith(){
        return 2*(a+b);
    }
}
class Square extends Rect{
    private int a;

    public int getD() {
        return a;
    }

    public void setD(int a) {
        this.a = a;
    }
    public Square(int a){
        this.a = a;
    }
    public double area(){
        return a*a;
    }
    public double grith(){
        return a*4;
    }
}
class TestShape{
    public static void main(String[] args) {
        Shape[] shapes ={new Circle(2),new Rect(2,3),new Square(2)};
        for (Shape s:shapes) {
            System.out.println("周长为："+s.grith()+"面积为："+s.area());
        }


    }
}