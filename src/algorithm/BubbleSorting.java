package algorithm;
//冒泡排序的基础算法，比较直观，看自己个人意愿选择哪种方式
import java.util.Arrays;
public class BubbleSorting {
    public static void main(String[]args){
        int[] values = {3,1,6,2,9,0,7,4,5,8};
        bubbleSort(values);
        System.out.println(Arrays.toString(values));
    }
    public static void bubbleSort(int[] values){
        int temp;
        for(int i = 0;i<values.length;i++){
            for(int j = 0;j<values.length-1-i;j++){
                if (values[j] > values[j+1]) {
                    temp = values[j];
                    values[j]=values[j+1];
                    values[j+1]=temp;
                }

            }
        }
    }
}
