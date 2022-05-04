package JAVA8;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI2 {
    List<Transaction> transactions = null;

    @Before
    public void before(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
    //1、找出2011年发生的所有交易，并按交易额顺序（从低到高）
    @Test
    public void test1(){
        transactions.stream()
                .filter((t)->t.getYear()==2011)
                .sorted((t1,t2)->Integer.compare(t1.getValue(),t2.getValue()))
                .forEach(System.out::println);
    }
    //2、交易员都在哪些不同的城市工作过？
    @Test
    public void test2(){
        transactions.stream()
                .map((t)->t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }
    //3、查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3(){
        transactions.stream()
                .filter((t)->t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);
    }
    //返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4(){
        transactions.stream()
                .map((t)->t.getTrader().getName())
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------------------------------");
        String str = transactions.stream()
                .map((t)->t.getTrader().getName())
                .sorted()
                .reduce("",String::concat);
        System.out.println(str);
        System.out.println("------------------------------------");
        transactions.stream()
                .map((t)->t.getTrader().getName())
                .flatMap(TestStreamAPI2::filterCharacter)
                .sorted()
                .forEach(System.out::print);

    }
    public  static  Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch:str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
    //5、有没有交易员在米兰工作的?
    @Test
    public void test5(){
        boolean b1 = transactions.stream()
                .anyMatch((t)->t.getTrader().getCity().equals("Milan"));
        System.out.println(b1);
    }
}
