package EasyAlgorithm;

import JAVA8.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test5 {
}
//Stream、Lambda练习
//获取Stream流的四种方式
class StreamApiTest{
    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.99),
            new Employee(102,"李四",59,6666.66),
            new Employee(103,"王五",28,3333.33),
            new Employee(104,"赵六",8,7777.77),
            new Employee(105,"田七",38,5555.55),
            new Employee(105,"田七",38,5555.55)

    );
    @Test
    public void test01(){
        //1、通过Collection获取Stream
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //2、通过Arrays.stream()获取数组流
        Stream<Integer> stream1 = Arrays.stream(new Integer[5]);
        //3.通过Stream.of获取流
        Stream<String> stream2 = Stream.of("abc","def");
        //创建无限流
        Stream<Integer> stream3 = Stream.iterate(1,(x)-> x+1);
        stream3.limit(10)
                .forEach(System.out::println);
    }
    @Test
    public void test02(){
        emps.stream()
                .distinct()
                .filter((x) -> x.getSalary() < 5556.0)
                .forEach(System.out::println);
    }
    @Test
    public void test03(){
        emps.stream()
                .map(Employee::getName)
                .distinct()
                .forEach(System.out::println);
    }
    @Test
    public void test04(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        //map接收Lambda，将元素转换成其他形式提取信息，接收一个函数作为参数
        //该函数会被应用到每个元素上，并将其映射成一个新的元素。
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
        System.out.println("------------------");
        emps.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("------------------");
        //扁平化flatMap将多个流整合成一个流，类似于list中的add和addAll
        Stream<Stream<Character>> streamStream = list.stream().map(this::filterCharacter);
        Stream<Character> characterStream = list.stream().flatMap(this::filterCharacter);
        characterStream.forEach(System.out::println);
    }

    private Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c: str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
    @Test//排序
    public void test5(){
        emps.stream()
                .sorted((o1,o2) -> Integer.compare(o1.getAge(),o2.getAge()))
                .forEach(System.out::println);
    }
}