package practice;
/*
异常处理这一章会遇见的代码
 */
public class Test0011 {
}
/*
会出现两种情况
1、如果try语句没有出现异常，则try语句执行完后，直接跳到finally语句块执行。
2、如果try语句出现异常，则中断执行跳至相应的catch语句块执行处理。
 */
class ScaryException extends Exception{};
class TestException{
    public static void main(String[] args) {
        String test = "yes";
        try{
            System.out.println("start try");
            doRisky(test);
            System.out.println("end try");
        }catch (ScaryException se){
            System.out.println("scary exception");
        }finally {
            System.out.println("finally");
        }
        System.out.println("end of main");
    }
    static void doRisky(String test) throws ScaryException{
        System.out.println("start risky");
        if("yes".equals(test)){
            throw new ScaryException();
        }
        System.out.println("end risky");
        return;
    }
}
class MyEx extends Exception{};
class ExTestDrive{
    public static void main(String[] args) {
        //在这个地方提示数组下标越界异常，不知道该怎么处理？
        String test = args[0];
        try{
            System.out.print("t");
            doRisky(test);
            System.out.print("o");
        }catch (MyEx e){
            System.out.print("a");
        }
        finally {
            System.out.print("w");
        }
        System.out.print("s");
    }
    static void doRisky(String t) throws MyEx{
        System.out.print("h");
        if("yes".equals(t)){
            throw new MyEx();
        }
        System.out.print("r");
    }
}
