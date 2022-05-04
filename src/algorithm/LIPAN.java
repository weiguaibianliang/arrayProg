package algorithm;

public class LIPAN {
    public static void main(String[] args) {
        char grade = 'C';
        switch (grade) {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("及科");
                break;
            case 'D':
                System.out.println("挂科");
                break;
            default:
                System.out.println("错误");
        }
    }
}

