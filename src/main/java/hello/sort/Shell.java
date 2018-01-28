package hello.sort;

import java.util.Arrays;

/**
 * Created by pandeyu on 17/12/4.
 */
public class Shell {

    public static void shell_sort(int[] arr) {

        int gap = arr.length/2,i,j;

        while(gap>=1){

            for( i =gap; i<arr.length;i++){

                int temp = arr[i];
                for( j = i-gap; j>=0&& arr[j]>temp;j=j-gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = temp;
            }

            gap = gap/2;
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};
        new Shell().shell_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
