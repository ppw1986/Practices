package hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pandeyu on 17/11/26.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();
        generate(n,n,"",result);

        for(String s : result)
            System.out.println(s);

        return result;
    }


    public void generate(int left, int right , String out, List<String> result){

        if((left <0 || right<0) || left>right) return;

        if(left==0 &&right==0){
            result.add(out);
        }

        generate(left-1,right,out+"(", result);
        generate(left,right-1,out+")",result);
    }

    public static void main(String[] args){
        GenerateParentheses g = new GenerateParentheses();
        g.generateParenthesis(4);
    }
}
