package hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pandeyu on 17/11/30.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if(s.length()<t.length()){
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        int right =0;int left = 0; int count =0;
        String min = "";

        Map<Character,Integer> dicMap = new HashMap<>();
        do{

            if (count<t.length()){
                if(right<s.length()){
                    char c  = s.charAt(right);
                    if(map.containsKey(c)){

                        if(dicMap.containsKey(c)){
                            if(dicMap.get(c)<map.get(c)){
                                count++;
                            }
                            dicMap.put(c,dicMap.get(c)+1);
                        }else{
                            dicMap.put(c,1);
                            count ++;
                        }
                    }
                }
                right++;
            }

            if(count == t.length()){
                String temp  = s.substring(left,right);
                if(min.equals("")|| temp.length()<min.length()){
                    min = temp;
                }

                char c2 = s.charAt(left);
                if(dicMap.containsKey(c2)){
                    dicMap.put(c2,dicMap.get(c2)-1);
                    if(dicMap.get(c2)<map.get(c2)){
                        count --;
                    }
                }
                left ++;
            }

        }while (right <=s.length()&&left<right);

        return min;

    }


    public  static void main(String[] args){
        MinimumWindowSubstring m  =new MinimumWindowSubstring();
        System.out.println(m.minWindow("aa","aa"));
    }
}
