package practice;
//接口与抽象类
public class Test0008 {
}
class Animal{
    public static void main(String[] args) {

    }
}
class Dog extends Canine{

}
class Cat extends Canine{

}
abstract class Canine extends Animal{
    public void roam(){}
}
class MakeCanine{
    public void go(){
        Canine c;
        c = new Dog();
        //这个类已经被标记为abstract，抽象类无法初始化类的对象,无法实例化。
        //c = new Canine() ;
        c.roam();

    }
}
//多态的使用
class MyDogList{
    //实际上使用的是数组
    private Dog[] dogs = new Dog[5];
    //增加新的Dog就加1
    private int nextIndex = 0;
    public void add(Dog d ){
        //如果没有超出上限就把Dog加进去并列出信息
        if(nextIndex<dogs.length){
            dogs[nextIndex] = d;
            System.out.println("Dog added at"+ nextIndex);
            //递增计数
            nextIndex++;
        }
    }
}
class MyCatList{
    //实际上使用的是数组
    private Cat[] cats = new Cat[5];
    //增加新的Dog就加1
    private int nextIndex = 0;
    public void add(Cat c ){
        //如果没有超出上限就把Dog加进去并列出信息
        if(nextIndex<cats.length){
            cats[nextIndex] = c;
            System.out.println("Dog added at"+ nextIndex);
            //递增计数
            nextIndex++;
        }
    }
}
//自己创建的Animal通用list
class MyAnimalList{
    //这个只是保存Animal的数组对象,并不是实例化一个对象
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;
    public void add(Animal a){
        if(nextIndex<animals.length){
            animals[nextIndex] = a;
            System.out.println("Animal added at"+ nextIndex);
            nextIndex++;
        }
    }
}
class AnimalTestDrive{
    public static void main(String[] args) {
        MyAnimalList list = new MyAnimalList();
        Dog a = new Dog();
        Cat c = new Cat();
        /*
        //将object类型转换为Dog类型
        Object o = al.get(index);
        Dog d = (Dog) o;
        d.roam();
         */
        list.add(a);
        list.add(c);
        //列出此对象的哈希代码
        System.out.println(c.hashCode());
        //告诉你此对象是从哪里被初始化的
        System.out.println(c.getClass());
        //列出一个类的名称和一个我们不关心的数字。
        System.out.println(c.toString());
        //判断两个对象是否相等
        if(a.equals(c)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
/*
//当把对象装进ArrayList<Dog>时，会当作Dog来输入与输出。
ArrayList<Dog> myDogArrayList = new ArrayList<Dog>();
Dog aDog = new Dog();
myDogArrayList.add(aDog);
Dog d = myDogArrayList.get(0);
//如果声明为Object类型的,那么如果用上面的方法不能通过编译。
 */




/*
设计与实现Pet接口
 */
interface Pet{
    public abstract void beFriendly();
    public abstract void play();
}
//调用父类的方法，super关键字的使用。
abstract class Report{
    void runReport(){
        //设置报告
    }
    void printReport(){
        //输出
    }
}
class BuzzwordsReport extends Report{
    void runReport(){
        //super调用的是父类的方法
        super.runReport();
        buzzwordCompliance();
        printReport();
    }
    void buzzwordCompliance(){

    }
}
//practice来训练刚才学过的内容
//练习继承和实现接口
/*
class Top{ };
class Tip extends Top{};

class Fee{};
class Fi extends Fee{};

interface Foo{};
class Bar implements Foo{};
class Baz extends Bar;

interface Zeta;
interface Beta;
class Delta extends Alpha implements Beta{};
class Alpha implements Zeta;

 */

//泳池迷宫
interface Nose{
    public int iMethod();
}
abstract class Picasso implements Nose {
    public int iMethod() {
        return 7;
    }
}
class Clowns extends Picasso{};
class Acts implements Nose{
    public int iMethod(){
        return 5;
    }
}
 class Of76 extends Clowns{
     public static void main(String[] args) {
         Nose[] i = new Nose[3];
         i[0] = new Acts();
         i[1] = new Clowns();
         i[2] = new Of76();
         for(int x = 0;x<3;x++){
             System.out.println(i[x].iMethod()+" "+i[x].getClass());
         }
     }
}


