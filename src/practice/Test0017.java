package practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test0017 {
}
/*
第十七章：反射机制
 */
class Teat171 {
    /*
    测得获取class对象的三种方式
     */
    public static void main(String[] args) throws Exception {
        User user = new User("高琪");
        //方式一
        Class c1 =user.getClass();
        //方式二
        Class c2 = User.class;
        //方式三
        Class c3 = Class.forName("practice.User");
        System.out.println(c1==c2);
        System.out.println(c1==c3);
        //获取类的名字
        //获取"包名+类名":practice.User
        System.out.println(c1.getName());
        //直接获取类名:User
        System.out.println(c1.getSimpleName());

    }
}

class User{

    //创建User类，"class对象"常用方法的应用
      private int age;
      private String uname;
      public void printName(){
          System.out.println("我的名字是:"+uname);
      }
      public User(String uname){
          this.uname = uname;
      }
      public User(int age,String uname){
          super();
          this.age = age;
          this.uname = uname;
      }
      public User(){
      }
      public int getAge(){
          return age;
      }
      public void setAge(int age){
          this.age = age;
      }
      public String getUname(){
          return uname;
      }
      public void setUname(String uname){
          this.uname = uname;
      }

    }

class Test172{
    /*
    通过Constructor对象可操作构造器，从而构造出对象
     */
    public static void main(String[] args) {
        String path = "practice.User";
        try{
            Class clazz = Class.forName(path);
            //获得所有构造器,创建一个数组.
            Constructor[] cons = clazz.getDeclaredConstructors();
            /*
            Constructor[] cons = new Constructor[];

             */
            for (Constructor constructor: cons) {
                System.out.println(constructor);
            }
            System.out.println("###########");
            //获得无参构造器
            Constructor c1 = clazz.getDeclaredConstructor(null);
            System.out.println("无参构造器:"+c1);
            //获得带参构造器
            Constructor c2 = clazz.getDeclaredConstructor(int.class,String.class);
            System.out.println("带参int、String的构造器:"+c2);
            System.out.println("*****************");
            //调用构造器，构造对象
            User user1 = (User) clazz.newInstance();//调用无参构造器
            User user2 = (User) c1.newInstance(null);//调用无参构造器
            User user3 = (User) c2.newInstance(18,"高琪");//调用带参构造器传入参数
            user1.printName();
            user2.printName();
            user3.printName();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Test173{
    public static void main(String[] args) {
        String path = "practice.User";
        try{
            Class clazz = Class.forName(path);
            //获得所有属性
            Field[] fields = clazz.getDeclaredFields();
            for(Field f : fields){
                System.out.println("属性:"+f);
            }
            System.out.println("##########");
            //获取指定名字的属性
            Field f2 = clazz.getDeclaredField("uname");
            System.out.println("通过uname名字获得Field对象:"+f2);
            //通过反射给对象的属性赋值
            User user = (User) clazz.newInstance();
            //跳过安全检查，可以直接访问私有属性和方法
            f2.setAccessible(true);
            f2.set(user,"高小七");
            user.printName();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
