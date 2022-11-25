package JAVA8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestLambda4 {
    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(11,33,22,44);
        //匿名内部类写法
        asList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //Lambda表达式写法
        asList.forEach((s)->{
            System.out.println(s);
        });
        //Lambda表达式写法变形
        asList.forEach(s-> System.out.println(s));
        asList.forEach(s->{
            if(s>20){
                System.out.println(s);
            }
        });
    }
}

