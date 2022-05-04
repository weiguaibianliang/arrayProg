package practice;

import java.util.*;

public class FirstPractice13 {
}
class TestList{
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add("world");
        list.add("Hello");
        list.add("Learn");
        list.remove("Hello");
        //把新生成的数组的第一项删除掉。
        list.remove(0);
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

class Worker{
    String name;
    int age;
    double salary;
    public Worker(){

    }
    public Worker(String name,int age,double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public int hashCode(){
        //有时候类型不对，可以用其他的基本类型进行强转。
        return (int) (name.hashCode()+age+salary);
    }
    public boolean equals(Worker w){
        if(w.name==name&&w.salary==salary&&w.age==age){
            return true;
        }
        else {
            return false;
        }
    }
}
class TestWorker{
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Worker("jerry",18,2000));
        set.add(new Worker("tom",18,2000));
        set.add(new Worker("tom",18,2000));
       // Set s = new HashSet();
       // s.add(new Worker("jerry",18,2000));
        System.out.println(set.size());
        System.out.println(set);
        for (int i = 0;i<set.size();i++){
            System.out.println(set);
        }


    }
}
//写一个函数reverseList,该函数能够接受一个List，然后把该List倒序排列。
//也可以用工具类，直接反转集合中的元素。
class Test133{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Learn");
        //可以用工具类直接反转集合中的元素
        Collections.reverse(list);
        System.out.println(list);
        String s = reverseList(list);
        System.out.println("翻转后："+s);

    }
    public static String reverseList(List<String> list){
        //遍历一半的集合，i从前往后，j从后往前
        for(int i =0,j=list.size()-1;i<list.size()/2;i++,j--){
            //元素调换
            String s = list.get(i);
            list.set(i,list.get(j));
            list.set(j,s);
        }
        return list.toString();
    }

}

//用数组实现一个栈，实现其中的push/peek/pop/empty/research方法

class StackExer{
    class ArrayStack{
        //存储数据
        private String[] data = new String[10];
        private int size;//记录个数
        //把item压入堆栈顶部
        public void push(String str){
            //判断是否需要扩容
            if(size>data.length){
                //把数组进行扩容
                data = Arrays.copyOf(data,data.length*2);
            }
            data[size++] = str;
        }
        //查看堆栈顶部的对象，但不从堆中移除它
        public String peek(){
            //判断栈是否为空
            if(size==0){
                throw new EmptyStackException();
            }
            //获取栈顶元素
            return data[size-1];
        }
        //移除堆栈顶部的对象，并作为此函数的值返回该对象
        public String pop(){
            //获取栈顶元素
            String str = this.peek();
            //减少元素个数
            size--;
            return str;
        }
        //测试堆栈是否为空
        public boolean empty(){
            return size==0;
        }
        //返回对象在堆栈中的位置，以1位基数
        public int research(String str){
            //顺着放倒着拿
            for(int i =size-1;i>=0;i--){
                if(str==data[i]||str!=null&&data[i].equals(str)){
                    return size-i;
                }

            }
            //返回栈中不存在该元素
            return -1;
        }
    }
}

class MyKey{
    int keyValue;
    public MyKey(){}
    public MyKey(int value){
        this.keyValue = value;
    }
}
class MyValue{
    String value;
    public MyValue(){}
    public MyValue(String value){
        this.value = value;
    }
    public String toString(){
        return value;
    }
}
class TestMap{
    //map中的key值可以重复，但value值不能重复。
    public static void main(String[] args) {
        Map map = new HashMap();
        MyKey key1 = new MyKey(10);
        map.put(key1,new MyValue("abc"));
        map.put(new MyKey(10),new MyValue("cde"));
        System.out.println(map.get(key1));
        System.out.println(map.size());
    }
}
//已知有十六支男子足球队参加2008年北京奥运会，写一个程序，把这16支球队随机分成四个组，使用Math.random来产生随机数

class Test141{
    /*
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String[] str ={"科特迪瓦","阿根廷","澳大利亚","塞尔维亚","荷兰","尼日利亚","日本","美国","中国",
        "新西兰","巴西","比利时","韩国","喀麦隆","洪都拉斯","意大利"};
        for(int i=0;i<str.length;i++){
            list1.add(str[i]);
        }
        //产生循环
        while (true){
            //将list2清零
            list2.clear();
            while (true){
                //产生0-最大下标的随机数
                int a = (int)(Math.random()*list1.size());
                //在list1中拿出来一个字符串
                String s = list1.get(a);
                //把这个字符串放进list2中
                list2.add(s);
                //把这个字符串从list1中移除
                list1.remove(a);
                //当list2等于4的时候打印这4个字符串，跳出循环
                if(list2.size()==4){
                    for (String s2: list2) {
                        System.out.println(s2+" ");
                    }
                    break;
                }
            }
            System.out.println();
            //当list1中元素拿完的时候跳出循坏
            if(list1.size()==0){
                break;
            }
        }
    }

     */
    public static void main(String[] args) {
      String[] str ={"科特迪瓦","阿根廷","澳大利亚","塞尔维亚","荷兰","尼日利亚","日本",
              "美国","中国","新西兰","巴西","比利时","韩国","喀麦隆","洪都拉斯","意大利"};
      ArrayList<String> list1 = new ArrayList<>();
      ArrayList<String> list2 = new ArrayList<>();
      //把str[]数组中的字符串内容放进list1中
      for(int i=0;i<str.length;i++){
          list1.add(str[i]);
      }
      //判断第二层循环时
      while (true){
          //清空list2集合中的内容
          list2.clear();
          //判断第一层循环时
          while (true){
              //产生list1中的一个随机数
              int a = (int)(Math.random()*list1.size());
              //写出随机数对应list集合中对应的字符串内容
              String s = list1.get(a);
              //把对应的字符串内容传给list2
              list2.add(s);
              //同时删除list1中对应的内容
              list1.remove(s);
              //当list2产生4个字符串的时候打印这4个字符串，并跳出循环。
              if (list2.size()==4){
                  for(int i =0;i<list2.size();i++){
                      System.out.println(list2.get(i));
                  }
                  break;
              }
          }
          System.out.println();
          //当list1中的元素拿完时，立即跳出循环,这相当于第二个判断。
          if(list1.size()==0){
              break;
          }

      }
    }
}
