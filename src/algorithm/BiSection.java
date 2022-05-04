package algorithm;

import static java.lang.Math.cos;

public class BiSection {
    public static void main(String[] args) {
        double temp ;
//		System.out.print(temp+"\n");
        double x ;
        double a = 0;
        double b = 1;
        for (int i = 2; i < 11; i++) {
            x = (a + b) / ( 2.0);
            temp = x * x * x -cos(x);
            System.out.print(a + "|");
            System.out.print(x + "|");
            System.out.print(b + "\n");
            if (temp > 0) {
                b = x;
            } else
                a = x;

        }
    }
}


