package BaseAlgorithm;

/**
 * 构造方法的重载
 */
//测试类
public class Test25 {
    public static void main(String[] args) {
        //创建对象
        Person person1 = new Person();
        Person person2 = new Person("虚竹哥","男",11);
        System.out.println("员工1的信息");
        //输出姓名
        System.out.println("员工姓名："+ person1.getName());
        //输出性别
        System.out.println("员工性别："+ person1.getGender());
        //输出年龄
        System.out.println("员工年龄："+ person1.getAge());
        System.out.println("员工2的信息");
        //输出姓名
        System.out.println("员工姓名："+ person2.getName());
        //输出性别
        System.out.println("员工性别："+ person2.getGender());
        //输出年龄
        System.out.println("员工年龄："+ person2.getAge());
    }
}
//Person对象
class Person{
    //定义姓名
    private String name;
    //定义性别
    private String gender;
    //定义年龄
    private int age;
    //定义没有参数的构造方法
    public Person(){
        System.out.println("使用无参构造方法创建对象");
    }
    //利用构造方法初始化域
    public Person(String name,String gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
        System.out.println("使用有参构造方法创建对象");
    }
    //获得姓名
    public String getName(){
        return name;
    }
    //获得性别
    public String getGender(){
        return gender;
    }
    //获得年龄
    public int getAge(){
        return age;
    }
}

