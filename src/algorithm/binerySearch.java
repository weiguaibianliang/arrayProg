package algorithm;
//在进行二分法之前要进行排序
import java.util.Arrays;
public class binerySearch {
    public static void main(String[] args) {
        int[] array = {30,60,50,20,70,200,500,58,67,35,45};
        int searchWord = 67;//所要查找的数
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(searchWord+"元素的索引："+binerySearch(array,searchWord));//二分法查找输出的结果
    }
    public static int binerySearch(int[]array,int value){
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int middle = (low+high)/2;
            if(value==array[middle]){
                return middle;//返回查询到的索引位置
            }
            if(value>array[middle]){
                low = middle+1;
            }
            if(value<array[middle]){
                high = middle -1;
            }

        }
        return -1;//上面循环完毕，说明未找到，返回-1。
    }

}
