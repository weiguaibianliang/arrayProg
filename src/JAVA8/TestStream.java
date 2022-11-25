package JAVA8;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Stream和Lambda的练习题
public class TestStream {
    public static void main(String[] args) {
        /**
         * 题目条件
         */
        Trader1 raou1 = new Trader1("Raou1","Cambridge");
        Trader1 mario = new Trader1("Mario","Milan");
        Trader1 alan = new Trader1("Alan","Cambridge");
        Trader1 brian = new Trader1("Brain","Cambridge");
        List<Transaction1> transactions = Arrays.asList(
                new Transaction1(brian,2011,300),
                new Transaction1(raou1,2012,1000),
                new Transaction1(raou1,2011,400),
                new Transaction1(mario,2012,710),
                new Transaction1(mario,2012,700),
                new Transaction1(alan,2012,950)
        );
        int[] arr = {5,3,6,10,2,7};
        /**
         * 下面是十个题目描述
         */
        System.out.println("1.看到上面的arr数组了吗，控制台输出数组每个数字的平方");
        System.out.println("2、有没有交易员是在米兰工作的？（不用Lambda）");
        System.out.println("3、有没有交易员是在米兰工作的？");
        System.out.println("4、找出2011年所有交易，并按照交易额排序（低->高）");
        System.out.println("5、交易员都在哪些不同城市工作过？");
        System.out.println("6、查找出来自剑桥的交易员，并按姓名排序？");
        System.out.println("7、打印生活在剑桥的交易员的所有交易额");
        System.out.println("8、返回所有交易员姓名的字符串，并按字母顺序排序打印");
        System.out.println("9、所有交易中，最高的交易额是多少");
        System.out.println("10、找到交易额最小的交易");
        System.out.println("===============================================");

        System.out.println("1.看到上面的arr数组了吗，控制台输出数组每个数字的平方");
        Arrays.stream(arr).map(e -> e*e).forEach(System.out::println);

        System.out.println("2、有没有交易员是在米兰工作的,去重后控制台打印？（不用Lambda）");
        List<Trader1> milan2 = transactions.stream()
                .map(t -> t.trader1)
                .filter(new Predicate<Trader1>() {
                    @Override
                    public boolean test(Trader1 t) {
                        return "Milan".equals(t.getCity());
                    }
                })
                .distinct()
                .collect(Collectors.toList());
        //在控制台进行打印
        milan2.stream().forEach(System.out::println);

        System.out.println("3、有没有交易员是在米兰工作的？用Lambda表达式表示");
        transactions.stream()
                .filter(t -> t.trader1.getCity().equals("Milan"))
                .map(t -> t.trader1)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("4、找出2011年所有交易，并按照交易额排序（低->高）");
        List<Transaction1> list = transactions.stream()
                .filter(t -> t.year == 2011)
                .sorted(Comparator.comparing(Transaction1::getValue))
                .collect(Collectors.toList());

        list.stream().forEach(System.out::println);

        System.out.println("5、交易员都在哪些不同城市工作过？");
        List<String> distinctList = transactions.stream()
                .map(e -> e.trader1.getCity())
                .distinct()
                .collect(Collectors.toList());
        distinctList.stream().forEach(System.out::println);

        System.out.println("6、查找出来自剑桥的交易员，并按姓名排序？");
        List<Trader1> list1 = transactions.stream()
                .filter(t -> t.trader1.getCity().equals("Cambridge"))
                .map(t -> t.trader1)
                .distinct()
                .sorted(Comparator.comparing(Trader1::getName))
                .collect(Collectors.toList());
        list1.stream().forEach(System.out::println);

        System.out.println("7、打印生活在剑桥的交易员的所有交易额");
        List<Integer> list2 = transactions.stream()
                .filter(t -> t.trader1.getCity().equals("Cambridge"))
                .map(t -> t.value)
                .collect(Collectors.toList());
        list2.stream().forEach(System.out::println);

        System.out.println("8、返回所有交易员姓名的字符串，并按字母顺序排序打印");
        List<String> list3 = transactions.stream()
                .map(t -> t.trader1.getName())
                .distinct()
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());
        list3.stream().forEach(System.out::println);

        System.out.println("9、所有交易中，最高的交易额是多少");
        Integer maxValue = transactions.stream()
                .map(t -> t.value)
                .max(Integer::compareTo)
                .get();
        System.out.println("最高的交易额"+ maxValue);


        System.out.println("10、所有交易中，最低的交易额是多少？");
        /*
        Integer minValue = transactions.stream()
                .map(t -> t.value)
                .min(Integer::compareTo)
                .get();
        System.out.println("最低的交易额"+ minValue);

         */
        //Optional是一个容器，存放对象的。
        Optional<Integer> max = transactions.stream()
                .map(Transaction1::getValue)
                .max(Comparator.comparing(Integer::intValue));
        System.out.println("最高的交易额"+max);

        System.out.println("11、找出交易额最低的贸易");
        Optional<Trader1> trader1 = transactions.stream()
                .min(Comparator.comparing(t -> t.value))
                .map(t -> t.trader1);
        System.out.println(trader1.toString());
    }
    public static class Transaction1 {
        private final Trader1 trader1;
        private final int year;
        private final int value;



        public Transaction1(Trader1 trader1, int year, int value) {
            this.trader1 = trader1;
            this.year = year;
            this.value = value;
        }

        public Trader1 getTrader1() {
            return trader1;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Transaction1{" +
                    "trader1=" + trader1 +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }
}
