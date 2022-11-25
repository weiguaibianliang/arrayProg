package BaseAlgorithm;

/**
 * 两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。以抽签决定比赛名单。有人向队员打听比赛的名单。
 * a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 */
public class Test18 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 1; i <= 3; i++){
            if(i != 1 && i!= 3){
                x = i;
            }
        }
        for (int i = 1; i <= 3; i++){
            if(i != 3 && i != x){
                z = i;
            }
        }
        for (int i = 1; i <= 3; i++){
            if(i != x && i != z){
                y = i;
            }
        }
        System.out.println("甲队的入场顺序为：");
        System.out.println("a的出场顺序为："+ a);
        System.out.println("b的出场顺序为："+ b);
        System.out.println("c的出场顺序为："+ c);
        System.out.println("乙队的入场顺序为：");
        System.out.println("x的出场顺序为："+ x);
        System.out.println("y的出场顺序为："+ y);
        System.out.println("z的出场顺序为："+ z);
    }
}
