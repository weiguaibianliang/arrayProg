package EasyAlgorithm;


import java.util.*;

public class Test3 {
}

class Example{
    //输入一行字符，分别统计出其中的英文字母、空格、数字和其它字符的个数
    public static void main(String[] args) {
        //英文字符的个数
        int abcCount = 0;
        //空格字符的个数
        int spaceCount = 0;
        //数字字符的个数
        int numCount = 0;
        //其它字符的个数
        int otherCount = 0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("请输入一串任意的字符串："+str);
        char[] a = str.toCharArray();
        for (char achar:a) {
            if((achar >= 'a'&& achar <= 'z')||(achar >= 'A'&& achar <= 'Z')){
                abcCount++;
            }

           else if(achar >= '0'&& achar <= '9'){
                numCount++;
            }
            else if(achar==' '){
                spaceCount++;
            }
            else {
                otherCount++;
            }

        }
        System.out.println("英文字母的个数：" + abcCount);
        System.out.println("数字字符的个数：" + numCount);
        System.out.println("空格字符的个数：" + spaceCount);
        System.out.println("其它字符的个数：" + otherCount);

    }
}
class ExtraSalary{
    public static void main(String[] args) {
        //企业发放的奖金根据利润提成
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入当月利润：");
        double l = scanner.nextDouble();
        System.out.println("输入当月利润为l："+ l);
        //先给奖金一个初始值。
        double bonus = 0 ;
        /*
        switch (l){
            case
        }

         */
        if(l <= 100000){
            bonus = l * 0.1;
            System.out.println(bonus);
        }
        else if(l > 100000 && l <= 200000){
            bonus = (l - 100000)*0.075 + 100000 * 0.1;
            System.out.println(bonus);
        }
    }
}

class Monkey{
    public static void main(String[] args) {
        int peach = 0;
        int remainPeach = 1;
        for(int i = 9; i > 0; i--){
            peach = (remainPeach + 1) * 2;
            remainPeach = peach;
            System.out.println(peach);
        }

    }
}

/**
 * 两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。
 * 以抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，c说他不和x，z比，
 * 请编程找出三队赛手的名单。
 */
class Competition{
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int x = 0;
        int y = 0;
        int z = 0;
        for(int i = 1;i <= 3; i++){
            if(i != 1 && i != 3){
                x = i;
            }
        }
        for(int i = 1; i <= 3; i++){
            if(i != 3 && i != x){
                z = i;
            }
        }
        for(int i = 1; i <= 3; i++){
            if(i != x && i != z){
                y = i;
            }
        }
        System.out.println("甲队的出场顺序：");
        System.out.println("甲队a出场顺位："+ a);
        System.out.println("甲队b出场顺位："+ b);
        System.out.println("甲队c出场顺位："+ c);
        System.out.println("乙队的出场顺序：");
        System.out.println("乙队x的出场顺序："+ x);
        System.out.println("乙队y的出场顺序："+ y);
        System.out.println("乙队z的出场顺序："+ z);

    }
}
class SumNumber{
    public static void main(String[] args) {
        //若干组相同数字（但数字的个数不同）的值进行相加，求相加最后的值的和。
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入原始的数字：");
        int a = scanner.nextInt();
        System.out.println("请输入要相加的个数：");
        int b = scanner.nextInt();
        int z = 0;
        int h = 0;
        for(int i = 0; i <= b; i++){
            int f = (int)Math.pow(10,i);
            int m = a * f;
            z+=m;
            h+=z;
            System.out.println(h);
        }
    }
}

class PhoneReturn{
    //某公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每位数字都加上5，然后用和除以10的余数代替该数字，
    //再将第一位和第四位交换，第二位和第三位交换。
    public static void main(String[] args) {
        //int temp;
        //int temp1;
        for(int i = 1000; i < 10000;i++){
            int a = i/1000;
            int b = i%1000/100;
            int c = i%100/10;
            int d = i%10;
            int e = (a + 5)%10;
            int f = (b + 5)%10;
            int g = (c + 5)%10;
            int h = (d + 5)%10;
            /*
            temp = e;
            h = temp;
            e = h;

            temp1 = f;
            g = temp1;
            f = g;

             */
            if((a==h)&&(b==g)&&(c==f)&&(d==e)){
                System.out.println(i);
            }
        }
    }
}

class ReturnPhone{
    public static void main(String[] args) {
        System.out.println("公用电话传递数据为四位数");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入四位数");
        int num = scanner.nextInt();
        //把四位数每个数字拆分成一个数组
        int array []  = new int[4];
        if(num < 10000){
            for(int i = 0; i < array.length;i++){
                //倒序加密赋值，按正确的顺序应该是7 5 6 5，倒序就是取余，顺序就是取商。
                array[i] = (num % 10 + 5) % 10;
                num = num/10;
            }
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i]);
            }
        }
        else {
            System.out.println("输入的数字是错误的！");
        }


    }
}

