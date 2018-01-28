package hello.leetcode;

import java.util.*;

/**
 * Created by pandeyu on 18/1/22.
 */
public class FindMedianfromDataStream295 {

    /** initialize your data structure here. */
    public FindMedianfromDataStream295() {


    }

    Queue<Integer> maxH = new PriorityQueue<Integer>(16,Collections.<Integer>reverseOrder());
    Queue<Integer> minH = new PriorityQueue<>();




    public void addNum(int num) {
        minH.offer(num);
        num = minH.poll();
        maxH.offer(num);
        if(maxH.size()>minH.size()){
            num = maxH.poll();
            minH.offer(num);
        }
    }

    public double findMedian() {
        if(maxH.size()==minH.size()){
            return (maxH.peek()+minH.peek())/2.0;
        }else {

            return  maxH.size()>minH.size()?maxH.peek():minH.peek();
        }
    }

    public static void main(String[] args){
        FindMedianfromDataStream295 f = new FindMedianfromDataStream295();
        f.addNum(1);
        f.addNum(2);
        System.out.print(f.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */