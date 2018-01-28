package hello.leetcode;

/**
 * Created by pandeyu on 18/1/20.
 */
public class TrappingRainWater42 {
    public int trap(int[] height) {

        int maxid = -1, max = 0;
        for(int i=0;i<height.length;i++){
            if(max<height[i]){
                max = height[i];
                maxid = i;
            }
        }

        int root=0,area=0;
        for(int i=0; i<maxid;i++){
            if(root<height[i]) root = height[i];
            else area+=root-height[i];
        }

        root = 0;
        for(int i=height.length-1;i>maxid;i--){
            if(root<height[i]) root = height[i];
            else area += root-height[i];
        }

        return area;
    }

    public static void main(String[] args){
        int[] num = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater42 t = new TrappingRainWater42();
        System.out.println(t.trap(num));
    }
}
