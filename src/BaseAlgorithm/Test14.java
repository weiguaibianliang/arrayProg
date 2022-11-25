package BaseAlgorithm;

import java.util.Scanner;

/**
 * 输入某年某月某日，判断这一天是这一年的第几天？
 * 需要对当前月份的具体日期做一个规范的判断。
 */
public class Test14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year,month,day;
        //作为判断平年还是闰年的变量，闰年比平年在2月份多一天。
        int lemp = 0;
        //作为日期是否符合规定的依据
        int flag = 1;
        //定义两个数组
        int[] array1 = new int[]{1,3,5,7,8,10,12};
        int[] array2 = new int[]{4,6,9,11};
        System.out.println("请输入年份：");
        year = scanner.nextInt();
        if((year%400 == 0)||(year%4 == 0 && year%100 != 0)){
            lemp = 1;
        }
        System.out.println("请输入月份：");
        month = scanner.nextInt();
        System.out.println("请输入日期：");
        day = scanner.nextInt();
        for (int i = 0; i < array1.length; i++){
            if(month == (array1[i]) && day > 31){
                System.out.println("日期不符合要求！");
                flag = 0;
            }
        }
        for (int i = 0; i < array2.length; i++){
            if(month == (array2[i]) && day > 30){
                System.out.println("日期不符合要求！");
                flag = 0;
            }
        }
        if(month == 2 && ((lemp==0 && day > 28)||(lemp==1 && day > 29))){
            System.out.println("日期不符合要求！");
            flag = 0;
        }
        if(flag==1){
            //为什么使用month-1,是因为比如你输入的是2012年4月3日，那你算的肯定是前三个月的天数加上三天。
            switch (month - 1){
                case 11:
                    day += 30;
                case 10:
                    day += 31;
                case 9:
                    day += 30;
                case 8:
                    day += 31;
                case 7:
                    day += 31;
                case 6:
                    day += 30;
                case 5:
                    day += 31;
                case 4:
                    day += 30;
                case 3:
                    day += 31;
                case 2:
                    day += 28 + lemp;
                case 1:
                    day += 31;
                default:
                    if(month >= 1 && month <= 12){
                        System.out.println("今天是"+ year + "年的第" + day + "天");
                    }else {
                        System.out.println("月份不合格！请检查！");
                    }
                    break;
            }
        }
    }
}
