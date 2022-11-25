package EasyAlgorithm;


import java.util.HashMap;
import java.util.Map;

public class Test7 {
}
class HashMap_Demo{
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        //将指定的值与此映射中指定的键相关联
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        //返回指定键映射的值
        System.out.println(map.get("1"));
        //如果此映射包含指定键的映射，则返回true
        System.out.println(map.containsKey("1"));
        //如果此映射将一个或多个键映射到指定值，则返回true
        System.out.println(map.containsValue(1));
        //获得与键关联的值，返回与键关联的对象，或者如果未在映射中找到这个键，则返回defaultValue
        System.out.println(map.getOrDefault("3",0));
        System.out.println(map);
    }
}
//按值传递和按引用传递
//按值传递重要特点：传递的是值的拷贝，也就是说传递后就互不相关了。
class TempTest{
    private void test1(int a){
        //
        a = 5;
        System.out.println("test1方法中的a="+a);
    }

    public static void main(String[] args) {
        TempTest t = new TempTest();
        int a = 3;
        t.test1(a);//这里传递的参数a就是按值传递
        //传递后，test1方法对变量值的改变不影响这里的a。
        System.out.println("main方法中的a="+a);
    }
}
//按引用传递
//指的是在方法调用时，传递的参数是按引用进行传递，其实传递的引用的地址，也就是变量所对应的内存空间的地址
//传递的是值的引用，也就是说传递前和传递后都指向同一个引用（也就是同一个内存空间）
class TempTest1{
    private void test1(AA aa){
        aa.age = 20;
        System.out.println("test1方法中的age="+aa.age);
    }

    public static void main(String[] args) {
        TempTest1 t = new TempTest1();
        AA aa = new AA();
        aa.age = 10;
        t.test1(aa);//这里传递的参数a就是按引用传递
        System.out.println("main方法中的age="+aa.age);
    }
    static class AA{
        public  int age = 0;
    }
}



