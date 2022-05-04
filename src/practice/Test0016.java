package practice;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;



//枚举是一种特殊的类，一般表示一组常量，比如一年的4个季节等等。

class TestEnum{
    enum Color{
        RED,GREEN,BLUE;
    }
    //执行输出结果
    public static void main(String[] args) {
        //创建一个引用来储存红色
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}

//迭代枚举元素
enum Color{
    RED,GREEN,BLUE;
}
 class MyClass000{
     public static void main(String[] args) {
         Color[]  arr = Color.values();
         for (Color myVar: arr) {
             System.out.println(myVar);
         }
     }
}
//values()返回枚举类中的所有的值
//ordinal()方法可以找到每个枚举量的索引，就像数组索引一样。
//valueOf()方法返回指定字符串值的枚举常量。
enum Color1{
   RED,GREEN,BLUE;
}
class Test000{
    public static void main(String[] args) {
        //调用values()
        Color1[] arr = Color1.values();
        //迭代枚举
        for (Color1 col: arr) {
            //查看索引,返回对应颜色的下标索引.
            System.out.println(col+"at index"+col.ordinal());
        }
        //使用valueOf返回枚举常量
        System.out.println(Color.valueOf("GREEN"));
    }
}

//枚举类成员，和普通类一样，可以用自己的变量、方法和构造函数，构造函数只能使用private访问修饰符，所以外部无法调用。
//枚举既可以包含具体方法，也可以包含抽象方法。如果枚举类具有抽象方法，则枚举类的每个实例都必须实现它。
enum Color2{
    RED,GREEN,BLUE;
    //构造函数
    private Color2(){
        System.out.println("Constructor called for:"+this.toString());
    }
    public void colorInfo(){
        System.out.println("Universal Color");
    }
}
class TestColor2{
    //输出
    public static void main(String[] args) {
        Color2 c1 = Color2.RED;
        System.out.println(c1);
        c1.colorInfo();

    }
}


//集合与泛型

public class Test0016 {
}

class GenericMethodTest{
    //泛型方法printArray
    public static <E> void printArray(E[] inputArray){
        //输出数组元素
        //创建一个各种类型的数组，用泛型表示。
        for(E element: inputArray){
            System.out.print(element+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //创建不同类型数组：Integer,Double,和Character
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3,4.4};
        Character[] charArray = {'H','E','L','L','O'};
        System.out.println("整型数组元素为：");
        //传递一个整型数组
        printArray(intArray);
        System.out.println("\n双精度型数组元素为：");
        //传递一个双精度型数组
        printArray(doubleArray);
        System.out.println("\n字符型数组元素为：");
        //传递一个字符型数组
        printArray(charArray);
    }
}
//限制被允许传递到一个类型参数的类型种类范围
class MaximumTest{
    //比较三个值并返回最大值
    //用泛型定义不同的java类的类型type
    //泛型类来继承接口
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;//假设x是初始最大值
        if(y.compareTo(max)>0){
            max = y;//y更大
        }
        if(z.compareTo(max)>0){
            max = z;//现在z更大
        }
        return max;//返回最大对象
    }

