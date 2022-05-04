package practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FirstPractice {
}
/*
class Help{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //请输入你的帮助内容标题
        System.out.println("帮助内容标题：");
        String tile = in.nextLine();
        //请输入你的帮助内容编码

        System.out.println("帮助内容编码：");
        String code = null;
        /*
        boolean isLetterDigit(String  str){
            String regex = "^[0-9a-zA-Z_]{1,32}$";
            return Pattern.matches(regex,str);
        }


        while(in.hasNext()){
            if(code.equals("^[0-9a-zA-Z_]{1,32}$")){
                code = in.nextLine();
                System.out.println("帮助内容编码为："+code);
                break;
            }
            else {
                System.out.println("请输入数字、字母、下划线组合，且不超过32位");
                 code = in.nextLine();
                continue;
            }
        }
        //请输入你的帮助暗示
        System.out.println("是否需要帮助Hint:");
        String Hint = in.nextLine();
        Help a = new Help();
        if(Hint=="需要"){
            a.Hover();
        }
        if(Hint=="不需要"){
            System.out.println("请输入你的标签");
        }
        //请输入你的标签
        System.out.println("tags:");
        String tags = in.nextLine();
        if(tags=="需要"){
            System.out.println("请输入你的帮助Hint");
            String t = in.nextLine();
        }
        if(tags=="不需要"){
            System.out.println("请输入你的帮助内容");
        }
        //请输入你的帮助内容
        System.out.println("帮助内容:");
        String information = in.nextLine();
    }
    public void Hover(){
        System.out.println("请输入简单的提示！");
    }
}

 */
class Help {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //请输入你的帮助内容标题
        System.out.println("帮助内容标题：");
        String title = scanner.nextLine();
        System.out.println("帮助内容标题" + title);
        //请输入你的帮助内容编码
        System.out.println("帮助内容编码：");

        String code = scanner.nextLine();
        System.out.println("帮助内容编码" + code);
        char[] chars = code.toCharArray();//将字符串转换为字符数组
        for (char aChar : chars) {
            if ((aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z') || (aChar >= '0' && aChar <= '9') || (aChar == '_')) {

                continue;
            } else {
                break;
            }
        }

            /*
            if(code.equals("^[0-9a-zA-Z_]{1,32}$")){
                code = scanner.nextLine();
                System.out.println("帮助内容编码为："+code);
                break;
            }
            else {
                System.out.println("请输入数字、字母、下划线组合，且不超过32位");
                code = scanner.nextLine();
            }
        }

             */
            //请输入你的帮助Hint
            System.out.println("帮助Hint:");
            String hint = scanner.nextLine();
            //请输入你的tags
            System.out.println("tags:");
            String lebal = scanner.nextLine();
            //请输入你的帮助内容
            System.out.println("帮助内容：");
            String information = scanner.nextLine();
    }
}
class Test14{
    public static void main(String[] args) {
        for(int i =1;i<=5;i++){
            for(int j = 1;j<=5;j++){
                //System.out.print(i+" ");
                System.out.print(j+"");
            }
            System.out.println();
        }
    }
}
//求1！+2！+3！+4！+5！+6！+7！+8！+9！+10！的和。
class Test015{
    public static void main(String[] args) {
        int s = 0;
        int x = 1;
        for(int i = 1;i<10;i++){
            for(int j =i;j<=i;j++){
                x=x*j;


            }
            s=s+x;
           //System.out.println(x);
            System.out.println(s);
        }
    }
}
class Test016{
    public static void main(String[] args) {
        int i = 0;
        while (i<10){
            System.out.println(i);
            i++;
        }
    }
}
//Day02的练习编程题
//有问题，不知道怎么解决。
/*
class Test017{
    public static void main(String[] args) {
        int i=5;
        switch (i){
            default:
                int y =5;
            case 1:
                y+=1;
            case 2:
                y+=2;
                break;
            case 3:
                y+=3;
            case 4:
                y+=4;
                System.out.println(y);
        }

    }
}
 */
class Test018{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //请输入一个整数，表示一个人的年龄。
        System.out.println("请输入一个整数，表示一个人的年龄");
        int a = scanner.nextInt();
        if (a<6){
            System.out.println("儿童");
        }else if(a>6&&a<13){
            System.out.println("少儿");
        }else if(a>14&&a<18){
            System.out.println("青少年");
        }else if(a>18&&a<35){
            System.out.println("青年");
        }else if(a>35&&a<50){
            System.out.println("中年");
        }else {
            System.out.println("中老年");
        }
    }
}

