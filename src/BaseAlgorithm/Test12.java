package BaseAlgorithm;

import java.util.Scanner;

/**
 * 企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万
 * 元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部
 * 分，可提成5%；40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可
 * 提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入当月利润为x");
        double x = scanner.nextDouble();
        //应发奖金总数
        double y = 0;
        if(x < 10){
            y = x * 0.1;
        }
        else if(x > 10 && x < 20){
            y = 10 * 0.1 + (x - 10) * 0.075;
        }
        else if(x > 20 && x < 40){
            y = 10 * 0.1 + 10 * 0.075 + (x - 20) * 0.05;
        }
        else if(x > 40 && x < 60){
            y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (x - 40) * 0.03;
        }
        else if(x > 60 && x < 100){
            y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + (x - 60) * 0.015;
        }
        else if(x > 100){
            y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + 40 * 0.015 + (x - 100) * 0.01;
        }
        System.out.println(y);
        scanner.close();


    }
}