    public static void main(String[] args) {
        System.out.printf("%d,%d和%d中最大的数为%d\n\n",3,4,5,maximum(3,4,5));
        System.out.printf("%.1f,%.1f和%.1f中最大的数为%.1f\n\n",6.6,7.7,8.8,maximum(6.6,8.8,7.7));
        System.out.printf("%s,%s和%s中最大的数为%s\n","pear","apple","orange",maximum("pear","apple","orange"));
    }
}
//泛型类
class Box<T>{
    private T t;
    public void add(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();
        integerBox.add(new Integer(10));
        stringBox.add(new String("菜鸟教程"));
        System.out.printf("整数型值为 ：%d\n\n",integerBox.get());
        System.out.printf("字符串为 :%s\n",stringBox.get());
    }
}
//类型通配符一般是使用?代替具体的类型参数。例如List<?>在逻辑上是List<String>,List<Integer>等所有List<具体类型实参>的父类。
class GenericTest{
    public static void main(String[] args) {
       // List<String> name = new ArrayList<String>();
        //声明与指定泛型类型的变量

        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();
        name.add("icon");
        age.add(18);
        number.add(314);
        //静态方法可以直接调用静态方法中的方法，直接写就行。
        getData(name);
        getData(age);
        getData(number);
    }
    public static void getData(List<?> data){
        //表示list表中的类型是不确定的，可以添加任意类型。
        System.out.println("data :"+data.get(0));
    }
}
/*
class Jukebox1{
    //歌曲名称会存在String的Arraylist上
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        //new Jukebox1().go();
        Jukebox1 j = new Jukebox1();
        j.go();
    }
    //创建并实现Comparator的内部类，注意到类型参数和要比较的类型是相符的
    class ArtistCompare implements Comparator<Song>{
        public int compare(Song one, Song two){
            return one.getArtist().compareTo(two.getArtist());
        }
    }
    //这个方法会载入文件并列出内容
    public void go(){
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
        //创建Comparator实例
        ArtistCompare artistCompare = new ArtistCompare();
        //调用sort()，传入list与Comparator对象
        Collections.sort(songList,artistCompare);
        System.out.println(songList);
    }
    //读取文件的程序
    void getSongs(){
        try{
            File file = new File("D:\\aaa\\SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine())!=null){
                addSong(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    void addSong(String lineToParse){
        //spilt()方法会用反斜线来拆开歌曲内容
        String[] tokens = lineToParse.split("/");
        //因为只需要歌名，所以只取第一项加入SongList
        songList.add(tokens[0]);
    }
}

 */
/*
List接口中的ArrayList接口
 */
class RunoobTest{
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<String>();
        //添加元素到ArrayList可以使用add()方法
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites);
        //访问ArrayList中的元素可以用get()方法
        System.out.println(sites.get(1));
        //修改ArrayList的元素可以使用set()方法
        sites.set(2,"Wiki");
        System.out.println(sites);
        //要删除ArrayList中的元素可以使用remove()方法
        sites.remove(3);
        System.out.println(sites);
        //计算ArrayList中的元素数量
        System.out.println(sites.size());
        //对实例字母进行排序
        Collections.sort(sites);
        //用for来迭代数组列表中的元素
        for(int i = 0;i<sites.size();i++){
            System.out.println(sites.get(i));
        }
        //对sites进行拷贝
        //ArrayList<String> cloneSites = (ArrayList<String>) sites.clone();
        ArrayList<String> cloneSites = (ArrayList<String>) sites.clone();
        System.out.println("拷贝ArrayList:"+cloneSites);
    }
}
//ArrayList中的addAll()方法
class Main{
    public static void main(String[] args) {
        //创建一个动态数组
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
        //往动态数组里添加元素
        primeNumbers.add(3);
        primeNumbers.add(5);
        System.out.println("Prime Numbers:"+primeNumbers);
        //创建另外一个动态数组
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        //把primeNumbers的所有元素添加到numbers的动态数组中
        numbers.addAll(primeNumbers);
        System.out.println("Numbers:"+numbers);
    }
}
//将Arraylist对象转换为一个数组
class Main1{
    public static void main(String[] args) {
        //创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();
        sites.add("Runoob");
        sites.add("Google");
        sites.add("Wiki");
        sites.add("Taobao");
        System.out.println("网站列表："+sites);
        //将Arraylist对象转换为数组
        //该方法没有参数
        Object[] obj = sites.toArray();
        //输出数组中的所有元素
        System.out.print("Array:");
        for(Object item:obj){
            System.out.print(item+",");
        }
    }
}
//迭代HashMap
class RunoobTest1 {
    public static void main(String[] args) {
        //创建HashMap对象sites
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        //添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");
        //输出key和value
        /*
        for (Integer i : Sites.keySet()) {
            System.out.println("key:" + i + "value:" + Sites.get(i));
        }
         */
        for(Integer i: Sites.keySet()){
            System.out.println("key:"+i+Sites.get(i));
        }
        //返回所有value值
        for (String value : Sites.values()) {
            //输出每一个value
            System.out.print(value + ",");
        }
    }
}
    //迭代器中删除集合中的元素使用remove()方法
    class RunoobTest2{
        public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(12);
            numbers.add(8);
            numbers.add(2);
            numbers.add(23);
            //获取迭代器
            Iterator it = numbers.iterator();
            //检测集合中是否还有元素
            while(it.hasNext()){
                //会返回迭代器的下一个元素，并且更新迭代器的状态
                it.next();
                //将迭代器返回的元素删除。
                it.remove();
                System.out.println(it.next());
            }
            /*
            Iterator<Integer> it = numbers.iterator();
            while(it.hasNext()){
                Integer i = it.next();
                if(i<10){
                    //删除小于10的元素
                    it.remove();
                }
            }
            System.out.println(numbers);

             */
        }
    }


