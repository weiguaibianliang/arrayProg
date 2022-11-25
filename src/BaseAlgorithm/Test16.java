package BaseAlgorithm;

/**
 * 输出9*9口诀
 */
public class Test16 {
    public static void main(String[] args) {
        int a ;
        for (int i = 1; i <= 9; i++){
            for (int j = 1; j <= i; j++){
                a = i * j;
                System.out.print(i+"*"+j+"="+a+"\t");
            }
            System.out.println("");
        }
    }
}
