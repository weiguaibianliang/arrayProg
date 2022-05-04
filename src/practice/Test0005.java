package practice;

public class Test0005 {
}
/*
class Dog{
    String name;

    public static void main(String[] args) {
        //创建Dog对象
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";
        //创建Dog数组
        Dog[] myDogs = new Dog[3];
        //关门放狗
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;//把最后一条狗的引用指向dog1
        //通过数组引用存取Dog
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";
        //myDog[2]的名字是？
        System.out.println("last dog's name is");
        System.out.println(myDogs[2].name);
        //逐个对Dog执行bark()
        int x = 0;
        while(x < myDogs.length){
            myDogs[x].bark();
            x = x+1;
        }
    }
    public void bark(){
        System.out.println(name+ "says Ruff!");
    }
    public void eat(){

    }
    public void chaseCat(){

    }
}

 */
/*
class Books{
    String title;
    String author;
}
class BookTestDrive{
    public static void main(String[] args) {
        //新建一个对象为myBooks的数组
        Books [] myBooks = new Books[3];
        int x = 0;
         myBooks[0] = new Books();
         myBooks[1] = new Books();
         myBooks[2] = new Books();
        myBooks[0].title = "The Grapes of Java";
        myBooks[1].title = "The Java Gatsby";
        myBooks[2].title = "The Java Cookbook";
        myBooks[0].author = "bob";
        myBooks[1].author = "sue";
        myBooks[2].author = "ian";
        while(x<myBooks.length){
            System.out.println(myBooks[x].title);
            System.out.println("by");
            System.out.println(myBooks[x].author);
            x = x+1;
        }
    }
}

 */
/*
class Hobbits{
    String name;

    public static void main(String[] args) {
        Hobbits[] h = new Hobbits[3];
        int z = 0;
        while(z<4){
            z = z+1;
            h[z] = new Hobbits();
            h[z].name = "bilbo";
            if(z==1){
                h[z].name = "frodo";
            }
            if(z==2){
                h[z].name = "sam";
            }
            System.out.println(h[z].name+"is a");
            System.out.println("good Hobbit name");
        }
    }
}

 */
/*
class TestArrays{
    public static void main(String[] args) {
        String [] islands = new String[4];
        islands[0] = "Bermuda";
        islands[1] = "Fiji";
        islands[2] = "Azores";
        islands[3] = "Cozumel";
        int [] index = new int[4];
        index[0] = 1;
        index[1] = 3;
        index[2] = 0;
        index[3] = 2;
        int y = 0;
        //int ref;
        while(y<4){
            int ref;
            ref = index[y];
            System.out.print("island =");
            System.out.println(islands[ref]);
            y = y+1;
        }


    }
}

 */
/*
class Triangle{
    double area;
    int height;
    int length;

    public static void main(String[] args) {
        int x = 0;
        Triangle [] ta = new Triangle[4];
        while(x<4){
            ta[x] = new Triangle();
            ta[x].height = (x+1)*2;
            ta[x].length = x+4;
            ta[x].setArea();
            System.out.print("triangle"+x+", area");
            System.out.println("="+ta[x].area);
            x = x+1;
        }
        int y = x;
        x= 27;
        Triangle t5 = ta[2];
        ta[2].area = 343;
        System.out.print("y="+y);
        System.out.println(", t5 area = "+ t5.area);
    }
    void setArea(){
        area = (height * length)/2;
    }
}
class HeapQuiz{
    int id = 0;

    public static void main(String[] args) {
        int x = 0;
        HeapQuiz[] hq = new HeapQuiz[5];
        while(x<3){
            hq[x] = new HeapQuiz();
            hq[x].id = x;
            x = x+1;
        }
        hq[3] = hq[1];
        hq[4] =hq[1];
        hq[3] = null;
        hq[4] = hq[0];
        hq[0] = hq[3];
        hq[3] = hq[2];
        hq[2] = hq[0];
        // do stuff
    }
}

 */
/*
class Dog{
    int size;
    String name;
    void bark(){
        if(size > 60){
            System.out.println("Woof! Woof!");
        }
         else if(size>14){
            System.out.println("Ruff! Ruff!");
        }
        else {
            System.out.println("Yip! Yip!");
        }
    }
}
class DogTestDrive{
    public static void main(String[] args) {
        Dog one = new Dog();
        one.size = 70;
        Dog two = new Dog();
        two.size = 8;
        Dog three = new Dog();
        three.size = 35;
        one.bark();
        two.bark();
        three.bark();
    }
}
 */
/*
class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        int x = 5;
        void go(int z){
            z = 0;
            t.go(x);
        }
    }
}

 */
/*
class ElectriGuitar{
    String brand;
    int numOfPickups;
    boolean rocksStarUsesIt;
    String getBrand(){
        return brand;
    }
    void setBrand(String aBrand){
        brand = aBrand;
    }
    int getNumOfPickups(){
        return  numOfPickups;
    }
    void setNumOfPickups(int num){
        numOfPickups = num;
    }
    boolean getRocksStarUsesIt(){
        return rocksStarUsesIt;
    }
    void setRocksStarUsesIt(boolean yesOrNo){
        rocksStarUsesIt = yesOrNo;
    }
}

 */
/*
class GoodDog {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    void bark() {
        if (size > 60) {
            System.out.println("Woof! Woof!");
        } else if (size > 14) {
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }
}
    class GoodDogTestDrive{
        public static void main(String[] args) {
            GoodDog one = new GoodDog();
            one.setSize(70);
            GoodDog two = new GoodDog();
            two.setSize(8);
            System.out.println("Dog one:"+one.getSize());
            System.out.println("Dog two:"+two.getSize());
            one.bark();
            two.bark();

        }
    }

 */
/*
class XCopy{
    public static void main(String[] args) {
        int orig = 42;
        XCopy x = new XCopy();
        int y = x.go(orig);
        System.out.println(orig+""+y);
    }
    int go(int arg){
        arg = arg*2;
        return arg;
    }
}

 */
class Clock{
    private String time;
    void setTime(String t){
        time = t;
    }
     String  getTime(){
        return time ;
    }
}
class ClockTestDrive{
    public static void main(String[] args) {
        Clock c = new Clock();
        c.setTime("12345");
        String tod = c.getTime();
        System.out.println("time:"+tod);
    }
}