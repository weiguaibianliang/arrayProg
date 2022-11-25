package BaseAlgorithm;

import java.util.Scanner;

/**
 * 利用条件运算符的嵌套来完成此题：学习成绩 >= 90分的同学用A表示，60-89分之间的用B表示，60分以下的用c表示。
 */
public class Test5 {
    //程序分析: (a>b)?a:b 这是条件运算符的基本例子
    public static void main(String[] args) {
        System.out.println("请输入你的分数：");
        Scanner scanner = new Scanner(System.in);
        //获取输入的成绩
        int n = scanner.nextInt();
        //等级判断
        String belong = n >=90?"A":(n >= 60?"B":"C");
        System.out.println(n + "分属于："+ belong);
    }
}
