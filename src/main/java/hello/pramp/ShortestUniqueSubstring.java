package hello.pramp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pandeyu on 17/12/17.
 */
public class ShortestUniqueSubstring {

    static String getShortestUniqueSubstring(char[] arr, String str) {
        // your code goes here
        List<Character> list = new ArrayList();

        int left, right,min;
        String sub = "";
        left  =0;
        min = Integer.MAX_VALUE;


        for(;left<=(str.length()-arr.length);left++){
            list.clear();
            for(char c :arr){
                list.add(c);
            }

            for( right =left; right<str.length()&&list.size()!=0;right++){
                if(list.contains(str.charAt(right))){
                    list.remove(Character.valueOf(str.charAt(right)));
                }
            }

            if(list.size()!=0){
                continue;
            }

            if(right-left <= min&&list.isEmpty()){
                min = right - left;
                sub = str.substring(left,right);
            }
        }

        if(min<Integer.MAX_VALUE){
            return sub;
        }else{
            return "";
        }


    }

    static String getShortestUniqueSubstring2(char[] arr, String str) {

        Map<Character,Integer> arrMap = new HashMap();
        int arrCount = 0;
        int left = 0;
        int resultLength = Integer.MAX_VALUE;
        String resultStr = "";

        for(char c : arr){
            arrMap.put(c,0);
        }

        for(int i = 0 ;i<str.length();i++){
            char c = str.charAt(i);

            if(arrMap.containsKey(c)){
                if(arrMap.get(c)==0){
                    arrCount++;
                }
            }else {
                continue;
            }
            arrMap.put(c, arrMap.get(c)+1);

            while(arrCount==arr.length){
                if(i-left+1<resultLength){
                    resultLength = i-left+1;
                    resultStr = str.substring(left,i+1);
                }

                char removeChar = str.charAt(left);
                left++;

                if(!arrMap.containsKey(removeChar)){
                    continue;
                }
                arrMap.put(removeChar,arrMap.get(removeChar)-1);
                if(arrMap.get(removeChar)==0){
                    arrCount--;
                }

            }
        }

        return resultStr;
    }

    public static void main(String[] args) {

//        System.out.print(ShortestUniqueSubstring.getShortestUniqueSubstring2(new char[]{'x','y','z'}, "xyyzyzyx"));
//        System.out.print(ShortestUniqueSubstring.getShortestUniqueSubstring2(new char[]{'A','B','C','E','K','I'}, "KADOBECODEBANCDDDEI"));
        System.out.print(ShortestUniqueSubstring.getShortestUniqueSubstring2(new char[]{'A','B','C'}, "ADOBECODEBANCDDD"));
    }

}
