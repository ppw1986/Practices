package hello.sort;

import java.util.Arrays;

/**
 * Created by pandeyu on 17/12/6.
 */
public class Choice {

    public void choice(int[] arr){

        int i ,j;
        for(i=1; i<arr.length;i++){

            int temp = arr[i];
            for(j = i-1;j>=0&&arr[j]>temp;j--){
                arr[j+1]= arr[j];
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};
        new Choice().choice(arr);
        System.out.println(Arrays.toString(arr));
    }

}
