package practice;

import java.util.ArrayList;

public class Test0006 {
}
//要弄清自增和赋值谁先谁后，++z是先自增再赋值，z++是先赋值再自增
class Output {
    public static void main(String[] args) {
        Output o = new Output();
        o.go();
    }

    void go() {
        int y = 7;
        for (int x = 1; x < 8; x++) {
            y++;
            if (x > 4) {
                System.out.println(++y + "");
            }
            if (y > 14) {
                System.out.println("x= " + x);
                break;
            }
        }

    }
}
//将顺序乱的代码进行重新排列,考查的是循环与自增的关系，自增的时候，for循环的条件发生了改变。
class MultiFor{
    public static void main(String[] args) {
        for(int x = 0;x<4;x++){
            for(int y = 4;y>2;y--){
                System.out.println(x+" "+y);
            }
            if (x ==1){
                x++;
            }
        }
    }
}
class ArrayListMagnet{
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(0,"zero");
        a.add(1,"one");
        a.add(2,"two");
        a.add(3,"three");
        printAl(a);
            if(a.contains("three")){
                a.add("four");
            }
            a.remove(2);
            printAl(a);
            if(a.indexOf("four")!=4){
                a.add(4,"4.2");
            }
            printAl(a);
        if(a.contains("two")){
            a.add("2.2");
        }
            printAl(a);
    }
    public static void printAl(ArrayList<String> al){
       //ArrayList<String> al = new ArrayList<String>();
        for (String element: al) {
            System.out.print(element+" ");
        }
        System.out.println(" ");
        }
    }