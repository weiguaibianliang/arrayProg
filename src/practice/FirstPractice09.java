package practice;
//接口、内部类、包、垃圾分代回收机制
public class FirstPractice09 {
}
class OuterClass{
    private int value1 = 100;
    private static int value2 = 200;
    public void method(int value3){
        final int value4 = 400;
        class InnerClass{
            public void print(){
                //System.out.println(value1);
                System.out.println(value2);
                System.out.println(value3);
                System.out.println(value4);
            }
        }
    }
}
//怎样实现接口
interface IA{
    void ma();
}
interface IB extends IA{
    void mb();
}
interface IC{
    void mc();
}
interface ID extends IB,IC{
    void md();
}
class ClassE implements ID{
    public void ma(){}
    public void mb(){}
    public void mc(){}
    public void md(){}
}
class TestClassE{
    public static void main(String[] args) {
        IC ic = new ClassE();
        ID id = new ClassE();
        //调用ma方法
        id.ma();
        //调用mb方法
        id.mb();
        //调用mc方法
        id.mc();
        //调用md方法
        id.md();
        System.out.println(ic instanceof IA);
        System.out.println(ic instanceof IB);
        System.out.println(ic instanceof IC);
        System.out.println(ic instanceof ID);
        System.out.println(ic instanceof ClassE);

    }
}

interface IA5{
    void ma(IB5 ib);
}
interface IB5{
    void mb();
}
class IA5Impl implements IA5{
    public void ma(IB5 ib){
        System.out.println("ma in IAImpl");
        ib.mb();
    }
}
class IB5Impl implements IB5{
    private IA5 ia;
    public void setIa(IA5 ia){
        this.ia =ia;
    }
    public void mb(){
        System.out.println("mb in IB5Impl");
    }
    public void method(){
        ia.ma(this);
    }
}
 class TestMain5{
     public static void main(String[] args) {
         IA5 ia = new IA5Impl();
         IB5Impl ib = new IB5Impl();
         ib.setIa(ia);
         ib.method();
     }
}

interface IA6{
    void ma();
}
class MyClass6{
    public static void method(IA6 ia){
        System.out.println("in method");
        ia.ma();
    }
}
 class TestInnerClass{
     public static void main(String[] args) {
         MyClass6.method(new IA6(){
             public void ma(){
                 System.out.println("ma in anonymous inner class");
             }
         });
         class MyMaClass implements IA6{
             public void ma(){
                 System.out.println("ma in local inner class");
             }
         }
         MyClass6.method(new MyMaClass());
     }
}

interface MediaPlayer{
     void play();
     void stop();
     void open();
}
class TapePlayer implements MediaPlayer{
    public void play(){
        System.out.println("播放磁带");
    }
    public void stop(){
        System.out.println("停止播放磁带");

    }
    public void open(){
        System.out.println("磁带出仓");
    }
}
class DVDPlayer implements MediaPlayer{
    public void play(){
        System.out.println("DVD播放");
    }
    public void stop(){
        System.out.println("DVD停止播放");

    }
    public void open(){
        System.out.println("DVD出仓");
    }
}
class CDPlayer implements MediaPlayer{
    public void play(){
        System.out.println("CD播放");
    }
    public void stop(){
        System.out.println("CD停止播放");

    }
    public void open(){
        System.out.println("CD出仓");

    }
}
class Controller{
    private MediaPlayer[] players;
    public MediaPlayer[] getPlayers(){
        return players;
    }

    public void setPlayers(MediaPlayer[] players) {
        this.players = players;
    }

    public Controller(){
        //构造函数中初始化players数组
        MediaPlayer[] mp = new MediaPlayer[3];
        mp[0] = new CDPlayer();
        mp[1] = new DVDPlayer();
        mp[2] = new TapePlayer();
        setPlayers(mp);

    }
    //对相应的设备调用play方法
    public void play(int i){
        players[i].play();
    }
    public void stop(int i){
        players[i].stop();
    }
    public void open(int i){
        players[i].open();
    }
}
class TestMedia{
    public static void main(String[] args) {
        Controller c = new Controller();
        c.play(1);
        c.play(2);
        c.play(0);
        c.stop(0);
    }
}

