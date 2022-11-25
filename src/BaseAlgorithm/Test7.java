package BaseAlgorithm;

import java.util.Scanner;

/**
 * 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 */
public class Test7 {
    //这就要考虑把一行字符串转换为一个数组。
    public static void main(String[] args) {
        //输入一行字符串
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一行字符串");
        String s = scanner.nextLine();
        //把一行字符串转为一个数组
        char[] chars = s.toCharArray();
        //定义英文字母、空格、数字和其它字符的个数
        int  abcCount = 0;
        int spaceCount = 0;
        int numCount = 0;
        int otherCount = 0;

        for (int i = 0; i < chars.length; i++){
            if(Character.isLetter(chars[i])){
                abcCount++;
            }
            else if(Character.isSpaceChar(chars[i])){
                spaceCount++;
            }
            else if(Character.isDigit(chars[i])){
                numCount++;
            }
            else {
                otherCount++;
            }
        }
        System.out.println("英文字符的个数为："+abcCount);
        System.out.println("空格字符的个数为："+spaceCount);
        System.out.println("数字字符的个数为："+numCount);
        System.out.println("其它字符的个数为:"+ otherCount);
    }
}
