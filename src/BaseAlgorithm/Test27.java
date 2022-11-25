package BaseAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JAVA高级技术-对象克隆1（假克隆）
 */
public class Test27 {
    public static void main(String[] args) {
        System.out.println("克隆之前：");
        //创建Employee对象employee1
        Employee employee1 = new Employee();
        //为employee1设置年龄
        employee1.setAge(30);
        //为employee1设置姓名
        employee1.setName("小虚竹");
        System.out.println("员工1的信息：");
        //输出employee1的信息
        System.out.println(employee1);
        System.out.println("克隆之后");
        //将employee1赋值给employee2
        Employee employee2 = employee1;
        //newUsers是当前选中的人员
        List<String> newUsers = Arrays.asList("张三","王五");
        //oldUsers是存在数据库中的老数据
        List<String> oldUsers = Arrays.asList("张三","李四");
        //计算新增人员
        List<String> addUsers = new ArrayList<>(newUsers);
        addUsers.removeAll(oldUsers);
        //计算删除人员
        List<String> removeUsers = new ArrayList<>(oldUsers);
        removeUsers.removeAll(newUsers);
        //王五老的数据库没有，所以是新增的。
        System.out.println(addUsers);
        //李四没被选中，应该被删除
        System.out.println(removeUsers);

    }
}
class Employee{
    //表示员工的名字
    private String name;
    //表示员工的年龄
    private int age;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    @Override
    //重写toString（）方法
    public String toString(){
        return "姓名：" + name + ", 年龄：" + age;
    }

}

