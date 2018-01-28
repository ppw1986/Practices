package hello.sort;

import java.util.Arrays;

/**
 * Created by pandeyu on 17/12/5.
 */
public class Heap {

    public void sort(int[] data){

        int tail = data.length-1;
        int index = (tail -1)>>1;

        for(int i = index; i>0;i--){
            forHeap(data,i,tail);
        }

        for(int i = tail; i>0; i--){
            swap(data,0,i);
            forHeap(data,0,i-1);
        }
    }

    private void forHeap(int[] data, int index, int tail) {
        int li = (index<<1) +1;
        int ri = li+1;
        int max = li;

        if(li>tail) return;
        if(ri<=tail&&data[ri]>data[li]){
            max = ri;
        }

        if(data[max]>data[index]){
            swap(data,index,max);
            forHeap(data,max,tail);
        }
    }

    private void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};
        new Heap().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
