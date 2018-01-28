package hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pandeyu on 17/11/26.
 */
public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        if(root==null)
            return new ArrayList<List<String>>();

        int hight = getHight(root);
        int n = (int)Math.pow(2,hight) -1;
        List<List<String>> result = new ArrayList<List<String>>();

        for(int i =0 ; i<hight ; i++){
            List<String> l = new ArrayList();
            result.add(l);
        }

        for(int i = 0 ;i <result.size(); i++){
            for(int j =0; j<n;j++)
                result.get(i).add("");
        }

        setCur(result,root,0,n,0, hight);

        return result;
    }

    public void setCur(List<List<String>> result, TreeNode root, int i, int n, int level, int hight){
        if(i>n || level>= hight|| root==null)
            return ;

        int mid = (i+n)/2;
        result.get(level).set(mid,String.valueOf(root.val));
        setCur(result,root.left,i,mid-1,level+1,hight);
        setCur(result,root.right,mid+1,n,level+1,hight);

    }

    public int getHight(TreeNode root) {
        if(root==null){
            return 0;
        }

        int leftDep = getHight(root.left);
        int rightDep = getHight(root.right);

        if(leftDep>rightDep){
            return  leftDep+1;
        }else {
            return  rightDep+1;
        }
    }


    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public  TreeNode init() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        b.right =a;
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        d.left = b; d.right = c;
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        f.left = e; f.right = d;
        TreeNode g = new TreeNode(7);
        g.right = f;
        TreeNode h = new TreeNode(8);
        h.right = g;
        return h;// root
    }

    public  static void main(String[] args){
        PrintBinaryTree p = new PrintBinaryTree();
        TreeNode t = p.init();
        System.out.println(p.printTree(t));
        
    }
    
}
