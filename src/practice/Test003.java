package practice;
/*
public class Test003 {
}
class Loopy{
    public static void main(String[] args) {
        int x = 1;
        System.out.println("Before the loop");
        while (x < 4){
            System.out.println("In the loop");
            System.out.println("Value of x is" + x);
            x = x+1;
        }
        System.out.println("This is after the loop");
    }
}

 */
class IfTest{
    public static void main(String[] args) {
        int x = 3;
        if(x==3){
            System.out.println("x must be 3");

        }else{
            System.out.println("x is not 3");
        }
        System.out.println("This runs no matter what");
    }
}
class DooBee{
    public static void main(String[] args) {
        int x = 1;
        while(x<2){
            System.out.println("Doo");
            System.out.println("Bee");
            x = x + 1;
        }
        if(x==2){
            System.out.println("Do");
        }
    }
}
