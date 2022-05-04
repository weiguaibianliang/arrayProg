package practice;

import java.io.EOFException;
import java.io.IOException;
import java.sql.SQLException;

//包装类、数学类、日期类和异常
public class FirstPractice12 {
}
//关于异常类型的题型。
//执行try块，执行到return语句时，先执行到return的语句，但是不返回到main方法，
//接下来执行finally块，遇到finally块中的return语句，执行，并将值返回到main方法，这里就不会再回去去返回try块中计算得到的值。
//重要方法：e.toString()获取的信息包括异常类型和异常详细信息，而e.getMessage()只是获取了异常的详细信息字符串。
class Person121{
    private String name;
    private int age;

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
    public String toString(){
        return name+" "+age;
    }
}
class Test121{
    public static void main(String[] args) {
        System.out.println(m());
    }
    public static Person121 m(){
        Person121 p = new Person121();
        try{
            p.setName("Amy");
            p.setAge(15);
            return p;
        }
        catch (Exception e){
            p.setName("sam");
            p.setAge(12);
            return p;
        }
        finally {
            p.setName("Tom");
            p.setAge(13);
        }
    }
}

//包装类型、包装机制，基本类型和引用类型的转换。
class Test122{
    public static void main(String[] args) {
        //自动装箱
        String str = "3";
        Integer i = new Integer(str);
        System.out.println(i);
        //调用静态方法ParseInt将字符串转为数字,把String直接转换为int类型。
        String str1 = "999";
        int a = Integer.parseInt(str1);
        System.out.println(a);
        //将基本类型转换为字符串
        int b = 5;
        String str2 = String.valueOf(b);
        System.out.println(str2);
        //把String转换为Integer,再把Integer转换为int类型
        //自动装箱,将Integer转换为int类型
        Integer c = new Integer(10);
        int d = c.intValue();
        System.out.println(d);
        System.out.println(5>>2);
    }
}

class Super123{
    public void ma() throws IOException{}
}
interface IA123{
    void mb();
}
class MySub extends Super123 implements IA123{
    public void ma(){}
    @Override
    public void mb() {

    }
}

class TestTryCatch{
    public static void main(String[] args) {
        try{
            ma(2);
            System.out.println("No Exception");
        }
        catch (EOFException ex1){
            System.out.println("ex1");
        }
        catch (IOException ex2){
            System.out.println("ex2");
        }
        catch (SQLException ex3){
            System.out.println("ex3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ma(int n) throws Exception{
        if(n==1){
            throw new IOException();
        }
        else if(n==2){
            throw new EOFException();
        }
        else if(n==3){
            throw new SQLException();
        }
    }
}

/*
class Test125{
    public static void main(String[] args) {
        ma();
    }
    public static int ma(){
        try{
            m();
            return 100;
        }
        catch (Exception e){
            System.out.println("Exception");
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException");
        }
    }
    public static void m(){
        throw new MyException;

    }
}

 */

class TestMyException126{
    public static void main(String[] args) {
        try{
            System.out.println("main1");
            ma();
            System.out.println("main2");
        }
        catch (Exception e){
            System.out.println("Catch Exception in main");
            System.out.println(e.getMessage());
        }

    }
    public static void ma() throws  IOException{
        try{
            System.out.println("ma1");
            mb();
            System.out.println("ma2");
        }
        catch (SQLException e){
            System.out.println("Catch SQLException in ma");
            throw new IOException(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Catch Exception in ma");
            System.out.println(e.getMessage());
        }
    }
    public static void mb() throws SQLException{
        throw new SQLException("sql exception in mb");
    }
}

class Test127{
    public static void main(String[] args) {

    }
}
class MyException1 extends Exception{
    public MyException1(){

    }
    public MyException1(String message){
        super(message);
    }
}
class MyException2 extends IOException{
    public  MyException2(){}
    public MyException2(String Message){
        super(Message);
    }
}