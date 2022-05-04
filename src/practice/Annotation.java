package practice;

//注解：对程序做解释，最后通过反射机制编程实现对这些元素数据的访问。



import java.lang.annotation.*;

//内置注解
/*
1、@Override 是重写方法
2、@Deprecated 通常是因为它很危险或者存在更好的选择（不推荐）。
3、@SuppressWarnings 用来抑制编译时的警告信息。


 */




//测试元注解
@MyAnnotation
public class Annotation {
    //元注解定义在方法上
    @MyAnnotation
    public void test(){

    }

}
//定义一个注解

//Target是描述注解的使用范围，到底是在类上使用还是方法等上使用。
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//Retention表示在运行的时候进行注解，什么时候有效,注意运行级别，RUNTIME>CLASS>SOURCE
@Retention(value = RetentionPolicy.RUNTIME)

//Documented表示是否将我们的注解生成在JAVAdoc中
@Documented
//子类可以继承父类的注解，一般在继承类的时候使用。

@Inherited
@interface MyAnnotation{

}


//测试自定义注解

class Annotation1{
    //注解可以显示赋值,如果没有默认值，我们就必须给注解赋值。
    @MyAnnotation4(name = "zhangSan",age =16)
    @MyAnnotation2(name = "liHua",age=18,id=212010108,schools = {"西部开源","杭电"})
    public void test(){}
    @MyAnnotation3("秦僵")
    public void test2(){}

}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名（）；
    String name() default "";
    int age();
    int id() default -1;//如果默认值为-1，代表不存在。
    String[] schools() default {"西部开源","杭电"};
}


//测试自定义注解，如果注解只有一个值


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    //注解只有一个值
    String value();
}

//测试自定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@interface MyAnnotation4{
    //注解的方式
    String name();
    int age();
}