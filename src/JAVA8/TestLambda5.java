package JAVA8;

import org.junit.Test;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLambda5 {


    /**
     * 一个Arraylist集合中存储有以下数据：张无忌，周芷若，赵敏，张强，张三丰，需求：
     * 1、拿到所有姓张的
     * 2、拿到名字长度为3个字的
     * 3、打印这些数据
     */
    @Test
    public  void test01(){
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"张无忌","周芷若","赵敏","张强","张三丰");

        //1、拿到所有姓张的
        ArrayList<String> zhangList = new ArrayList<>();
        for (String name: zhangList) {
            if(name.startsWith("张")){
                zhangList.add(name);
            }

        }
        //拿到名字长度为3个字的
        ArrayList<String> threeList = new ArrayList<>();
        for (String name:threeList) {
            if(name.length()==3){
                threeList.add(name);
            }
        }
        //打印这些数据
        for (String name: threeList) {
            System.out.println(name);
        }
    }

    //用循环遍历比较麻烦，可以用Stream的更优写法
    @Test
    public void test02(){
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"张无忌","周芷若","赵敏","张强","张三丰");
        //limit对流进行截取，只取前n个
        arrayList.stream().limit(3).forEach(System.out::println);
        //skip跳过前几个数据，得到一个新的流
        arrayList.stream().skip(3).forEach(System.out::println);
        arrayList.stream()
                .filter(s->s.startsWith("张"))
                .filter(s->s.length()==3)
                .forEach(System.out::println);

        System.out.println(arrayList.stream().count());
    }

    @Test
    public void test03(){
        //如果需要将流中的元素映射到另一个流中，可以使用map方法
        //该接口需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
        Stream<String> stringStream = Stream.of("11","22","33");
        Stream<Integer> integerStream = stringStream.map(Integer::parseInt);
        integerStream.forEach(s-> System.out.println(s+10));

        /*
        //Integer占用的内存比int多，在stream流操作中会自动装箱和拆箱
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5});
        InputStream intStream = stream.mapToInt(Integer::intValue);

         */

    }
    @Test
    public void test04(){
        Stream<String> stringStream = Stream.of("b","a","c");
        //根据元素的自然顺序排序
        stringStream.sorted().forEach(System.out::println);
        Stream.of(33,45,23,10).sorted().forEach(System.out::println);
        //根据比较器指定的规则排序,进行比较时，大的在前面，小的在后面。
        Stream.of(33,45,23,10).sorted((s1,s2)->s2-s1).forEach(System.out::println);
    }

    @Test
    public void test05(){
        //如果需要去除重复数据，可以使用distinct方法。
        //自定义类型是根据对象的hashcode和equals来去除重复元素的。
        Stream<String> stringStream = Stream.of("b","a","c","c","b");
        stringStream.distinct().forEach(System.out::println);
    }

    @Test
    public void test06(){
        //如果需要判断数据是否匹配指定的条件，可以使用Match相关方法
        Stream<Integer> integerStream = Stream.of(11,44,33);

        //allMatch:元素是否全部满足条件
        boolean b = integerStream.allMatch(integer -> integer > 0);
        System.out.println(b);

        //anyMatch:元素是否任意有一个满足条件
        boolean b1 = integerStream.anyMatch(integer -> integer>0);
        System.out.println(b1);

        //noneMatch:元素是否全部不满足条件
        boolean b2 = integerStream.noneMatch(integer -> integer > 0);
            System.out.println(b2);
    }

    @Test
    public void test07(){
        //如果需要找到某些数据，可以使用find相关方法
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"张无忌","周芷若","赵敏","张强","张三丰");

        //findFirst获取第一个数据
        Optional<String> first = arrayList.stream().findFirst();
        System.out.println(first.get());
        System.out.println(arrayList.stream().findAny().get());
    }

    @Test
    public void test08(){
        //如果需要将所有数据归纳得到一个数据，可以使用reduce方法。
        Stream<Integer> integerSystem = Stream.of(4,5,3,9);
        //第一次将默认做赋值给x，取出第一个元素赋值给y，进行操作
        //第二次，将第一次的结果赋值给x，取出两个元素赋值给y，进行操作
        //第三次，将第二次的结果赋值给x，取出三个元素赋值给y，进行操作
        //第四次，将第三次的结果赋值给x，取出四个元素赋值给y，进行操作

        //求和1
        Integer reduce = integerSystem.reduce(0,(x,y)->x+y);
        System.out.println(reduce);

        //求和2
        Stream<Integer> integerStream1 = Stream.of(4,5,3,9);
        System.out.println(integerStream1.reduce(0,Integer::sum));

        //取最大值
        Stream<Integer> integerStream2 = Stream.of(4,5,3,9);
        System.out.println(integerStream2.reduce(0,(x,y)-> x>y ? x : y));


    }
    /*
    @Test
    public void test09(){
        //求出所有年龄的总和
        int totalAge = Stream.of(
                new Person("刘德华",58),
                new Person("张学友",56),
                new Person("郭富城",54),
                new Person("黎明",52))
                .map((p)->p.getAge())
                .reduce(0,(x,y)-> x+y);
        System.out.println("totalAge="+totalAge);
    }

     */

    @Test
    public void test09(){
        //如果有两个流，希望合并成一个流，可以使用静态方法concat
        Stream<String> stringStream1 = Stream.of("a");
        Stream<String> stringStream2 = Stream.of("b");
        Stream<String> concat = Stream.concat(stringStream1,stringStream2);
        concat.forEach(System.out::println);
    }

    @Test
    public void test10(){
        //综合训练
        /**
         * 现有两个ArrayList集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强循环）依次以下若干操作步骤
         * 1、第一支队伍只要名字为3个字的成员姓名。
         * 2、第一个队伍筛选之后只要前3个人。
         * 3、第二个队伍只要姓张的成员姓名
         *4、第二个队伍筛选之后不要前两个人。
         * 5、将两个队伍合并为一个队伍。
         * 6、根据姓名创建Person对象
         * 7、打印整个队伍的Person对象信息。
         */

        ArrayList<String> one = new ArrayList<>();
        Collections.addAll(one,"迪丽热巴","宋元桥","苏星河","老子","庄子","孙子","洪七公");

        ArrayList<String> two = new ArrayList<>();
        Collections.addAll(two,"古力娜扎","张无忌","张三丰","赵丽颖","张二狗","张天爱","张三");
        //1和2
        Stream<String>  oneStream = one.stream()
                .filter(s -> s.length()==3)
                .limit(3);
        //3和4
        Stream<String> twoStream = two.stream()
                .filter(s -> s.startsWith("张"))
                .skip(2);
        //5和6和7
        /*
        Stream.concat(oneStream,twoStream)
                .map(Person::new )
                .forEach(System.out::println);

         */
    }

    //流中的终止操作
    //保存Stream流中的结果
    //对流操作完成之后，如果需要将流的结果保存到数组或集合中，可以收集流中的数据。

    @Test
    public void test11(){
        //collect将流中的数据收集到list集合中
        List<Integer> list = Stream.of(4,5,3,9).collect(Collectors.toList());
        System.out.println("list="+list);

        //将流中的数据收集到set集合中
        Set<Integer> set = Stream.of(4,5,3,9).collect(Collectors.toSet());
        System.out.println("set"+set);

        //将流中的数据收集到指定（ArrayList）集合中
        ArrayList<Object> arrayList = Stream.of(4,5,3,9).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("arrayList"+arrayList);

        //将流中的数据收集到指定（HashSet）集合中（自动去重）
        HashSet<Object> hashSet = Stream.of(4,5,3,9).collect(Collectors.toCollection(HashSet::new));
        System.out.println("hashSet="+hashSet);

        //toArray将流转为Object数组
        Object[] toArray = Stream.of(4,5,3,9).toArray();
        for(Object o:toArray){
            System.out.println("o="+o);
        }

        //toArray将流转为指定类型数组
        Integer[] integers = Stream.of(4,5,3,9).toArray(Integer[]::new);
        System.out.println("integers="+integers);
    }

    @Test
    public void testDistinct(){
        //求出所有年龄的总和
        Stream<Person> personStream = Stream.of(
                new Person("刘德华",58),
                new Person("张学友",56),
                new Person("郭富城",54),
                new Person("黎明",52));
        //最大值
        Optional<Person> personMax = personStream.max((p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println("personMax.get()"+personMax.get());
    }

    //对流中数据进行分组
    //对流中数据进行多级分组

}
