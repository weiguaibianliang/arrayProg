package JAVA8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 语法格式一：无参数，无返回值
 * () -> System.out.println("Hello Lambda!");
 */
public class TestLambda2 {
    @Test
    public void test1(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        r.run();
        System.out.println("----------------");
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }
    /**
     * 语法格式二:有一个参数，且无返回值
     */
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("hhjjjjjjkkk");
    }
    /**
     * 语法格式三:有两个参数，且有返回值，有多条lambda语句
     */
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) ->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
        com.compare(3,5);
    }


    //需求：对一个数进行计算
    @Test
    public void test6(){
    Integer num = operation(100,(x) -> x*x);
        System.out.println(num);
        System.out.println(operation(200,(y)->y+200));
    }
    public Integer operation(Integer num,MyFun mf){
        return mf.getValue(num);
    }



}
