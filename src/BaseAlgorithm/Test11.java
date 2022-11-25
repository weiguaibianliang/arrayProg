package BaseAlgorithm;

public class Test11 {
    /**
     * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     */
    public static void main(String[] args) {
        //不用定义一个数组
        //Integer [] a = {1,2,3,4};
        int count = 0;
        for (int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                for(int k = 1; k < 5; k++){
                    if(i != j && i != k && j != k){
                        count++;
                        System.out.println(i+""+j+""+k);
                    }
                }
            }
        }

    }
}