class Test019{
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        /*
        读入一个整数，如果是1~5之间，则分别输出5个福娃的名字，否则输出”北京欢迎你“
         */
        Scanner scanner = new Scanner(System.in);
        //读入一个整数，且整数在1~5之间
        System.out.println("输入一个整数！");
        int i = scanner.nextInt();
        switch (i){
            case 1:
                System.out.println('北');
                break;
            case 2:
                System.out.println('京');
                break;
            case 3:
                System.out.println('欢');
                break;
            case 4:
                System.out.println("迎");
                break;
            case 5:
                System.out.println('你');
                break;
        }
    }
}

class Test020{
    /*
    读入三个整数，输出这三个整数中最大的一个
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //请输入一个整数a
        System.out.println("请输入一个整数a");
        int a = scanner.nextInt();
        //请输入一个整数a
        System.out.println("请输入一个整数b");
        int b = scanner.nextInt();
        //请输入一个整数a
        System.out.println("请输入一个整数c");
        int c = scanner.nextInt();
        if((a>b&&b>c)||(a>c&&c>b)){
            System.out.println(a);
        }else if((b>a&&a>c)||(b>c&&c>a)){
            System.out.println(b);
        }else {
            System.out.println(c);
        }


    }
}
class Test021{
    /*
    读入一个表示年份的整数，判断这一年是否是闰年，
    如何判断一个年份是闰年。
     */
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        //请输入一个表示年份的整数
        System.out.println("请输入一个表示年份的整数：");
        int a = scanner.nextInt();
        if((a%4==0)&&(a%100!=0)||(a%100==0)&&(a%400==0)){
            System.out.println("这一年是闰年！");
        }
        else {
            System.out.println("这一年不是闰年！");
        }
    }
}
class Test022{
    /*
    完成一个简单的计算器程序
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数a为:");
        int a = scanner.nextInt();
        System.out.println("请输入一个整数b为:");
        int b = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入您的选择c:");
        String c = scanner.nextLine();
        //如果你输入的是字符串，那么你在控制台输入时，首先要把字符串转换为字符数组
        //这样才能成功的进行输入，最后取得成功。
        char [] chars = c.toCharArray();
        for (char achar : chars) {
            if(achar=='+'){
                System.out.println("输出结果为:"+(a+b));
            }else if(achar=='-'){
                System.out.println("输出结果为:"+(a-b));
            }else if(achar=='*'){
                System.out.println("输出结果为:"+(a*b));
            }else if(achar=='/'){
                System.out.println("输出结果为:"+(a/b));
            }
        }

    }
}
class Test023{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个三位数，计算其各位数字之和。");
        int a = scanner.nextInt();
        /*
        String string = Integer.toString(a);
        char[] chars = string.toCharArray();
        int sum = 0;
        for (int i = 0;i<chars.length;i++) {
           // sum = sum+string.charAt(i);
            System.out.println(string.charAt(i));
            //将字符串转换为primitive类型
            int x = Integer.parseInt(string);
            System.out.println(x);
            System.out.println("各位数字之和为:"+sum);
        }
         */
        int b = a/100;
        int c = a/10%10;
        int d = a%100%10;
        System.out.println("各位数之和为:"+(b+c+d));
    }
}
class Test024{
    //求阶乘
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("读入一个小于10的整数n");
        int n = scanner.nextInt();
        int x = 1;
        for (int i = 1;i<=n;i++){
            x = x*i;
            //System.out.println(x);
        }
        System.out.println(x);
    }
}
class Test025{
    public static void main(String[] args) {
        /*
        int a ;
        int b ;
        int c ;
        if(3*a+2*b+c==100){
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
        百钱买百鸡问题，3文钱可以买一只公鸡，2文钱可以买一只母鸡，1文钱可以买三只母鸡
        1文钱可以买三只小鸡，用100文钱买100只鸡，那么各有公鸡、母鸡、小鸡多少只？
        公鸡的数量为:5母鸡的数量为:32小鸡的数量63
        公鸡的数量为:10母鸡的数量为:24小鸡的数量66
        公鸡的数量为:15母鸡的数量为:16小鸡的数量69
        公鸡的数量为:20母鸡的数量为:8小鸡的数量72
         */
        int k =0;//给小鸡定义一个初始值
        for(int i=1;i<=33;i++){
            for(int j = 1;j<=50;j++){
                k = 100-i-j;
                if((k%3==0)&&(k/3+3*i+2*j==100)){
                    System.out.println("公鸡的数量为:"+i+"母鸡的数量为:"+j+"小鸡的数量"+k);
                }
            }
        }

    }
}
class Test026{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("读入一个整数n:");
        int n = scanner.nextInt();
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=i;j++){
                System.out.println('*');
            }

        }
    }
}
class ClassA{
    int value;
    public void method(int value){
        System.out.println(value);
    }
    public void method(){
        System.out.println(value);
    }
}
class TestClassA{
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.method();
        classA.value = 10;
        classA.method(20);
    }
}



