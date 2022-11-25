package BaseAlgorithm;

import java.util.Locale;
import java.util.Scanner;

/**
 * 请输入星期几的第一个字母来判断一下是星期几，
 * 如果第一个字母一样，则继续判断第二个字母。
 */
public class Test22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入星期的首字母（不区分大小写）：");
        String str1 = scanner.nextLine().toUpperCase();
        switch (str1){
            case "M":
                System.out.println("Monday");
                break;
            case "T":
                System.out.println("请输入星期的次字母（不区分大小写）");
                String str2 = scanner.nextLine().toUpperCase();
                if(str2.equals("U")){
                    System.out.println("Tuesday");
                }else if(str2.equals("H")){
                    System.out.println("Thursday");
                }
                break;
            case "W":
                System.out.println("Wednesday");
                break;
            case "F":
                System.out.println("Friday");
                break;
            case "S":
                System.out.println("请输入星期的次字母（不区分大小写）：");
                String str3 = scanner.nextLine().toUpperCase();
                if(str3.equals("A")){
                    System.out.println("Saturday");
                }else {
                    System.out.println("Wrong");
                }
                break;
            default:
                System.out.println("Wrong");
        }
        /*
        System.out.println("请输入星期几的英文单词");
        String str = scanner.nextLine();
        //字符串转为字符
        //其实这里也算不上转换了，只是获取对应位置上的字符。
        char ch = str.charAt(0);
        /*
        switch (ch){
            case M:
                System.out.println("星期一");
            case T:
                System.out.println("星期二");
            case W:
                System.out.println("星期三");
            case T:
                System.out.println("星期四");
            case F:
                System.out.println("星期五");
            case S:
                System.out.println("星期六");
            case S:
                System.out.println("星期天");


        if (ch == 'M') {
            System.out.println("星期一");
        }
        if (ch == 'T') {
            if (str.charAt(1) == 'u') {
                System.out.println("星期二");
            } else
                System.out.println("星期四");
        }
        if (ch == 'W') {
            System.out.println("星期三");
        }
        if (ch == 'F') {
            System.out.println("星期五");
        }
        if (ch == 'S') {
            if (str.charAt(1) == 'a') {
                System.out.println("星期六");
            } else
                System.out.println("星期天");
        }

    }

         */
    }


}
