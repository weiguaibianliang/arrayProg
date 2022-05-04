package JAVA8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI {
    /**
     * 1、给定一个数字列表，如何返回一个由与每个数的平方构成的列表呢？
     * 给定【1,2,3，4,5】，应该返回【1,4,9,16,25】。
     */
    @Test
    public void test1(){
        Integer[] nums = new Integer[]{1,2,3,4,5};
        Arrays.stream(nums)
                .map((x)->x*x)
                .forEach(System.out::println);
    }
    /**
     * 2、怎样用map和reduce方法数一数流中有多少个Employee呢？
     */
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.55),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,3333.33),
            new Employee("田七",8,7777.77)

    );
    @Test
    public void test2(){
        Optional<Integer> count = employees.stream()
                .map((e)->1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }

}
