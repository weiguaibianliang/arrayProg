package practice;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class FirstPractice10 {
}
class Test101{
    public static void main(String[] args) {
        String str = "abc";
        twice(str);
        String xx = twice(str);
        System.out.println(xx);
    }
    public static String twice(String str){
        return str += new StringBuilder(str).reverse();
    }
}
class Test111{
    public static void main(String[] args) {
        String str = "I like beijing.";
        two(str);
        String xx = two(str);
        System.out.println(xx);
    }
    public static String two(String str){
        //用新字符串代替旧字符串
        return str.replace("I like beijing.",".beijing like I");
    }
}
class Test11201{
    /*
    输入两个字符串，从第一个字符串中删除第二个字符串中所有的字符
     */
    public static void main(String[] args) {
        String str1 = "They are students.";
        String str2 = "aeiou";
        for(int i = 0;i<str2.length();i++){
            int idx = 0;
            //int indexOd(String str)这个方法返回从头开始查找第一个子字符串str在字符串中的索引位置，如果未找到，则返回-1.
            while((idx= str1.indexOf(str2.charAt(i)))!=-1){
               //截取从指定索引位置开始到字符串结尾的子串。
                str1 = str1.substring(0,idx)+str1.substring(idx+1);
            }
        }
        System.out.println(str1);
    }

}
class Test11202{
    /*
    输入两个字符串，从第一个字符串中删除第二个字符串中的所有字符
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入第一个字符串
        System.out.print("输入第一个字符串");
        String str1 = scanner.next();
        //输入第二个字符串
        System.out.print("输入第二个字符串");
        String str2 = scanner.next();
        str1 = str1.replace("","-");
        String[] first = str1.split("-");
        str2 = str2.replace("","-");
        String[] second = str2.split("-");
        for(int i = 0;i<first.length;i++){
            for(int j =0;j<second.length;j++){
                //判断相等的部分
                if(first[i].equals(second[j])){
                    str1 = str1.replace(first[i],"");
                }
            }
        }
        System.out.println("删除第二个字符串之后的字符串str1为："+str1);
    }
}
class Test113{
    public static void main(String[] args) {
        File dir = getDir();
        printJavaFile(dir);

    }
    /*
    1、获取键盘录入的文件夹路径
    2、返回值类型File
    3、不需要有参数
     */
    public static File getDir(){
        //创建键盘录入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径");
        while(true){
            //将键盘录入的文件夹路径存储
            String line = scanner.nextLine();
            //封装成file对象
            File dir = new File(line);
            if(!dir.exists()){
                System.out.println("您录入的文件夹路径不存在，请重新录入");
            }
            else if(dir.isFile()){
                System.out.println("您录入的是文件路径，请重新录入文件夹路径");
            }
            else {
                return dir;
            }
        }
    }
    /*
    1、获取文件夹路径下的所有.java文件
    2、返回值类型 void
    3、参数列表 File dir
     */
    public static void printJavaFile(File dir){
        //获取该文件夹路径下的所有的文件和文件夹，存储在File数组中
        File[] subFiles = dir.listFiles();
        //遍历数组，对每一个文件或文件夹做判断
        for (File subFile:subFiles) {
            //如果是文件，并且后缀是.java,就打印
            if(subFile.isFile()&&subFile.getName().endsWith(".java")){
                System.out.println(subFile);
            }
            //如果是文件夹，就递归调用
            else if(subFile.isDirectory()){
                printJavaFile(subFile);
            }
        }
    }
}
class Test114{
    public static void main(String[] args) {
        //键盘输入输出
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要测试的字符串");
        while (scanner.hasNext()){
            //请输入你要测试的字符串
            //
            String str = scanner.next();
            //判断输入字符串的合法性
            if(str.length()==0||str==null||str.length()>255){
                System.out.println("输入的字符串不合理，请重新输入");
            }
            //创建一个br对象来存放数字串
            StringBuffer br = new StringBuffer();
            //将字符串转换为字符数组
            char[] chars = str.toCharArray();
            for (char ahar:chars) {
                if(ahar>='0'&&ahar<='9'){
                    br.append(ahar);
                }
                else {
                    br.append("");
                }

            }
            //将新生成的数字串转为字符串
            String str1 = br.toString();
            //将字符串进行分割成一个或多个空格
            String[] nums = str1.split("\\s+");
            //存放最长数字串为maxsize
            int maxsize = 0;
            //将数字串maxsize的长度与String数组任一变量的长度进行比较
            for(int i = 0;i<nums.length;i++){
                if(maxsize<nums[i].length()){
                    maxsize = nums[i].length();
                }

            }
            for(int i = 0;i<nums.length;i++){
                if(maxsize==nums[i].length()){
                    System.out.println(nums[i]+",");
                }
            }
            System.out.println(maxsize);

        }
    }
}

class Student102{
    private int age;
    private String name;
    public  Student102(){}
    public Student102(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name+""+age;
    }
}
class TestStudent102{
    public static void main(String[] args) {
        Student102 stu1 = new Student102("tom",18);
        System.out.println(stu1+" "+100);
    }
}

interface IA103{
    void ma();
}
class MyClass103 implements IA103{
    public void ma(){}
    public String toString(){
        return "MyClass103 toString()";
    }
}
class TestMyClass103{
    public static void main(String[] args) {
        IA103 ia = new MyClass103();
        System.out.println(ia);
    }
}

class Test104{
    public static void main(String[] args) {
        String string = "ABC137GMNQQ2049PN5FFF";
        //调用这个构造函数
        remove(string);
        String xx = remove(string);
        System.out.println(xx);
        char[] chars = string.toCharArray();
        //把字符数组进行按顺序排列。
        Arrays.sort(chars);
        for (char achar:chars) {
            if(achar>='0'&&achar<='9'){
                //Arrays.sort(chars);
                System.out.print(achar);
            }
        }
    }
    public static   String remove(String string){
        return string;
    }
}

class Test105{
    private static int n;
    //private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        //在魔法机器1投入的魔法币的数量为c
        System.out.println("魔法币的数量c");
        int c = scanner.nextInt();
        //在魔法机器2投入的魔法币的数量为d
        System.out.println("魔法币的数量d");
        int d = scanner.nextInt();
        String string ="12";
        char[] chars = string.toCharArray();
        for (char ahar: chars) {
            if(ahar=='1'){
                a = 2*c +1;
                System.out.println(a);
            }
             if(ahar=='2'){
                b = 2*d +1;
                System.out.println(b);
            }
            if(c+d==10&&a+b==n){
                System.out.println(n);
            }
        }


    }
}
class Test107{
    /*
    小易准备去魔法王国采购魔法神器，
    购买魔法神器需要使用魔法币。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入你总共需要的魔法币的数量
        System.out.println("输入你总共需要的魔法币的数量");
        long n = scanner.nextLong();
        fun(n);
    }
    public static void fun(long n){
        //根据魔法币的数量来判断最后需要魔法机器的排序方法
        String string;
        if(n==0){
            return ;
        }
        if(n%2==1){
            //对应的是奇数的形式
            fun((n-1)/2);
            System.out.print('1');
        }
        else {
            //对应的是偶数的形式
            fun((n-2)/2);
            System.out.print('2');
        }
    }
}

class Test106{
    public static void main(String[] args) {
        String s1 = new String("amit");
        System.out.println(s1.replace('m','r'));
        System.out.println(s1);
        String s3 = "arit";
        String s4 = "arit";
        String s2 = s1.replace('m','r');
        System.out.println(s2==s3);
        System.out.println(s3==s4);
    }
}

