package practice;

import java.util.Scanner;

public class FirstPractice06 {
}
class Test061{
    int value;
    public void method(int value){
        System.out.println(value);
    }
    public void method(){
        System.out.println(value);
    }
}
class TestClassA1{
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.value = 10;
        classA.method();
        classA.method(20);
    }
}

class Test062{
}
class ClassA1{
    public ClassA1(){
        System.out.println("ClassA()");
    }
}
class ClassB1{
    public ClassB1(){
        System.out.println("ClassB()");
    }
}
class ClassC{
    ClassA1 a = new ClassA1();
    ClassB1 b;
    public ClassC(){
        System.out.println("ClassC()");
        b = new ClassB1();
    }
}
 class TestConstructor{
     public static void main(String[] args) {
         ClassC cc = new ClassC();
     }
}

class Test063{
    int value;
}
class TestClass2{
    //看++号的应用，在变量后面就是先赋值再自增。
    public static void main(String[] args) {
        int value = 10;
        changeInt(value);
        System.out.println(value);
        Test063 ca = new Test063();
        ca.value = 10;
        changeObject(ca);
        System.out.println(ca.value);
    }
    public static void changeInt(int value){
        value++;
    }
    public static void changeObject(Test063 ca){
        ca.value++;
    }
}

class ClassA3 {
    int value;
}
 class ChangeRef{
     public static void main(String[] args) {
         ClassA3 ca = new ClassA3();
         changeValue(ca);
         System.out.println(ca.value);
         changeRef(ca);
         System.out.println(ca.value);
     }
     public static void changeValue(ClassA3 ca){
         ca.value = 100;
     }
     public static void changeRef(ClassA3 ca){
         ca = new ClassA3();
         ca.value = 200;
     }
}
class Test064{
    //静态方法调用静态方法可以用类名＋方法，而静态方法调用非静态方法要引用＋方法名。
    void method(){
        System.out.println("method()");
    }
    int method(int i){
        System.out.println("method(int)");
        return i;
    }

    public static void main(String[] args) {
        Test064 a = new Test064();
        a.method();
        a.method(10);
    }
}
class MyClass{
    int value;
}
class TestRef{
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        b++;
        System.out.println(a);
        MyClass mc1 = new MyClass();
        mc1.value = 10;
        MyClass mc2 = mc1;
        mc2.value++;
        System.out.println(mc1.value);
    }
}

class MyClass1{
    int value;
    //要添加一个构造器
    public MyClass1(int value) {
        this.value = value;
    }
}
class TestMyClass1{
    public static void main(String[] args) {
        MyClass1 mc1 = new MyClass1(0);
        MyClass1 mc2 = new MyClass1(10);
        System.out.println(mc1.value);
        System.out.println(mc2.value);
    }
}

class Test065{
}
class Student{
    int age;
    String name;
    public void Sudent(){
    }
    void init(){
        age = 10;
        name = "limy";
    }
    public Student(String name){
        this.init();
        this.name = name;
    }
    public Student(String name,int age){
        this.init();
        this.name = name;
        this.age = age;
    }
}

//编程题：复数概念的理解

class Complex{
    //表示实部、
    double real;
    //表示虚部
    double im;
    public Complex(double x,double y){
        real = x;
        im = y;
    }
   public  static  Complex add(Complex x,Complex y){
        Complex ans = new Complex(x.real+y.real,x.im+y.im);
        return ans;
   }
   public  static  Complex sub(Complex x,Complex y){
        Complex ans = new Complex(x.real-y.real,x.im-y.im);
        return ans;
   }
   public static Complex mul(Complex x,Complex y){
        Complex ans = new Complex(x.real*y.real-x.im*y.im,x.real*y.im+x.im*y.real);
        return ans;
    }
   public static void print(Complex ans){
        if(ans.im>0){
            System.out.println(ans.real+"+"+ans.im+"i");
        }
        else {
            System.out.println(ans.real+""+ans.im+"i");
        }

   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入实部和虚部的有实数部分的值
        System.out.println("请输入第一个复数实部和虚部的实数值：");
        //double a = scanner.nextDouble();
        //double b = scanner.nextDouble();
        Complex x = new Complex(scanner.nextDouble(),scanner.nextDouble());
        System.out.println("请输入第二个复数实部和虚部的实数值");
        Complex y = new Complex(scanner.nextDouble(),scanner.nextDouble());
        Complex z = Complex.add(x,y);
        System.out.println("加法运算");
        Complex.print(z);
        Complex z1 = Complex.sub(x,y);
        System.out.println("减法运算");
        Complex.print(z1);
        Complex z2 = Complex.add(x,y);
        System.out.println("乘法运算");
        Complex.print(z2);

    }
}