//练习1 int数组去重排序
/**
 * 定义一个长度为10的Int数组,并存入10个int类型的数据，其中有一些数据是重复的
 * 利用集合的知识对数组进行去重，产生新数组，不改变顺序
 * 打印新数组中的内容
 */

/**
 * Collection接口：List(接口，可重复，存储顺序一致)、Set(接口，唯一，存储顺序不一致)
 * List接口-ArrayList(实现类，数据结构为数组)、LinkedList(实现类，数据结构为链表)
 * Set接口-HashSet(实现类)
 */

class Practice_array{
    public static void main(String[] args) {
        //先定义一个数组
        /*
        int [] array = new int[8];
        array[0] = 11;
        array[1] = 12;
        array[2] = 11;
        array[3] = 9;
        array[4] = 8;
        array[5] = 19;
        array[6] = 16;
        array[7] = 11;
         */
        int [] array = {11,12,11,9,8,19,16,11};
        //再定义一个集合，来存储去重后的数组
        ArrayList<Integer> arrayList = new ArrayList<>();
        //进行去重逻辑，把数添加到集合中
        for (int i: array) {
            if(!arrayList.contains(i)){
                arrayList.add(i);
            }
        }
        //再把去重后的数字添加到集合后定义一个新的数组。
        int [] array1 = new int[arrayList.size()];
        //再把集合中的数添加到数组中
        for(int i = 0; i < array1.length; i++){
            array1[i] = arrayList.get(i);

        }
        //对数组进行排序
        Arrays.sort(array1);
        //使用字符串输出表示，表达形式更加直观。
        System.out.println(Arrays.toString(array1));


    }
}

//练习2字符串去重
/**
 * 需求：键盘读取一行输入，去掉其中重复字符，打印出不同的那些字符
 * 因为仅需要去重，不要求顺序，所以使用HashSet即可自动去重。
 */
class StringReview{
    public static void main(String[] args) {
        System.out.println("随便输入一串带有重复的字符串");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String s = scanner.nextLine();
        //把输入的字符串存放到一个数组中
        char[] aChar = s.toCharArray();
        //定义一个set集合存放你输入的数组
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < aChar.length; i++){
            set.add(aChar[i]);
        }
        //set直接有去重的功能。
        System.out.println(set);
        /*
        //再把集合中的字符放在一个集合中
        char[] bChar = new char[set.size()];
        for(int i = 0; i < bChar.length; i++){
            bChar[i] = set.add()
        }

         */
    }
}

//练习3 生成不重复随机数字
/**
 * 需求：产生10个1-20之间的随机数要求随机数不能重复
 * 不能重复的数，则放入HashSet集合即可
 */
class NotReview{
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        //输入随机数
        Random r = new Random();
        //小于10个数字，则一直插入set集合
        while (set.size() < 10){
            set.add(r.nextInt(20) + 1);
        }
        System.out.println("set的大小为："+set.size());
        System.out.println(set);
    }
}

//练习5 统计字符出现次数
/**
 * 需求：
 * 1、利用键盘录入，输入一个字符串
 * 2、统计该字符串中各个字符的数量（提示：字符不用排序）
 * 3、如：字符——次数
 *
 * 思路：
 * 1、创建map集合，键为Character，值为Integer
 * 2、键盘录入字符串 str
 * 3、将字符串转换为字符数组，并遍历这个字符数组，获取每个字符
 * 4、在循环中判断集合中map集合中的键是否包含这个字符，如果map集合中的键不包含这个字符，那么就让map执行put方法，键就是遍历到的字符，值为1
 * 5、如果map集合中包含这个键，就让map集合的值 + 1存储
 * 6、循环完毕后，遍历map集合进行打印，打印过程中按照指定格式来进行。

 **/
class CodeQty{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //创建map集合，键为Character，值为Integer
        HashMap<Character,Integer> map = new HashMap<>();
        System.out.println("请输入一行字符串");
        String str = scanner.nextLine();
        //把字符串转为字符数组
        char [] chars = str.toCharArray();
        //思路345
        for (char aChar: chars) {
            //如果map集合中包含这个键，那么就让map集合的值+1存储；如果map集合中的键不包含这个键，直接定义map集合中的值为1
            map.put(aChar,map.containsKey(aChar) ? map.get(aChar) + 1: 1);
        }
        //循环完毕后，遍历map集合进行打印，打印过程中按照指定格式来进行
        //还要用set去重,然后计算每个集合元素的个数
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        //遍历map集合进行打印
        for (Map.Entry<Character,Integer> me : set) {
            //打印过程中按照指定格式来进行
            //返回所有的key值
            System.out.print(me.getKey());
            //返回所有value值
            System.out.println(me.getValue());
        }
    }
}

