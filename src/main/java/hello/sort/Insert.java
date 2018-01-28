package hello.sort;

import java.util.Arrays;

/**
 * Created by pandeyu on 17/12/6.
 */
public class Insert {

    public void insert(int[] arr){

        int i,j;

        for(i=0;i<arr.length;i++){
            j = i;
            int min = arr[i];
            int index = i;
            for(;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            if(index!=i){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};
        new Insert().insert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
