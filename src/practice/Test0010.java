package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test0010 {
}
/*
第十章：数字与静态
 */
class Player{
    static int playerCount = 0;
    private String name;
    public Player(String n){
        name = n;
        playerCount++;
    }
}
class PlayerTestDrive{
    public static void main(String[] args) {
        System.out.println(Player.playerCount);
        //对象创建之后。
        Player one = new Player("Tiger Woods");
        System.out.println(Player.playerCount);
    }
}
class Foo{
    static int x;
    public void go(){
        System.out.println(x);
    }
}
class F002{
    /*
    这个编译不会通过。
     */
    int x;
    public static void go(){
        //非静态方法不能调用静态方法。
        //System.out.println(x);
    }
}
class Foo3{
    /*
    这个编译不会通过
     */
    //final变量没有初始化
    //final int x;
    public void go(){
        //System.out.println(x);
    }
}
class Foo4{
    static final  int x =12;
    public void go(){
        System.out.println(x);
    }
}
class Foo5{
    static final int x =12;
    public void go(final int x){
        System.out.println(x);
    }
}
class Foo6{
    int x =12;
    public static void go(final int x){
        System.out.println(x);
    }
}
class TestBox{
    Integer i;
    int j;

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }
    public void go(){
        j=i;
        System.out.println(j);
        System.out.println(i);
    }
}
class Fo{
    public static void main(String[] args) {
        String s = String.format("%,6.1f",42.000);
        Date today = new Date();
        String t = String.format("%tA,%tB,%td",today,today,today);
        System.out.println(s);
        System.out.println(t);
    }
}
class StaticSuper{
    /*
    在含有静态初始化块的程序中，首先执行的是初始化块，然后是测试方法中的，最后是构造器中的输出。
     */
    //静态初始化块，不能直接访问非静态成员。
    static {
        System.out.println("super static block");
    }
    StaticSuper(){
        System.out.println("super constructor");
    }
}
class StaticTests extends StaticSuper{
    static int rand;
    //静态初始化块，不能直接访问非静态成员。
    static {
        rand = (int)(Math.random()*6);
        System.out.println("static block"+rand);
    }
    //构造函数
    StaticTests(){
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println("int main");
        StaticTests st = new StaticTests();
    }

}
/*
DateFormat类和SimpleDateFormat类
操作日期Calendar日历类
 */
class TestDateFormat{
    public static void main(String[] args)throws Exception{
        //new出SimpleDateFormat对象
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");
        //将时间对象转换为字符串
        String daytime = s1.format(new Date());
        System.out.println(daytime);
        System.out.println(s2.format(new Date()));
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
        //将符合指定格式的字符串转换成时间对象，字符串格式需要和指定格式一样
        String time = "2017-10-7";
        String time1 = "2016-11-11 00:11:11";
        Date date = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(time1);
        //Date date = s2.parse(time);
        System.out.println("date1:"+date);
        time="2017-10-7 20:15:30";
        date = s1.parse(time);
        System.out.println("date2:"+date);
    }
}
//可视化日历编写
class TestCalendar2{
    public static void main(String[] args)throws ParseException {
        System.out.println("请输入日期(格式为:2010-3-3)");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        //将输入的字符串转为日期类
        System.out.println("您刚刚输入的日期为："+dateString);
        //在给定的正则表达式来分割该字符串
        String[] str = dateString.split("-");
        int year = Integer.parseInt(str[0]);
        int month= Integer.parseInt(str[1]);
        int day = Integer.parseInt(str[2]);
        //int month = new Integer(str[1]);
        //int day = new Integer(str[2]);
        //为具有默认语言环境的默认时区构造一个具有给定日期和时间设置
        Calendar c = new GregorianCalendar(year,month-1,day);
        /*
        自己补充一种形式，将字符串通过SImpleDateFormat转化为Date对象
        再将Date对象转换成日期类
        SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdfDateFormat.parse(dateString);
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
         */
        c.set(Calendar.DATE,1);
        //week:1-7 日一二三四五六
        //得出1号对应的是星期几
        int dow = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        //打印出1号对应星期几前面的空格，方便后续打印。
        for(int i =0;i<dow-1;i++){
            System.out.print("\t");
        }
        //使用这个方法获取每月的最后一天。
        int maxDate = c.getActualMaximum(Calendar.DATE);
        for(int i =0;i<maxDate;i++){
            //新建一个字符序列对象，是一个可变字符序列
            StringBuilder sBuilder = new StringBuilder();
            //如果日期刚好和今天对应的日期相等。
            if(c.get(Calendar.DATE)==day){
                sBuilder.append(c.get(Calendar.DATE)+"*\t");
            }else {
                sBuilder.append(c.get(Calendar.DATE)+"\t");
            }
            System.out.print(sBuilder);
            //如果碰到了星期六直接换行，从另外一行重新开始记
            if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
                System.out.print("\n");
            }
            c.add(Calendar.DATE,1);
        }


    }
}
class FullMoons{
    static int DAY_IM = 1000*60*60*24;
    public static void main(String[] args) throws ParseException{
        Calendar c = Calendar.getInstance();
        //c.set(2004,0,7,15,40);
        c.set(2004,0,7,15,40);
        long day1 = c.getTimeInMillis();
        for (int x =0;x<60;x++){
            day1 += (DAY_IM*29.52);
            c.setTimeInMillis(day1);
            //将数字进行格式化，为了输出。
            System.out.println(String.format("full moon on %tc",c));
        }
    }
}