//练习6 分割字符串并计数
/**
 * 需求：
 * 1、统计每个单词出现的次数
 * 2、控制台输入字符串，每个单词之间用空格间隔
 * 3、打印结果
 */
/**
 * 思路：
 * 1、分割字符串=> String.split
 * 2、分割后的字符串放到String[] 数组
 * 3、将字符串，数量放入Map中（k,v）k= 字符串 v=字符串出现次数
 * 4、遍历String[]放入map，每次放入前判断是否存在该字符串
 * 存在则出现次数记为现有值+1
 * 不存在则出现次数记为1
 * 5、遍历map并打印结果
 */

class StringSplit{
    public static void main(String[] args) {
        System.out.println("输入一行字符串");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //分割字符串，将分割后的字符串放到字符串数组中。
        String[] str1 = str.split(" ");
        //定义一个map集合，统计每个单词出现的次数
        HashMap<String,Integer> map = new HashMap<>();
        //遍历数组放入map，每次放入前判断是否存在该字符串，每次放入前判断是否存在该字符串，存在则出现次数记为现有值+1，不存在则出现次数记为1.
        for (String aStr:str1) {
            //进行判断，遍历
            map.put(aStr,map.containsKey(aStr)? map.get(aStr)+ 1: 1);
        }
        //利用set去计算集合中单词的个数
        Set<Map.Entry<String,Integer>> set = map.entrySet();

        //遍历集合并打印
        for (Map.Entry<String,Integer> me: set) {
            //返回所有的key和value值
            System.out.print(me.getKey());
            System.out.println(me.getValue());
        }
    }
}

//创建一个list集合的对象，添加几条数据，将1号位和2号位交换；获得最大值，最小值打印出来，最后再遍历该集合并把元素打印出来
class DemoList{
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list.toString());
        //get(),通过索引获取元素,获取第一位元素
        System.out.println("List集合的第一位元素："+list.get(1));
        //获取第二位元素
        System.out.println("List集合的第二位元素："+list.get(2));
        //将第一位元素和第二位元素进行交换，用中间值temp表示
        int temp = (int)list.get(1);
        list.set(1,list.get(2));
        list.set(2,temp);
        //用遍历的方法获取最大值和最小值
        int max = (int)list.get(0);
        int min = (int)list.get(0);
        for(int i = 0; i < list.size(); i++){
            if(max > (int)list.get(i)){
                max = (int) list.get(i);
            }
            if(min < (int)list.get(i)){
                min = (int) list.get(i);
            }
        }
        System.out.println("最大值"+max);
        System.out.println("最小值"+min);
        //遍历该集合并把元素打印出来
        /*
        //通过for循环
        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }

         */
        /*
        //通过foreach循环
        for (Object m:list) {
            System.out.println(m);
        }

         */
        //通过迭代器遍历输出集合中的元素
        Iterator ite = list.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }


    }
}
/**
 * 创建一个ArrayList集合（数据类型为String）,向集合中添加5个元素，完成以下需求：
 * 1、打印集合中元素的个数
 * 2、打印索引为2、3的元素
 * 3、删除索引为3的元素
 * 4、修改索引为2的元素
 * 遍历该集合并把元素打印出来
 */
class DemoList2{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //往集合中添加元素
        list.add("吴彦祖");
        list.add("陈冠希");
        list.add("卡尔");
        list.add("史蒂芬");
        list.add("托尼");
        System.out.println("集合中元素的个数为："+list.size());
        //System.out.println(list.get(0));
        System.out.println("索引为2的元素："+ list.get(2));
        System.out.println("索引为3的元素："+ list.get(3));
        list.remove(3);
        list.set(3,"卡特");
        //遍历集合并把元素打印出来
        Iterator ite = list.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }
    }
}
/**
 * 定义一个长度为10的int数组，系统随机产生0-100内（包含100）的随机数存放在数组内，再将数组中的元素添加到集合中，并遍历打印出来。
 */
