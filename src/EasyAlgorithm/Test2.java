package EasyAlgorithm;

import java.util.Scanner;

public class Test2 {
}
    /**
     * 题目：输入三个整数x、y、z,请把这三个数由小到大输出
     * 逻辑：办法把最小的数放到x上，先将x与y进行比较，如果x>y则将x与y的值进行交换，然后再用x与z进行比较，如果x>z则将x与z的值进行交换，这样能使x最小。
     */
class SmallToBig{
        public static void main(String[] args) {
            SmallToBig fnc = new SmallToBig();
            int a,b,c;
            System.out.println("Input 3 numbers:");
            a = fnc.input();
            b = fnc.input();
            c = fnc.input();
            /*
            //想办法把最小的数放到a上
            if (a > b){
                int t = a;
                a = b;
                b = t;
            }
            if(a > c){
                int t = a;
                a = c;
                c = t;
            }
            if(b > c){
                int t = b;
                b = c;
                c = t;
            }

             */
            SmallToBig fnc1 = new SmallToBig();
            fnc1.compare(a,b);
            fnc1.compare(a,c);
            fnc1.compare(b,c);
            System.out.println(a+" "+ b +" "+ c);

        }
        public int input(){
            int value = 0;
            Scanner s = new Scanner(System.in);
            value = s.nextInt();
            return value;
        }

        public void compare(int x, int y) {
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }
        }
    }
