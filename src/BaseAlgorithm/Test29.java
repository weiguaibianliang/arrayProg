package BaseAlgorithm;

public class Test29 {
    public static void main(String[] args) {

    }
    public  int search(int num){
        int[] arr = {11,10,8,9,7,22,23,0};
        for (int i = 0; i < arr.length; i++){
            if(num==arr[i]){
                return i;
            }
        }
        return -1;
    }

}

