package practice;
//这一章节主要是学习继承、封装、多态和重写，如何去运用十分关键。
public class Test0007 {
}
class Doctor{
    boolean worksAtHospital;
    void treatPatient(){
        //执行检查
    }
}
class FamilyDoctor extends Doctor{
    boolean makesHouseCalls;
    void giveAdvice(){
        //提出诊断
    }
}
class Surgeon extends Doctor{
    void treatPatient(){
        //执行手术
    }
    void makeIncision(){
        //进行截肢手术
    }
}
/*
class Vet{
    public void giveShot(Animal a){
        //do horrible things to the Animal at
        //the other end of the 'a' parameter
        a.makeNoise();//表示a参数可以用任何的Animal的类型对象来当传入。
    }
}
class PetOwner{
    public void start(){
        Vet v = new Vet();
        Dog d = new Dog();
        Hippo h = new Hippo();
        v.giveShot(d);//giveShot这个方法可以取用任何一种Animal.只要所传入的是Animal的子类它都能执行，会执行Dog
        v.giveShot(h);//会执行Hippo对应的方法。
    }
}

 */
class Overloads{
    String uniqueID;
    public int addNums(int a,int b){
        return a+b;
    }
    public double addNums(double a,double b){
        return a+b;
    }
    public void setUniqueID(String theID){
        //lots of validation code,and then
        uniqueID = theID;
    }
    public void setUniqueID(int ssNumber){
        String numString = ""+ssNumber;
        setUniqueID(numString);
    }
}
class A{
    int ivar = 7;
    void m1(){
        System.out.print("A's m1,");
    }
    void m2(){
        System.out.print("A's m2,");
    }
    void m3(){
        System.out.print("A's m3,");
    }
}
class B extends A{
    void m1(){
        System.out.print("B's m1,");
    }
}
class C extends B{
    void m3(){
        System.out.print("C's m3,"+(ivar+6));
    }
}
class Mixed2{
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A a2 = new C();
        /*
        a.m1();
        b.m2();
        c.m3();


        b.m1();
        c.m2();
        a.m3();
        //当对象和引用类型不一样时，引用类型调用方法时，调用的是当前对象的方法,而且是直接调用当前父类的。
        a2.m1();
        a2.m2();
        a2.m3();
        */
        c.m1();
        c.m2();
        c.m3();
    }
}


//这个题要用到多态，在多态下，引用和对象可以是不同的类型。
class MonsterTestDrive{
    public static void main(String[] args) {
        Monster[] ma = new Monster[3];
        ma[0] = new Vampire();
        ma[1] = new Dragon();
        ma[2] = new Monster();
        for(int x = 0;x<3;x++){
            ma[x].frighten(x);
            //当x==0时，调用的是第一个方法
            //当x==1时，调用的是第二个方法
            //当x==2时，调用的是第三个方法
        }
    }
}
class Monster{
    boolean frighten(int x){
        System.out.println("arrrgh?");
        return true;
    }
}
class Vampire extends Monster{
    boolean frighten(int x){
        System.out.println("a bite?");
        return true;
    }

}
class Dragon extends Monster{
    boolean frighten(int degree){
        System.out.println("breath fire");
        return true;
    }
}





//这个题要考虑到继承中方法可以继承并可以覆盖，不要定式思维
class Rowboat  extends Boat{
    public  void rowTheBoat() {
        System.out.print("stroke natasha");
    }
}
 class Boat{
    //在进行封装的时候要使用setter和getter方法，要记住这个关键点，也是解决问题的关键
    private int length;
     public void setLength(int len){
         length = len;
     }
     public int getLength(){
         return length;
     }
     public void move(){
         System.out.println("drift");
     }
 }
 class TestBoats{
     public static void main(String[] args) {
         Boat b1 = new Boat();
         Sailboat b2 = new Sailboat();
         Rowboat b3 = new Rowboat();
         b2.setLength(32);
         b1.move();
         b3.move();
         b2.move();
     }
 }
 class Sailboat extends Boat{
    public void move(){
        System.out.println("hoist sail");
    }
 }
