//package hello.leetcode;
//
///**
// * Created by pandeyu on 17/11/26.
// */
//public class MedianofTwoSortedArrays {
//
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int length = (nums1.length+nums2.length)/2 ;
//        int single = (nums1.length+nums2.length)%2 ;
//
//        int first_index = length;
//        int seconde_index =-1;
//
//        int first,second;
//        if(single ==0)
//            seconde_index =  first_index-1;
//
//        int nums1_index=0;
//        int nums2_index=0;
//        for(;(nums1.length>nums1_index&&nums2.length>nums2_index);first_index--){
//            if(--first_index==0){
//
//            }
//            if(nums1[nums1_index]<nums2[nums2_index]){
//                nums1_index++;
//            }else if(nums1[nums1_index]>nums2[nums2_index]){
//                nums2_index++;
//            }else{
//                nums1_index++;
//                nums2_index++;
//            }
//
//
//        }
//    }
//
//    public  static void main(String[] args){
//        System.out.println((1+2)/2);
//    }
//
//
//}
