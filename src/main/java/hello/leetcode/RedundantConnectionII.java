package hello.leetcode;

import java.util.*;

/**
 * Created by pandeyu on 17/11/27.
 */
public class RedundantConnectionII {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        if(edges==null||edges.length==0||edges[0].length==0){
            return new int[0];
        }

        int root  = edges[0][0];
        Set<Integer> nodeSet = new HashSet<Integer>();

        int[] result =null;

        for(int[] first : edges){
            int toNode  = first[1];
            if(toNode==root){
                return first;
            }

            if(nodeSet.contains(toNode)){
                result=first;
                break;
            }

            nodeSet.add(toNode);
        }

        if(result==null){
            return edges[0];
        }else {
            if(hasCircle(edges,result)){
                return getAnother(edges,result);
            }
            return result;
        }

    }

    private int[] getAnother(int[][] edges, int[] result) {
        for (int[] i : edges){
            if(i.equals(result)){
                continue;
            }

            if(i[1]==result[1]){
                return i;
            }
        }
        return null;
    }

    private boolean hasCircle(int[][] edges, int[] result) {
        Map<Integer,Integer> circleMap = new HashMap<Integer, Integer>();
        int flag;
        if(edges[0].equals(result))
            flag = edges[1][0];
        else
            flag = edges[0][0];

        for (int[] i : edges){
            if(i.equals(result)){
                continue;
            }

            circleMap.put(i[0],i[1]);
        }

        int i = flag;
        while (true){
            if(flag==circleMap.get(i))
                return true;
            i = circleMap.get(i);
        }
    }


    public int[] findRedundantDirectedConnection2(int[][] edges) {
        // 判断有么有2个parent节点
        int[] in = new int[edges.length+4];
        boolean has2parent = false;
        int[] has2parentPos = new int[2];
        for(int i=0; i<edges.length; i++) {
            int[] t = edges[i];
            in[t[1]]++;
            if(in[t[1]] == 2) {
                has2parent = true;
                has2parentPos[1] = i;
                for(int j=0; j<i; j++)
                    if(edges[j][1] == t[1]) {
                        has2parentPos[0] = j;
                        break;
                    }
                break;
            }
        }

        int[] ret = findRedundantConnection(edges, -1);

        if(!has2parent) return ret;
        if(ret == null)return edges[has2parentPos[1]];
        if(findRedundantConnection(edges, has2parentPos[0])==null)
            return edges[has2parentPos[0]];
        else
            return edges[has2parentPos[1]];
    }

    // 找有向图中的环
    public int[] findRedundantConnection(int[][] edges, int p) {
        int[]root = new int[edges.length+4];
        for(int i=0; i<root.length; i++) root[i] = i;

        for(int q=0; q<edges.length; q++) {
            if(p == q)  continue;
            int i=edges[q][0], j=edges[q][1];

            for(int k=0; k<root.length; k++) {
                if(root[k] == j)
                    root[k] = root[i];
            }

            if(root[i] == j)    return edges[q];
        }

        return null;
    }

    public static  void main(String[] args){
        int[][] edges = {{5,2},{5,1},{3,1},{3,4},{3,5}};
//                {{1,2},{1,3},{2,3}};
//                {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        RedundantConnectionII r = new RedundantConnectionII();
        for(int i :r.findRedundantDirectedConnection2(edges))
            System.out.print(i);

    }
}
