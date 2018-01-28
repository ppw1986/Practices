package hello.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by pandeyu on 17/12/1.
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(nums.size(), new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int end = Integer.MIN_VALUE;
        int range = -1;

        for(int i = 0 ; i<nums.size();i++){
            queue.add(new int[]{nums.get(i).get(0),i,0});
            if(nums.get(i).get(0)>end){
                end = nums.get(i).get(0);
            }

        }

        int start  = queue.peek()[0];
        range  = end - start;

        while(queue.size() == nums.size()){
            int[] temp = queue.poll();

            if(end - temp[0]<range){
                range = end - temp[0];
                start = temp[0];
            }


            if(temp[2]+1<nums.get(temp[1]).size()){
                queue.add(new int[]{nums.get(temp[1]).get(temp[2]+1),temp[1],temp[2]++});

                if(temp[0] > end){
                    end = temp[0];
                }
            }

        }
        return new int[]{start, start+range};
    }

    public static void main(String[] args){
        List<Integer> l = new ArrayList<>();
        l.add(new Integer(1));
        System.out.println(l.contains(1));
    }
}
