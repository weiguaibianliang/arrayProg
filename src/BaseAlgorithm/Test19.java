package BaseAlgorithm;

/**
 * 有5个人坐在一起，问第五个人多少岁？他说比第四个人大2岁。
 * 问第四个人岁数，他说比第三个人大2岁。问第三个人，又说比第2个人大两岁。
 * 问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
 */
public class Test19 {
    public static void main(String[] args) {
        int a = 10;
        for(int i = 4; i > 0; i--){
            a = a + 2;
        }
        System.out.println("第五个人的岁数为："+ a);
    }
}
