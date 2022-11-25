package BaseAlgorithm;

/**
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；
 * 再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 */
public class Test10 {
    public static void main(String[] args) {
        double h = 100;
        double s = 0;
        for (int i = 1; i <= 10; i++){
            s = s + 2 * h;
            h = h/2;
        }
        s = s - 100;
        System.out.println("经过的路程为：" + s);
        System.out.println("最后反弹的高度：" + h);
    }
}
