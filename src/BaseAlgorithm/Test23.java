package BaseAlgorithm;

import java.util.*;

/**
 * 手写抽奖算法
 * 解题思路：
 * 1、获取抽奖人数。
 * 2、设置幸运值，并得出n个人对应的幸运值
 * 3、打印输出
 */
public class Test23 {
    public static void main(String[] args) {
        //获取参与抽奖人员
        List<String> users = getUsers();
        //根据人员获取幸运值
        Map<Integer,Integer> luckMap = getLuckyMap(users.size());
        //最大的幸运数
        Integer bigest = 0;
        //最幸运的人
        Integer bigestTarget = 0;
        //使用keySet()方法获取所有的key值
        for (Integer lucker : luckMap.keySet()){
            Integer temp = luckMap.get(lucker);
            if(temp > bigest){
                bigestTarget = lucker;
                bigest = temp;
            }
            /*
            Map<Integer,String> map = new LinkedHashMap<Integer,String>();
            map.put(1,"星期一");
            map.put(2,"星期二");
            map.put(3,"星期三");
            map.put(4,"星期四");
            map.put(5,"星期五");
            map.put(6,"星期六");
            map.put(7,"星期日");
            for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
            }

             */
            System.out.println("抽奖人员【"+ users.get(lucker) + "】的幸运值为：" + temp);
        }
        System.out.println("------------噔噔蹬蹬------------");
        System.out.println("最终的赢家为：" + users.get(bigestTarget));
    }

    private static Map<Integer, Integer> getLuckyMap(Integer userNum) {
        Map<Integer,Integer> luckyMap = new HashMap<>();
        for (int i = 0; i < 100; i++){
            Random random = new Random();
            Integer luckyer = random.nextInt(userNum);
            //表示得到的是key值
            Integer count = luckyMap.get(luckyer) == null ? 0 : luckyMap.get(luckyer);
            luckyMap.put(luckyer,++count);
        }
        return luckyMap;
    }

    private static List<String> getUsers() {
        List<String> list = new ArrayList<>();
        list.add("一号种子选手");
        list.add("二号种子选手");
        list.add("三号种子选手");
        list.add("四号种子选手");
        return list;
    }
}
