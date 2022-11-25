package BaseAlgorithm;

import java.util.Scanner;

/**
 * 输入三个整数x，y，z,请把这三个数由小到大输出。
 */
public class Test15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入整数x");
        int x = scanner.nextInt();
        System.out.println("输入整数y");
        int y = scanner.nextInt();
        System.out.println("输入整数z");
        int z = scanner.nextInt();
        int temp;
        if(x > y){
            temp = x;
            x = y;
            y = temp;
        }
        if(x > z){
            temp = x;
            x = z;
            z = temp;
        }
        if(y > z){
            temp = y;
            y = z;
            z = temp;
        }
        System.out.println(x+""+y+""+z);
    }
}
