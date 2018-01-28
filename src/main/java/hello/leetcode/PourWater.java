package hello.leetcode;

/**
 * Created by pandeyu on 18/1/18.
 */
public class PourWater {

    public int[] pourWater(int[] heights, int V, int K) {
//        int temp = V;
//        V = K ;
//        K = temp;
//
//        if(V<0 || V>=heights.length){
//            return heights;
//        }
//
//        int left =V-1;
//        int right = V+1;
//
//        for(; K>0; K--){
//            heights[V] = heights[V]+1;
//            int grap = 0;
//            int index = V;
//
////            for(int left = V-1; left>=0 && heights[left]<heights[left+1];left--){
////                if(heights[V]-heights[left]> grap){
////                    grap = heights[V]-heights[left];
////                    index = left;
////                }
////            }
////
////            for(int right = V+1; right<heights.length && heights[right]<heights[right-1];right++){
////                if(heights[V]-heights[right]>grap){
////                    grap = heights[V] - heights[right];
////                    index = right;
////                }
////            }
////
////            if(grap>1){
////                heights[index]= heights[index]+1;
////                heights[V] = heights[V] -1;
////            }
//
//                for(int start = V-1; start>=0 && heights[start]<heights[start+1];start--){
//                    if(heights[V]-heights[start]>grap){
//                        grap = heights[V] - heights[start];
//                        index = start;
//                    }
//                }
//
//                for (int start = V+1; start<heights.length && heights[start]< heights[start-1];start++){
//                    if(heights[V]-heights[start]>grap){
//                        grap = heights[V] - heights[start];
//                        index = start;
//                    }
//                }
//                if(grap>1){
//                    heights[V]--;
//                    heights[index]++;
//                }
//        }
//
//        return  heights;

        if (heights == null || heights.length == 0 || V == 0) {
            return heights;
        }
        int index;
        while (V > 0) {
            index = K;
            for (int i = K - 1; i >= 0; i--) {
                if (heights[i] > heights[index]) {
                    break;
                } else if (heights[i] < heights[index]) {
                    index = i;
                }
            }
            if (index != K) {
                heights[index]++;
                V--;
                continue;
            }
            for (int i = K + 1; i < heights.length; i++) {
                if (heights[i] > heights[index]) {
                    break;
                } else if (heights[i] < heights[index]) {
                    index = i;
                }
            }
            heights[index]++;
            V--;
        }
        return heights;
    }

    public  static void main(String[] args){
        PourWater p = new PourWater();
        for(int i : p.pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1},5,5))
            System.out.print(i);
    }

}
