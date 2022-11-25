package BaseAlgorithm;

/**
 * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数
 */
public class Test24 {
    public static void main(String[] args) {
        int a,b,c;
        int d = 0;
        for( a = 1; a <= 4; a++){
            for (b = 1; b <= 4; b++){
                for(c = 1; c <= 4; c++){
                    if(a != b && a != c && b != c){
                        System.out.println("三位数为：" + (a*100+b*10+c));
                        d++;
                    }
                }
            }
        }
        System.out.println("能组成互不相同且无重复数字的三位数的个数："+ d);
    }
}
