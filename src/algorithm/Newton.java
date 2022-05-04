package algorithm;

import static java.lang.Math.*;

public class Newton {
    public static void main(String[] args)
    {

        double x= 0.2;
        for (int i=1; i<10; i++){
            x=x-(0.5-sin(5*x)*exp(-x))/(sin(5*x)*exp(-x)-5*cos(5*x)*exp(-x));
            System.out.print(x+"\n");

        }
    }

}
