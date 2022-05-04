package practice;

public class Test0009 {
}
//如果没有为java类提供任何构造器，则系统会为这个类提供一个无参的构造器，这个构造器执行体为空，不做任何事情。
class Test{
    private String name;
    //有参的构造函数
    public Test(String name){
        this.name=name;
    }
    public static void main(String[] args) {
        //new 一个新对象，传参，调用构造函数
        Test test = new Test("VipMao");
        System.out.println(test.name);
    }
}
/*
class Duck{
    int size;
    public Duck(int size){
        //System.out.println("Quack");
        this.size=size;
    }
    public void setSize(int newSize){
        size = newSize;
    }
}
class UseDuck{
    public static void main(String[] args) {
        Duck d = new Duck(52);
        //如果是设置了大小，那么输入就要按设置方法中的设置大小来。
        d.setSize(42);
        System.out.println(d.size);
    }
}

 */
/*
如果某种对象不应该在状态被初始化之前就使用，用户不知道或者
忘记执行setSize,最好的方法就是把初始化的程序代码放在构造函数中，然后设定参数
 */
class Duck2{
    int size;
    /*
    //不知道size的大小时,需要指定默认值。
    public Duck2(){
        //指定的默认值
        size=27;
    }

    public static void main(String[] args) {
        Duck2 d2 = new Duck2();
        System.out.println(d2.size);
    }

     */
    //如果知道size的大小，那就要使用参数设定。
    public Duck2(int duckSize){
        //使用参数设定
        size = duckSize;
    }

    public static void main(String[] args) {
        Duck2 d = new Duck2(15);
        System.out.println(d.size);
    }
}
class Duck{
    //定义各个实例变量
    int pounds = 6;
    float floatability = 2.1F;
    String name = "Generic";
    long[] feathers = {1,2,3,4,5,6,7};
    boolean canFly = true;
    int maxSpeed = 25;
    //重载多个构造器
    public Duck(){
        System.out.println("type 1 duck");
    }
    public Duck(boolean fly){
        canFly = fly;
        System.out.println("type 2 duck");
    }
    public Duck(String n,long[] f){
        name = n;
        feathers = f;
        System.out.println("type 3 duck");
    }
    public Duck(int w,float f){
        pounds = w;
        floatability = f;
        System.out.println("type 4 duck");

    }
    public Duck(float density,int max){
        floatability = density;
        maxSpeed = max;
        System.out.println("type 5 duck");
    }
}
class TestDuck{
    public static void main(String[] args) {
        int weight = 8;
        float density = 2.3F;
        String name = "Donald";
        long[] feathers = {1,2,3,4,5,6};
        boolean canFly = true;
        int airspeed = 22;
        Duck[] d = new Duck[7];
        d[0] = new Duck();
        d[1] = new Duck(density,weight);
        d[2] = new Duck(name,feathers);
        d[3] = new Duck(canFly);
        d[4] = new Duck(3.3F,airspeed);
        d[5] = new Duck(false);
        d[6] = new Duck(airspeed,density);
    }
}
//practice Day02
class Test00{
    public static void main(String[] args) {
       // byte b=5;
       // b+='a';
        /*
        int a =3,b=4,c=5;
        boolean d =a>b&&c++>4;
        System.out.println(c+","+d);


        int a=3,b=4;
        int c =a;
        a=b;b=c;
        System.out.println(a+" "+b);

        int a=3,b=4;
        a+=b;b=a-b;a-=b;
        System.out.println(a+" "+b);

        int a=3,b=4;
        a^=b;b^=a;a^=b;
        System.out.println(a+" "+b);
         */
        //System.out.println(1.0/0);
        /*
        int a =5;
        int b =(a++)+(--a)+(++a);
        System.out.println(b);
         */
        short price = 100;
        int realPrice = price*8/10;
        System.out.println(realPrice);

    }
}
class Animal1{
    public Animal1(){
        System.out.println("Making an Animal");
    }
}
class Hippo extends Animal1{
    public Hippo(){
        System.out.println("Making a Hippo");
    }
}
class Duck1 extends Animal1{
    int size;
    public Duck1(int newSize){
        //调用父类构造函数的唯一方法是调用super().
        super();
        size = newSize;
    }
}
class TestHippo{
    public static void main(String[] args) {
        System.out.println("Starting...");
        Hippo h = new Hippo();
    }
}



//调用父类函数的时候要用super()，this也能够调用构造函数，不能同时调用super()和this()，两者只有第一个会是第一行语句。
abstract class Animal2{
    //把实例变量变成私有的形式，怎样进行传值呢，要调用父类的方法。
    private  String name;
    public String getName(){
        return name;
    }
    public Animal2(String theName){
        name = theName;
    }
}
class Hippo2 extends Animal2{
    public Hippo2(String name){
        //Animal如何取值，唯一的机会是通过super()来引用父类。
        super(name);
    }
}
class MakeHippo{
    public static void main(String[] args) {
        Hippo2 h = new Hippo2("Buffy");
        System.out.println(h.getName());
    }
}

//调用父类方法super()的应用
class Boo{
    public Boo(int i){};
    public Boo(String s){};
    public Boo(String s,int i){};
}
class SonOfBoo extends Boo{
    public SonOfBoo(){
        super("boo");
    }
    public SonOfBoo(int i){
        super("Fred");
    }
    public SonOfBoo(String s){
        super(42);
    }
    //public SonOfBoo(int i,String s){};
    //public SonOfBoo(String a,String b,String c){
        //super(a,b);}
    public SonOfBoo(int i,int j){
        super("man",j);
    }
    //public SonOfBoo(int i,int x,int y){ super(i,"star"); }
}

//垃圾收集器
class GC{
    public static GC doStuff(){
        GC newGC = new GC();
        doStuff2(newGC);
        return newGC;
    }

    public static void main(String[] args) {
        GC gc1;
        GC gc2 = new GC();
        GC gc3 = new GC();
        GC gc4 = gc3;
        gc1 = doStuff();
    }
    public static void doStuff2(GC copGC){
        GC localGC;
    }
}

//找出被最多变量所引用的对象，被最多变量引用的对象是Honey对象。
class Bees{
    Honey[] beeHA;
}
class Raccoon{
    Kit k;
    Honey rh;
}
class Kit{
    Honey kh;
}
class Bear{
    Honey hunny;
}
 class Honey{
     public static void main(String[] args) {
         Honey honeyPot = new Honey();
         //有四个honeyPot引用指向了Honey对象
         Honey[] ha = {honeyPot,honeyPot,honeyPot,honeyPot};
         Bees b1 = new Bees();
         //由于在Bees类中也与Honey类建立了关系，所以b1这个引用指向了Honey对象。
         b1.beeHA = ha;
         //ba被引用了5次。
         Bear[] ba = new Bear[5];
         for(int x = 0;x<5;x++){
             //由于Bear类也与Honey类建立了关系，所以5个bar引用也指向了Honey对象。
             ba[x] = new Bear();
             ba[x].hunny = honeyPot;
         }
         Kit k = new Kit();
         k.kh = honeyPot;
         Raccoon r = new Raccoon();
         //由于Raccoon也与Honey建立了关系，所以r引用也指向了Honey对象。
         r.rh = honeyPot;
         r.k = k;
         k=null;
     }
}
