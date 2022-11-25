package EasyAlgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lambda、Stream流编程题
 */
public class Test4 {
}
/**
 * 请用Lambda表达式启用一个Thread线程，
 * 在其中打印1-100的数字。
 */
class Thread{
    public static void main(String[] args) {
        //用普通的方法创建线程对象
        Thread1 t = new Thread1();
        //开启线程，调用start方法
        t.start();
    }
    //通过继承Thread类来创建线程
    private static class Thread1 extends Thread{
        //重写run方法
        public void run(){
            for(int i = 2; i < 100; i+=2){
                System.out.println(i+"i");
            }
        }

        public void start() {

        }
    }
}

/**
 * 请使用Lambda表达式调用Collections的sort()方法，可以实现对一个List
 * 集合进行：降序排序。编写main()方法
 * 1、定义一个List集合，并存储以下数据
 * "cab","bac","acb","cba","bca","abc"
 * 2、使用Lambda表达式调用Collections的sort()方法对集合进行降序排序
 * 3、排序后向控制台打印集合的所有元素
 */
class Lambda2{
    public static void main(String[] args) {
        //定义一个集合，存储集合中的数据
        List<String> list = new ArrayList<>();
        //在集合中存储元素
        Collections.addAll(list,"cab","bac","acb","cba","bca","abc");
        //排序
        //Comparator是一个接口，是函数式接口
        Collections.sort(list,(String s1,String s2)->{
            return s1.compareTo(s2);
        });
        //把集合打印
        System.out.println(list);
    }
}
