package practice;

public class PracticeDebug {
}
class DebugDemo{
    public static void main(String[] args) {
        //定义两个变量
        int i = 10;
        int j = 20;
        //求和
        int sum = i+j;
        //输出结果
        System.out.println("sum:"+sum);
    }
}
class DebugTest01{
    public static void main(String[] args) {
        //定义求和变量
        int sum = 0;
        //循环求偶数和
        for(int i =1;i<=10;i++){
            if(i%2==0){
                sum+=i;
            }
        }
        //输出结果
        System.out.println("1-10之间的偶数和是:"+sum);
    }
}
