package BaseAlgorithm;

/**
 * 判断101-200之间有多少个素数，并输出所有素数。
 */
public class Test2 {
    /**
     * 程序分析：
     * 素数是：只能被1或本身整除的数，如：3,5,7,11,131...
     * 判断素数的方法：用一个数分别去除2到sqrt这个数
     * 其实用这个数分别去除2到他本身少1的数也可以，但是运算时间增加了。
     * 如果能被整除，则表明此数不是素数，反之是素数。
     */
    public static void main(String[] args) {
        //s输出所有素数的个数，并把所有素数都打印出来。
        int sum = 0;
        for(int i = 100; i < 200; i++){
            //判断这个数是不是素数
            if(IsRightNum(i)){
                System.out.println(i+" ");
                sum++;
                if(sum%10 == 0){
                    System.out.println();
                }
            }
        }
        System.out.println("素数的整数：" +sum);
    }

    //判断这个数是不是素数的具体代码。
    private static boolean IsRightNum(int i) {
        for (int j = 2; j < Math.sqrt(i); j++){
            //如果能整除，就说明不是素数，可以马上中断，继续对下一个数判断。
            if(i%j == 0){
                return false;
            }
        }
        return true;
    }
}
