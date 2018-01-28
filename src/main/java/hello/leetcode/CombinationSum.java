package hello.leetcode;

import java.util.*;

/**
 * Created by pandeyu on 17/11/26.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();

        sum(candidates,result,set,target,0,0);

        for (List<Integer> l : result){
            for(Integer i : l){
                System.out.print(i);
                System.out.print(",");
            }
            System.out.println();
        }
        return result;
    }

    public void sum(int[]candidates,List<List<Integer>> result, List<Integer> list ,int target, int sum, int index){

        if(sum>target){
            return ;
        }

        if(sum==target){
            result.add(list);
            return;
        }

        for(int i = index;i<candidates.length;i++){
            int candidate = candidates[i];
//        for(int candidate : candidates){

            List<Integer> r = new ArrayList<Integer>(list);

            r.add(candidate);
            sum(candidates,result,r,target,sum+candidate,i);
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates); // sort the array
        recurse(new ArrayList<Integer>(), target, candidates, 0, result);
        return result;
    }

    /**
     * do it recursively
     */
    private void recurse(List<Integer> list, int target, int[] candidates, int index, List<List<Integer>> result) { // list is one of the answers
        if (target == 0) {
            result.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i]; // subtract candidate from target
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<Integer>(list); // create a copy
                copy.add(candidates[i]);
                recurse(copy, newTarget, candidates, i, result); // see if there is more
            } else { // run out of target
                break;
            }
        }
    }


    public static  void main(String[] args){
        int[] candidates= {2,3,7};
        CombinationSum c = new CombinationSum();
        c.combinationSum(candidates,7);
//        List<List<Integer>> r =  c.combinationSum2(candidates,7);
//        System.out.println(r);
    }
}
