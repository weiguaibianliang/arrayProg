package BaseAlgorithm;

/**
 * 打印出所有的水仙花数，所谓水仙花数是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个“水仙花数”，因为153 = 1的三次方 + 5的三次方 + 3的三次方
 */
public class Test3 {
    //利用for循环100-999之间的数，求出这个数的十位、百位、千位。
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 100; i < 1000; i++){
            int a = i/100;
            int b = i%100/10;
            int c = i%100%10;
            if(a*a*a + b*b*b + c*c*c == i){
                System.out.println(i);
                sum++;

            }
        }
        System.out.println("水仙花数的个数："+ sum);
    }
}
