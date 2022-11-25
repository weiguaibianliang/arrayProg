package BaseAlgorithm;

/**
 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 */
public class Test13 {
    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++){
            int a = (int)Math.sqrt(i + 100);
            int b = (int)Math.sqrt(i + 100 + 168);
            if(i *i == a && i * i == b){
                System.out.println("整数"+i+"它加上100后是一个完全平方数，再加上168又是一个完全平方数。");
            }
        }
    }
}
