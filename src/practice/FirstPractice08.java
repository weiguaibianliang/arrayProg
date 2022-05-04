package practice;

public class FirstPractice08 {
}
class A81{
    private static void m(){}
}
 class B81 extends A81{
    //public static int m(){
      //  return 0;
     void m() {}
}
class A82{
    int i;
    protected void ma(){
        System.out.println("A ma");
    }
}
class B82 extends A82{
    public void mb(){
        super.i = 5;
    }
}
class C82{
    public static void main(String[] args) {
        A82 a = new A82();
        a.ma();
        B82 b = new B82();
        b.mb();
    }
}
class TestSuper{
    public void m1(){
        m2();
    }
    public void m2(){
        System.out.println("Super");
    }
}
class TestSub extends TestSuper{
    public void m2(){
        System.out.println("Sub");
    }
}
 class Test84{
     public static void main(String[] args) {
         //是对TestSub创建了一个对象。
         TestSuper ts = new TestSub();
         ts.m1();
     }
 }
 class TestSuper85{
    public static void ma(){
        System.out.println("Super ma");
    }
    public void mb(){
        System.out.println("Super mb");
    }
 }
 class TestSub85 extends TestSuper85{
    public static void ma(){
        System.out.println("Sub ma");
    }
    public void mb(){
        System.out.println("Sub mb");
    }
 }
 class Test85{
     public static void main(String[] args) {
         TestSuper85 ts = new TestSub85();
         //静态方法调用静态方法，直接类名+方法名
         TestSuper85.ma();
         ts.mb();
     }
 }
 class TestSuper87{
    private void m(){}
 }
 class TestSub87 extends TestSuper87{
    //public void m(){}
    //public int m(){
    private double m(double d){
        return d;
    }
 }

 class MyClass88{
    static int a;
    int b;
 }
 class TestMain{
     public static void main(String[] args) {
         MyClass88 mc1 = new MyClass88();
         MyClass88 mc2 = new MyClass88();
         MyClass88.a = 100;
         mc1.b = 200;
         MyClass88.a = 300;
         mc2.b = 400;
         System.out.println(MyClass88.a);
         System.out.println(mc1.b);
         System.out.println(MyClass88.a);
         System.out.println(mc2.b);
     }
 }
class Zuoye{
    public static void main(String[] args){
        MyClass90 m1=new MyClass90();
        MyClass90 m2=new MyClass90();
        MyClass90 m3=new MyClass90();
        m1.n();
        m2.n();
        m3.n();
        System.out.println(MyClass90.count);
    }
}
class MyClass90{
    static int count=0;
    public static int n(){
        count++;
        return count;
    }
}

class MyClass91{
    static int count = 0;
    public MyClass91(){
        count++;
        System.out.println(count);
    }
}
class TeatMain91{
    public static void main(String[] args) {
        MyClass91 mc1 = new MyClass91();
        MyClass91 mc2 = new MyClass91();
        MyClass91 mc3 = new MyClass91();
    }
}
//判断各代码块的执行顺序
class MyClass92{
    static int i =10;
    static {
        i = 20;
        System.out.println("In Static");
    }
    public MyClass92(){
        System.out.println("MyClass()");
    }
    public MyClass92(int i ){
        System.out.println("MyClass92(int)");
        this.i = i;
    }
}
class TestMain92{
    public static void main(String[] args) {
        MyClass92 mc1 = new MyClass92();
        System.out.println(mc1.i);
        MyClass92 mc2 = new MyClass92(10);
        System.out.println(mc2.i);
    }
}

class Super93{
    public final void m1(){
        System.out.println("m1() in Super");
    }
    public void m1(int i){
        System.out.println("m1(int) in Super ");
    }
}
class Sub93 extends Super93{
    public void m1(int i){
        System.out.println("m1(int) in Sub");
    }
    public void m1(double d ){
        System.out.println("m1(double) in Sub");
    }
}
class TestMain93{
    public static void main(String[] args) {
        Sub93 s = new Sub93();
        s.m1();
        s.m1(10);
        s.m1(1.5);
    }
}

class ClassA94{
    static {
        System.out.println("In ClassA static");
    }
    public ClassA94(){
        System.out.println("ClassA()");
    }
}
class ClassB94{
    static {
        System.out.println("In ClassB Static");
    }
    public ClassB94(){
        System.out.println("ClassB()");
    }
}
class ClassC94 extends ClassB94{
    static {
        System.out.println("In ClassC Static");
    }
    public ClassC94(){
        System.out.println("ClassC94()");
    }
}
class MyClass94{
    static ClassA94 ca = new ClassA94();
    ClassC94 cc = new ClassC94();
    static {
        System.out.println("In MyClass Static");
    }
    public MyClass94(){
        System.out.println("MyClass94()");
    }
}
class TestMain94{
    public static void main(String[] args) {
        MyClass94 mc1 = new MyClass94();
        MyClass94 mc2 = new MyClass94();
        System.out.println(mc1.cc == mc2.cc);
        System.out.println(mc1.ca==mc2.ca);
    }
}

class MyClass95{
    static int count = 0;
    public static int MyClass95(){
        count++;
        return count;

    }
}
class TestMyClass95{
    public static void main(String[] args) {
        MyClass95 mc1 = new MyClass95();
        MyClass95 mc2 = new MyClass95();
        MyClass95 mc3 = new MyClass95();
        MyClass95 mc4 = new MyClass95();
        mc1.MyClass95();
        mc2.MyClass95();
        mc3.MyClass95();
        mc4.MyClass95();

        System.out.println("总共创建了"+MyClass95.count+"对象");
    }
}