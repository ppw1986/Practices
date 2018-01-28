package hello.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pandeyu on 18/1/22.
 */
public class TrappingRainWaterII407 {

    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null||heightMap.length==0 || heightMap[0].length==0){
            return 0;
        }
        int m  = heightMap.length;
        int n  = heightMap[0].length;
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(2 * m + 2 * n, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.h-o2.h;
            }
        });
        boolean[][] visitArr = new boolean[m][n];
        for(int i=0;i<m;i++){
            visitArr[i][0] = true;
            visitArr[i][n-1] = true;
            queue.offer(new Cell(i,0,heightMap[i][0],false));
            queue.offer(new Cell(i,n-1,heightMap[i][n-1],false));
        }

        for(int i=0; i<n;i++){
            visitArr[0][i] = true;
            visitArr[m-1][i] = true;
            queue.offer(new Cell(0,i,heightMap[0][i],false));
            queue.offer(new Cell(m-1,i,heightMap[m-1][i],false));
        }

        int[] xn={1,-1,0,0};
        int[] yn={0,0,1,-1};


        int sum =0;
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            for(int i= 0;i<xn.length;i++){
                int x = cell.x+xn[i];
                int y = cell.y+yn[i];
                if(x>0&&x<m&&y>0&&y<n&&visitArr[x][y]==false){
                    visitArr[x][y] = true;
                    int height = Math.max(0,cell.h-heightMap[x][y]);
                    sum +=height;
                    queue.offer(new Cell(x,y,Math.max(heightMap[x][y],cell.h),false));
                }
            }
        }
        return sum;
    }

    class Cell{
        public Cell(int x, int y, int h, boolean visited) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.visited = visited;
        }

        public int x;
        public  int y;
        public int h;
        public boolean visited =false;
    }

    public static void main(String[] args){
        TrappingRainWaterII407 t = new TrappingRainWaterII407();
        System.out.println(t.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
    }
}
