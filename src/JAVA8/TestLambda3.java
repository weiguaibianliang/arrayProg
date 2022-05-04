package JAVA8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TestLambda3 {
    /**
     * 练习一:
     * 调用Collection.sort()方法，通过定制排序比较两个Employee（先按年龄比较，如果年龄相同则按姓名比较）
     * 使用Lambda作为参数传递
     */
    //
    List<Employee> emps = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.55),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,3333.33),
            new Employee("田七",8,7777.77)
    );
    @Test
    public void test1(){
        //利用定制排序的方法来进行操作
        Collections.sort(emps,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }
            else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee emp: emps) {
            System.out.println(emp);
        }
    }

    /**
     * (1)声明函数式接口，接口中声明抽象方法，public String getValue(String str)
     * (2)声明类TestLambda,类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值。
     * (3)再将一个字符串的第2个和第四个索引位置进行截取子串。
     */
    @Test
    public void test2(){
        //trim()方法不仅仅是去除字符串两端的空格字符，它能去除25种字符。
       String trimStr= strHandler("\t\t\t 杭州迈的智能科技有限公司",(str) -> str.trim());
        System.out.println(trimStr);
        String toUpper = strHandler("abcdef",(str)-> str.toUpperCase());
        System.out.println(toUpper);
    }
    //需求：用于处理字符串
    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }

    /**
     * (1) 声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值
     * (2) 接口中声明对应抽象方法
     * (3)在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和。
     * (4)再计算两个long型参数的乘积。
     */
    @Test
    public void test3(){
        op(100L,200L,(x,y) -> x+y);
        op(100L,200L,(x,y) -> x*y);
    }


    //需求：对于两个Long型数据就行处理
    public void op(Long l1,Long l2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }

}