class DemoList3{
    public static void main(String[] args) {
        Integer [] array = new Integer[10];
        /*
        //系统随机产生0-100内（包含100）的随机数存放在数组内
        Random random = new Random();
        for (int i = 0; i <array.length;i++){
            array[i] = random.nextInt(101);
        }
        System.out.println("把数组中的元素打印出来"+Arrays.toString(array));
        //再将数组中的元素添加到集合中，并遍历打印出来
        ArrayList<Integer> list = new ArrayList<>();
        list.add(array[0]);
        list.add(array[1]);
        list.add(array[2]);
        list.add(array[3]);
        list.add(array[4]);
        list.add(array[5]);
        list.add(array[6]);
        list.add(array[7]);
        list.add(array[8]);
        list.add(array[9]);
        System.out.println(list.toString());
        //添加到集合中之后并遍历打印出来
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

         */
        //系统随机产生0-100内（包含100）的随机数存放在数组内
        for(int i = 0; i<array.length;i++){
            array[i] = (int)(100*Math.random());
        }
        System.out.println("把数组中的元素打印出来"+Arrays.toString(array));
        //再将数组中的元素添加到集合中，并遍历打印出来
        List<Integer> list = Arrays.asList(array);
        System.out.println(list.toString());
        /*
        //添加到集合之后并打印出来
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

         */
        //遍历集合的其他方法
        for (Integer m: list) {
            System.out.println(m);
        }
    }
}

/**
 * 把如下元素存入List集合
 * "aaa" "bbb" "abc" "xyz" "123" "xyz"
 * 去掉重复的元素，并遍历打印出来
 */
class DemoList4{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("abc");
        list.add("xyz");
        list.add("123");
        list.add("xyz");
        System.out.println(list.toString());
        //定义一个set集合，来去掉重复的元素
        HashSet<String> set = new HashSet<>();
        set.add(list.get(0));
        set.add(list.get(1));
        set.add(list.get(2));
        set.add(list.get(3));
        set.add(list.get(4));
        set.add(list.get(5));
        System.out.println(set.toString());
        //遍历集合set，并打印出来
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
/**
 * 创建一个LinkedList集合的对象，完成以下操作：
 * 1、向该集合添加5个元素(类型自己定义)，并打印出来。
 * 2、删除第一个和最后一个元素，再将删除后的集合打印出来
 * 3、从键盘输入两个元素，分别添加到删除后的集合中的第一个位置和最后一个位置，并打印出来。
 */

class DemoList5{
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("北京");
        linkedList.add("上海");
        linkedList.add("杭州");
        linkedList.add("南京");
        linkedList.add("武汉");
        //打印集合中的元素
        System.out.println(linkedList.toString());
        linkedList.remove(0);
        linkedList.remove(linkedList.size() - 1);
        System.out.println(linkedList.toString());
        //从键盘输入两个元素，分别添加到删除后的集合中的第一个位置和最后一个位置
        Scanner scanner = new Scanner(System.in);
        System.out.println("添加元素到第一个位置");
        String str1 = scanner.nextLine();
        System.out.println("添加元素到最后一个位置");
        String str2 = scanner.nextLine();
        linkedList.add(0,str1);
        linkedList.add(linkedList.size() ,str2);
        //遍历新的集合并打印出来
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

//创建一个HashSet集合的对象，从键盘输入5个数，分别将这5个数添加到集合中，并打印出来输入的5个数和集合中的数。
class DemoSet6{
    public static void main(String[] args) {
        //HashSet<Integer> set = new HashSet<>();
        System.out.println("从键盘输入5个数，分别将这5个数添加到集合中");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入的5个数为:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        /*
        //方法一：集合Set添加多个元素
        Integer[] x = new Integer[]{a,b,c,d,e};
        Collections.addAll(set,x);

         */
        //方法二：集合Set添加多个元素
        HashSet<Integer> set = new HashSet<>(Arrays.asList(a,b,c,d,e));
        /*
        //把5个元素添加到集合中
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        set.add(e);

         */
        //打印出来输入的5个数和集合中的数
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

//利用Set的相关知识完成以下需求：
//键盘录入一个字符串，去掉其中重复字符，然后打印出不同的那些字符，必须保证顺序。例如输入：aaaabbbcccddd,打印结果为：abcd。
class DemoSet7{
    public static void main(String[] args) {
        System.out.println("键盘录入一个字符串，去掉其中重复字符，然后打印出不同的那些字符");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入的字符串为：");
        String str = scanner.nextLine();
        //把一行字符串转换为字符数组
        char[] strToChar = str.toCharArray();
        //打印字符串的每一个字符
        for (char aChar: strToChar) {

            System.out.print(aChar);
        }
        System.out.println("");
        //定义一个set集合来去除字符串中相同的字符
        HashSet<Character> set = new HashSet<>();
        for (char aChar: strToChar) {
            set.add(aChar);
        }
        /*
        //然后打印集合中的元素
        System.out.print(set.toString());
        \
         */
        /*
        //遍历打印集合中的元素
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
         */
        //方法二：可以将集合转换成一个数组，然后再打印出来
        Object[] objects = set.toArray();
        //去掉重复元素后的结果为：
        for (Object a: objects) {
            System.out.print(a);
        }
    }
}



