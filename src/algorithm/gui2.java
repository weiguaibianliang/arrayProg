package algorithm;

//已知:鸡兔共35只,共94只脚,那么鸡和兔各几只?
public class gui2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 35; i++) {
            for (int j = 0;j<=35;j++){
                if(i+j ==35&&2*i+4*j==94){
                    System.out.println(i);
                    System.out.println(j);

                }
            }
            /*
            if (j * 2 + i * 4 == 94) {
                System.out.println(i);
            }

             */
        }
    }
}
