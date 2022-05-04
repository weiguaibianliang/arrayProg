package algorithm;
//二维数组的二分法,要背，把一维数组的记清楚。
class binerySearch2{
    /*
    有序的二维数组二分法
    */
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        int[] res = search(arr,1);
        String str = java.util.Arrays.toString(res);
        System.out.println(str);
    }
    static int[] search(int[][] arr, int a){
        int minIndex_x = 0;
        int minIndex_y = 0;
        int maxIndex_x = arr.length-1;
        int maxIndex_y = arr[0].length-1;
        int halfIndex_x = minIndex_x + (maxIndex_x - minIndex_x)/2;
        int halfIndex_y = minIndex_y + (maxIndex_y - minIndex_y)/2;
        int x = arr.length-1;
        int y = arr[0].length-1;
        while (minIndex_y <= maxIndex_y && minIndex_x <= maxIndex_x){
            if (a==arr[halfIndex_x][halfIndex_y]){
                int[] res = {halfIndex_x,halfIndex_y};
                return res;
            }else if (a>arr[halfIndex_x][halfIndex_y]){
                // 搜索值比中间值大
                if (halfIndex_y==y & halfIndex_x != x){
                    minIndex_x = halfIndex_x + 1;
                    minIndex_y = 0;
                }else{
                    minIndex_y = halfIndex_y + 1;
                }

            }else{// 搜索值比中间值小
                if (halfIndex_y==0 & halfIndex_x != 0){
                    maxIndex_x = halfIndex_x - 1;
                    maxIndex_y = y;
                }else{

                    maxIndex_y = halfIndex_y - 1;
                }

            }
            halfIndex_x = minIndex_x + (maxIndex_x - minIndex_x)/2;
            halfIndex_y = minIndex_y + (maxIndex_y - minIndex_y)/2;
        }
        int[] res_null = {-1,-1};
        return res_null;

    }

}
